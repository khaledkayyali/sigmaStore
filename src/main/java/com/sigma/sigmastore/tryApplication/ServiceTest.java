package com.sigma.sigmastore.tryApplication;

import com.sigma.sigmastore.dao.GoodsDao;
import com.sigma.sigmastore.domain.Goods;
import com.sigma.sigmastore.service.GoodsService;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ServiceTest {

    private GoodsService goodsService;

    public ServiceTest(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @EventListener(ApplicationContextEvent.class)
    public void tryServicemethods() {
        GoodsDao good = new GoodsDao("ServiceTry", 15, 16);
        GoodsDao goodService = goodsService.createGoods(good);
        System.out.println(goodService);

    }
}
