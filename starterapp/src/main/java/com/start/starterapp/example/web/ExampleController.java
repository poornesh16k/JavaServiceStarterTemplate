package com.start.starterapp.example.web;

import com.start.starterapp.common.web.RequestContext;
import com.start.starterapp.example.api.ExampleRequest;
import com.start.starterapp.example.api.ExampleResponse;
import com.start.starterapp.example.application.ExampleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @PostMapping("/example")
    public ResponseEntity<ExampleResponse> process(@Valid @RequestBody ExampleRequest request,
                                                   HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(ExampleResponse.from(
                exampleService.process(request, RequestContext.getRequestId(httpServletRequest))
        ));
    }
}
