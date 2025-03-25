package com.techcombank.vn.mr_engine.domain;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Map;

public class UserAuthContext {
    private static Map<String, Object> extractClaim() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        return ((Jwt) principal).getClaims();
    }

    public static String getUserEmail() {
        return (String) extractClaim().get("upn");
    }
}
