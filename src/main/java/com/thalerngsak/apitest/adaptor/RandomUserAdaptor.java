package com.thalerngsak.apitest.adaptor;

import com.thalerngsak.apitest.adaptor.model.request.RandomUserRequest;
import com.thalerngsak.apitest.adaptor.model.response.RandomUserResponse;

public interface RandomUserAdaptor {
    RandomUserResponse getUser(RandomUserRequest request);
}
