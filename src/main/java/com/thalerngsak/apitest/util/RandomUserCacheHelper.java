package com.thalerngsak.apitest.util;

import com.thalerngsak.apitest.adaptor.RandomUserAdaptor;
import com.thalerngsak.apitest.adaptor.model.request.RandomUserRequest;
import com.thalerngsak.apitest.adaptor.model.response.RandomUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class RandomUserCacheHelper {

    private final RandomUserAdaptor randomUserAdaptor;

    @Cacheable(cacheNames = "RANDOM-USER-SEED", key = "'randomuser::seed'", unless = "#result == null")
    public RandomUserResponse getRandomUserBySeed(String seed){
        return randomUserAdaptor.getUser(RandomUserRequest
                .builder()
                .seed(seed)
                .build());
    }
}
