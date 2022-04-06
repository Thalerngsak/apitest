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
public class ResultsItem implements Serializable {
	private String nat;
	private String gender;
	private String phone;
	private Dob dob;
	private Name name;
	private Registered registered;
	private Location location;
	private Id id;
	private Login login;
	private String cell;
	private String email;
	private Picture picture;
}