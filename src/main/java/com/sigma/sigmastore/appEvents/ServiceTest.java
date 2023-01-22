package com.sigma.sigmastore.appEvents;

import com.sigma.sigmastore.dao.GoodsDao;
import com.sigma.sigmastore.service.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;

@AllArgsConstructor
public class ServiceTest {

	private GoodsService goodsService;

	@EventListener(ApplicationContextEvent.class)
	public void tryServicemethods() {
		GoodsDao good = new GoodsDao("ServiceTry", 15, 16);
		GoodsDao goodService = goodsService.createGoods(good);
		System.out.println(goodService);
	}
}
