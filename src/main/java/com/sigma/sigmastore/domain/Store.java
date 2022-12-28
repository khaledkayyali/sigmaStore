package com.sigma.sigmastore.domain;


import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Data
@Table(name = "Store")
@Component
public class Store {

    @javax.persistence.Id
    int Id;
    @Column
    String address;
    @Column
    ArrayList<Goods> MyGoods;
}
