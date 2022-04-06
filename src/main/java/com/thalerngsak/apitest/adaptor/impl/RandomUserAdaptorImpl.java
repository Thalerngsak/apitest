package com.thalerngsak.apitest.adaptor.impl;

import com.thalerngsak.apitest.adaptor.RandomUserAdaptor;
import com.thalerngsak.apitest.adaptor.model.request.RandomUserRequest;
import com.thalerngsak.apitest.adaptor.model.response.RandomUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Slf4j
@Configuration
public class RandomUserAdaptorImpl implements RandomUserAdaptor {

    @Autowired
    @Qualifier("randomUserAdapterRestTemplate")
    private RestTemplate randomUserAdapterRestTemplate;

    private String baseUrl;

    public RandomUserAdaptorImpl(@Value("${base_url}") String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public RandomUserResponse getUser(RandomUserRequest request) {

        var uri = "";
        if (Objects.nonNull(request.getSeed())){
            uri = "?seed="+request.getSeed();
        }
        var url = this.baseUrl + uri;
        log.info("URL:  {}", url);
        final var response = randomUserAdapterRestTemplate
                .getForObject(url , RandomUserResponse.class);
        log.info("Response:  {}", response);
        return response;
    }

}
