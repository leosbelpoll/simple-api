package com.example.SimpleAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/version")
public class VersionController {

    private final String VERSION = "1.0.0";

    @GetMapping
    public ResponseEntity<HashMap<String, String>> getVersion() {
        HashMap<String, String> response = new HashMap();
        response.put("version", VERSION);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
