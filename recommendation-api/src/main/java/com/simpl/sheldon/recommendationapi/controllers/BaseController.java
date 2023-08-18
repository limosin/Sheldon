package com.simpl.sheldon.recommendationapi.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@ControllerAdvice
public class BaseController {
    private static final Logger logger = LogManager.getLogger(BaseController.class);

    public Map<String, String> getDefaultResponse() {
        Map<String, String> responseObject = new HashMap<>();
        responseObject.put("health", "ok");
        return responseObject;
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> home() {
        return new ResponseEntity<>(getDefaultResponse(), HttpStatus.OK);
    }

    @GetMapping(path = "/health-check", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> healthCheck() {
        return new ResponseEntity<>(getDefaultResponse(), HttpStatus.OK);
    }

}
