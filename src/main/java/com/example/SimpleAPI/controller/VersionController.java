package com.example.SimpleAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/v1/version")
public class VersionController {

    @Autowired
    Environment environment;

    @GetMapping
    public ResponseEntity<HashMap<String, String>> getVersion() {
        HashMap<String, String> response = new HashMap();
        response.put("version", environment.getProperty("app.version"));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
