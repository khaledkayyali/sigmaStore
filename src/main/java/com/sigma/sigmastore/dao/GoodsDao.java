package com.sigma.sigmastore.dao;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
@Data
public class GoodsDao {

    int id;
    String name;
    double price;
    int units;


    public GoodsDao( String name, double price, int units) {
    }

}
