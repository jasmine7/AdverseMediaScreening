package lv.aml.adversemediascreening.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import static lv.aml.adversemediascreening.config.security.SecurityConstants.*;

@Component
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private final JWTTokenUtil jwtTokenUtil;

    @Autowired
    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTTokenUtil jwtTokenUtil) {
        super(authenticationManager);
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String token = getTokenFromCookiesInRequest(request);

        if(token != null && !token.isEmpty()){
            UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request){
        String token = getTokenFromCookiesInRequest(request);
        if(token != null && !token.isEmpty()) {
            String user = jwtTokenUtil.getTokenSubject(token);
            if(user != null){
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }

    private String getTokenFromCookiesInRequest(HttpServletRequest request){
        String token = "";
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie cookie: cookies){
                if(cookie.getName().equals(TOKEN_COOKIE_NAME)){
                    token = cookie.getValue();
                }
            }
        }
        return token;
    }
}
