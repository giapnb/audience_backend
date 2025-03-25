package com.techcombank.vn.mr_engine.adapter.in.api;

import com.techcombank.vn.mr_engine.domain.UserAuthContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AudienceController {

    @GetMapping("/")
    @PreAuthorize("hasRole('AUD_MAKER')")
    public String index(@AuthenticationPrincipal Jwt jwt) {

        return String.format("Hello, %s!", jwt.getSubject());
    }

    @GetMapping("/1")
    @PreAuthorize("hasRole('AUD_MAKER1')")
    public String index1(@AuthenticationPrincipal Jwt jwt) {

        return String.format("Hello, %s!", jwt.getSubject());
    }

    @GetMapping("/2")
    @PreAuthorize("hasRole('AUD_MAKER')")
    public String index2( ) {

        return String.format("Hello, %s!", UserAuthContext.getUserEmail());
    }
}
