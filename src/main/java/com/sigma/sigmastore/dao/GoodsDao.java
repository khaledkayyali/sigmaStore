package com.sigma.sigmastore.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDao {

	private String name;
	private double price;
	private int units;

}
