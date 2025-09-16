package com.app.backend.domain.dto.request;

import lombok.Builder;

@Builder
public record SignupRequest(
        String email,
        String password
) {
}
