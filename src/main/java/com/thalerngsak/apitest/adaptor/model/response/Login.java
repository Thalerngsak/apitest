package com.thalerngsak.apitest.adaptor.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Login implements Serializable {
	private String sha1;
	private String password;
	private String salt;
	private String sha256;
	private String uuid;
	private String username;
	private String md5;
}