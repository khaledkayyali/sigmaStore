package com.sigma.sigmastore.service;

import com.sigma.sigmastore.converter.GoodsConverter;
import com.sigma.sigmastore.dao.GoodsDao;
import com.sigma.sigmastore.domain.Goods;
import com.sigma.sigmastore.exceptions.DataNotFoundException;
import com.sigma.sigmastore.exceptions.SemanticException;
import com.sigma.sigmastore.repository.GoodsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoodsService {

	private GoodsRepo goodsRepo;
	private GoodsConverter goodsConverter;

	public GoodsDao getGoods(int id) {
		return goodsRepo.findById(id)
				.map(goods -> goodsConverter.fromDomain(goods))
				.orElseThrow(() -> new DataNotFoundException("Good id not found"));
	}

	public List<GoodsDao> getAllGoods() {
		return goodsRepo.findAll().stream()
				.map(goods -> goodsConverter.fromDomain(goods))
				.collect(Collectors.toList());

	}

	public GoodsDao createGoods(GoodsDao goodsDao) {
		validate(goodsDao.getPrice() < 1, "Price Must be Positive");
		validate(goodsDao.getUnits() < 0, "Units Must be more than zero");

		Goods createGoods = goodsRepo.save(goodsConverter.fromDao(goodsDao));

		return goodsConverter.fromDomain(createGoods);
	}

	public GoodsDao updateGoods(int id, GoodsDao goodsDao) {
		checkExisting(id);
		validate(goodsDao.getPrice() < 1, "Price Must be Positive");
		validate(goodsDao.getUnits() < 0, "Units Must be more than zero");

		return goodsRepo.findById(id)
				.map(goods -> {
					Goods goodsToUpdate = goodsConverter.fromDao(goodsDao);
					goodsToUpdate.setId(goods.getId());
					return goodsRepo.save(goodsToUpdate);
				})
				.map(goodsOne -> goodsConverter.fromDomain(goodsOne))
				.orElseThrow(() -> new DataNotFoundException(String.format("Car with this id is not found ", id)));
	}

	public void deleteGoods(int id) {
		checkExisting(id);
		goodsRepo.deleteById(id);
	}

	private void checkExisting(int id) {
		goodsRepo.findById(id);
	}

	private void validate(boolean goodsDao, String message) {
		if (goodsDao) {
			throw new SemanticException(message);
		}
	}

	public List<GoodsDao> findByName(String name){
		return goodsRepo.findAllByName(name)
				.stream()
				.map(good -> goodsConverter.fromDomain(good))
				.collect(Collectors.toList());
	}
}
