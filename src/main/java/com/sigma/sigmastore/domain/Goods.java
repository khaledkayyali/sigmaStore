package com.sigma.sigmastore.domain;

import lombok.Data;

@Data
public class Goods {
    int id;
    String name;
    double price;
    int units;

    public Goods(int id, String name, double price, int units) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.units = units;
    }

    public Goods() {
    }

    public Goods(String name, Double price, Integer units) {
    }
}
