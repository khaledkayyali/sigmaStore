package com.sigma.sigmastore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

	private String name;
	private double price;
	private int units;

}
