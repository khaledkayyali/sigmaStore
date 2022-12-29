package com.sigma.sigmastore.service;

import com.sigma.sigmastore.dao.GoodsDao;
import com.sigma.sigmastore.domain.Goods;
import com.sigma.sigmastore.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GoodsService {

    private GoodsRepository goodsRepository;

    public GoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    public GoodsDao createGoods(GoodsDao goodsDao){
        Goods createGoods = goodsRepository.createGoods(new Goods(goodsDao.getName(),
                goodsDao.getPrice(),goodsDao.getUnits()));

        return new GoodsDao(createGoods.getName(),createGoods.getPrice(),createGoods.getUnits());
    }

    public void deleteGoods(Integer id){
        goodsRepository.deleteGoods(id);

    }

}
