package com.thalerngsak.apitest.controller;

import com.thalerngsak.apitest.exception.GlobalExceptionHandler;
import com.thalerngsak.apitest.service.RandomUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class RandomUserControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private RandomUserController randomUserController;

    @Mock
    private RandomUserService randomUserService;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(randomUserController)
                .build();
    }

    @Test
    public void callUserAPIBySeed_success() throws Exception {

        mockMvc.perform(get("/v1/user/foo")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void callUserAPI_success() throws Exception {
        mockMvc.perform(get("/v1/user")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }
}