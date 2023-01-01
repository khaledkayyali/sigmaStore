package com.sigma.sigmastore.repository;

import com.sigma.sigmastore.domain.Store;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

@AllArgsConstructor
public class StoreRepository {

	private JdbcTemplate jdbcTemplate;


	public Store getStore(int id) {
		return null;
	}
}
