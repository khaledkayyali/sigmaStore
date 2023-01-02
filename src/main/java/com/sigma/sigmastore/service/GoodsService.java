package com.sigma.sigmastore.service;

import com.sigma.sigmastore.converter.GoodsConverter;
import com.sigma.sigmastore.dao.GoodsDao;
import com.sigma.sigmastore.domain.Goods;
import com.sigma.sigmastore.exceptions.DataNotFoundException;
import com.sigma.sigmastore.exceptions.SymanticException;
import com.sigma.sigmastore.repository.GoodsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GoodsService {

	private GoodsRepository goodsRepository;
	private GoodsConverter goodsConverter;

	public GoodsDao getGoods(int id) {
		Goods returnedgood = goodsRepository.getGoods(id);
		return new GoodsDao(returnedgood.getName(), returnedgood.getPrice(), returnedgood.getUnits());
	}

	public GoodsDao createGoods(GoodsDao goodsDao) {
		validate(goodsDao.getPrice() < 1, "Price Must be Positive");
		validate(goodsDao.getUnits() < 0, "Units Must be more than zero");

		Goods createGoods = goodsRepository.createGoods(goodsConverter.fromDao(goodsDao));

		return goodsConverter.fromDomain(createGoods);
	}

	public GoodsDao updateGoods(int id, GoodsDao goodsDao) {
		CheckExisting(id);
		validate(goodsDao.getPrice() < 1, "Price Must be Positive");
		validate(goodsDao.getUnits() < 0, "Units Must be more than zero");

		Goods updateGoods = goodsRepository.updateGoods(id,goodsConverter.fromDao(goodsDao));

		return goodsConverter.fromDomain(updateGoods);
	}

	public void deleteGoods(int id) {
		Goods goods = goodsRepository.getGoods(id);
		if (goods != null) {
			goodsRepository.deleteGoods(id);
		}else{
			throw new DataNotFoundException("Book with id = " + id + " is not found" );
		}
	}

	private void CheckExisting(int id) {
		Goods goods = goodsRepository.getGoods(id);
		if (goods != null) {
			System.out.println("The goods With id " + id + "is exist");
		}else{
			throw new DataNotFoundException("Book with id = " + id + " is not found" );
		}
	}

	private void validate(boolean goodsDao, String message) {
		if (goodsDao){
			throw new SymanticException(message);
		}
	}
}
