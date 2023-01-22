package com.sigma.sigmastore.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Goods")
public class Goods {

	@Id
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private double price;
	@Column(name = "units")
	private int units;

	public Goods(String name, double price, int units) {
		this.name = name;
		this.price = price;
		this.units = units;
	}

}
