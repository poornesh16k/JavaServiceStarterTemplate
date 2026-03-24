package com.start.starterapp.example.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ExampleRequest(
        @NotBlank(message = "userId is required")
        String userId,
        @NotNull(message = "value is required")
        Integer value
) {
}
