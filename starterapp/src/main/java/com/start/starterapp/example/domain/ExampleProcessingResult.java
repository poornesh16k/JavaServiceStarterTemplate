package com.start.starterapp.example.domain;

public record ExampleProcessingResult(
        ProcessingStatus status,
        String requestId
) {
}
