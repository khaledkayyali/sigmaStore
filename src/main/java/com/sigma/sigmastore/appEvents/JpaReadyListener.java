package com.sigma.sigmastore.appEvents;

import com.sigma.sigmastore.domain.Goods;
import com.sigma.sigmastore.repository.GoodsRepo;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

public class JpaReadyListener {

	private final GoodsRepo goodsRepo;

	public JpaReadyListener(GoodsRepo goodsRepo) {
		this.goodsRepo = goodsRepo;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doJpaWork(){

		Goods good = goodsRepo.findById(1).get();
		System.out.println("good from jpa" + good);
	}
}
