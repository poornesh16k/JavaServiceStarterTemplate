package com.start.starterapp.example.application;

import com.start.starterapp.example.api.ExampleRequest;
import com.start.starterapp.example.domain.ExampleProcessingResult;
import com.start.starterapp.example.domain.ProcessingStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleService.class);

    public ExampleProcessingResult process(ExampleRequest request, String requestId) {
        LOGGER.info("Processed example request for userId={} value={} requestId={}",
                request.userId(),
                request.value(),
                requestId);

        return new ExampleProcessingResult(ProcessingStatus.SUCCESS, requestId);
    }
}
