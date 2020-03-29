package com.example.SimpleAPI.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(VersionController.class)
public class VersionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    Environment environment;

    @Test
    @DisplayName("Test Get version")
    public void getVersion_return_Version() throws Exception {
        final String VERSION = "{\"version\":\"" + environment.getProperty("app.version") + "\"}";
        mockMvc.perform(get("/v1/version/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string(VERSION))
                .andExpect(status().isOk());
    }

}
