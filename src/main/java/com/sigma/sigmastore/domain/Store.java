package com.sigma.sigmastore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {

	private String name;
	private Boolean open;
	private String address;

}
