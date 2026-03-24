package com.start.starterapp.example.api;

import com.start.starterapp.example.domain.ExampleProcessingResult;

public record ExampleResponse(
        String status,
        String requestId
) {
    public static ExampleResponse from(ExampleProcessingResult result) {
        return new ExampleResponse(result.status().name(), result.requestId());
    }
}
