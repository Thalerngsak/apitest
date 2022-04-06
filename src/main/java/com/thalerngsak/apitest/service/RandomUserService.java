package com.thalerngsak.apitest.service;

import com.thalerngsak.apitest.adaptor.model.response.RandomUserResponse;
import com.thalerngsak.apitest.util.RandomUserCacheHelper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class RandomUserService {

    private final RandomUserCacheHelper randomUserCacheHelper;

    public RandomUserResponse getRandomUser(String seed){

        return randomUserCacheHelper.getRandomUserBySeed(seed);

    }
}
