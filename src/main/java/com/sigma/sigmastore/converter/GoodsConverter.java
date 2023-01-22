package com.sigma.sigmastore.converter;

import com.sigma.sigmastore.dao.GoodsDao;
import com.sigma.sigmastore.domain.Goods;
import org.springframework.stereotype.Component;

@Component
public class GoodsConverter {
	public GoodsDao fromDomain(Goods goods){
		return new GoodsDao(goods.getName(),
				goods.getPrice(), goods.getUnits());
	}

	public Goods fromDao(GoodsDao goodsDao){
		return new Goods(goodsDao.getName(),
				goodsDao.getPrice(), goodsDao.getUnits());
	}
}
