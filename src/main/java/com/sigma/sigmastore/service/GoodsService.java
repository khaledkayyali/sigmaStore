package com.sigma.sigmastore.service;

import com.sigma.sigmastore.dao.GoodsDao;
import com.sigma.sigmastore.domain.Goods;
import com.sigma.sigmastore.repository.GoodsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GoodsService {

	private GoodsRepository goodsRepository;

	public GoodsDao createGoods(GoodsDao goodsDao) {
		Goods createGoods = goodsRepository.createGoods(new Goods(goodsDao.getName(),
				goodsDao.getPrice(), goodsDao.getUnits()));

		return new GoodsDao(createGoods.getName(), createGoods.getPrice(), createGoods.getUnits());
	}

	public void deleteGoods(Integer id) {
		goodsRepository.deleteGoods(id);

	}

}
