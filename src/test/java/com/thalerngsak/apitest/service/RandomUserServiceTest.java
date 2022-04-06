package com.thalerngsak.apitest.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thalerngsak.apitest.adaptor.model.response.RandomUserResponse;
import com.thalerngsak.apitest.util.RandomUserCacheHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RandomUserServiceTest {

    @InjectMocks
    private RandomUserService randomUserService;

    @Mock
    private RandomUserCacheHelper randomUserCacheHelper;

    private RandomUserResponse randomUserResponse;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() throws IOException {
        randomUserResponse = new RandomUserResponse();
        randomUserResponse = objectMapper.readValue(new File("src/test/resources/json/randomUserData.json"), RandomUserResponse.class);

    }

    @Test
    public void executeSuccessfully() throws IOException {
       when(randomUserCacheHelper.getRandomUserBySeed(any())).thenReturn(randomUserResponse);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        RandomUserResponse expectResponse = objectMapper.readValue(new File("src/test/resources/json/randomUserData.json"), RandomUserResponse.class);
        String expectedResult = objectMapper.writeValueAsString(expectResponse);
        RandomUserResponse randomUserResponse = randomUserService.getRandomUser("");
        String actualResult = objectMapper.writeValueAsString(randomUserResponse);
       assertEquals(expectedResult, actualResult);
    }
}