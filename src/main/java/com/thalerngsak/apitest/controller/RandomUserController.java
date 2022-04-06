package com.thalerngsak.apitest.controller;

import com.thalerngsak.apitest.adaptor.RandomUserAdaptor;
import com.thalerngsak.apitest.adaptor.model.request.RandomUserRequest;
import com.thalerngsak.apitest.adaptor.model.response.RandomUserResponse;
import com.thalerngsak.apitest.service.RandomUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/v1")
@AllArgsConstructor
@RestController
public class RandomUserController {

    private final RandomUserService randomUserService;

    @GetMapping(value = "/user/{seed}")
    public RandomUserResponse callUserAPIBySeed(@PathVariable String seed){
        return randomUserService.getRandomUser(seed);
    }

    @GetMapping(value = "/user")
    public RandomUserResponse callUserAPI() {
        return randomUserService.getRandomUser(null);
    }

}
