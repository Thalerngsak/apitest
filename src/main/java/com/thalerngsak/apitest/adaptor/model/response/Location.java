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
public class Location implements Serializable {
	private String country;
	private String city;
	private Street street;
	private Timezone timezone;
	private Integer postcode;
	private Coordinates coordinates;
	private String state;
}