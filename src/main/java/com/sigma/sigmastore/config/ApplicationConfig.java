package com.sigma.sigmastore.config;

import com.sigma.sigmastore.converter.GoodsConverter;
import com.sigma.sigmastore.domain.Goods;
import com.sigma.sigmastore.domain.Store;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

@Configuration
public class ApplicationConfig {

	@Bean
	public RowMapper<Goods> goodsRowMapper() {
		return new BeanPropertyRowMapper<>(Goods.class);
	}
	@Bean
	public RowMapper<Store> storeRowMapper() {
		return new BeanPropertyRowMapper<>(Store.class);
	}

}
