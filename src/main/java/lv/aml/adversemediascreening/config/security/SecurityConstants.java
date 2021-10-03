package lv.aml.adversemediascreening.config.security;

public class SecurityConstants {

    public static final String SECRET = "SecretKey";
    public static final long EXPIRATION_TIME = 900_000; // 15 minutes
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String TOKEN_COOKIE_NAME = "JWT_token";

}
