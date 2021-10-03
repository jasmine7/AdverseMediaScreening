package lv.aml.adversemediascreening.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static lv.aml.adversemediascreening.config.security.SecurityConstants.TOKEN_COOKIE_NAME;

@Component
public class CustomLogoutHandler implements LogoutHandler {

    @Override
    public void logout(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse,
                       Authentication authentication) {
        Cookie cookie = new Cookie(TOKEN_COOKIE_NAME, "deleted");
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
    }
}
