package com.sigma.sigmastore.appEvents;

import com.sigma.sigmastore.domain.Goods;
import com.sigma.sigmastore.repository.GoodsRepository;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TryApplication {

	private GoodsRepository goodsRepository;

	public TryApplication(GoodsRepository goodsRepository) {
		this.goodsRepository = goodsRepository;
	}

	@EventListener(ApplicationContextEvent.class)
	public void trymethods() {

		Goods addedGoodsOne = new Goods("BlackPen", 10.5, 5);
		Goods createGoods = goodsRepository.createGoods(addedGoodsOne);
		System.out.println(createGoods);

		Goods goods = goodsRepository.getGoods(1);
		System.out.println(goods.toString());

		Goods addedGoodsTwo = new Goods("RedPen", 10.5, 5);
		createGoods = goodsRepository.createGoods(addedGoodsTwo);
		System.out.println(createGoods);

		Goods updatedGoods = new Goods("BlackPen Updated", 11, 4);
		Goods updateGoods = goodsRepository.updateGoods(1, updatedGoods);
		System.out.println(updateGoods);

		goodsRepository.deleteGoods(2);


	}
}
