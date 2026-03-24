package com.start.starterapp.common.web;

import java.time.Instant;
import java.util.List;

public record ApiErrorResponse(
        String status,
        String message,
        String requestId,
        List<String> errors,
        Instant timestamp
) {
}
