package com.sigma.sigmastore.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsDao {

	private String name;
	private double price;
	private int units;

	public GoodsDao(String name, double price, int units) {
		this.name = name;
		this.price = price;
		this.units = units;
	}

}
