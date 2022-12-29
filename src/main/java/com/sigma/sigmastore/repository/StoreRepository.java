package com.sigma.sigmastore.repository;

import com.sigma.sigmastore.domain.Store;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;

public class StoreRepository {

    private JdbcTemplate jdbcTemplate;

    public StoreRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Store getStore(int id){
        return null;
    }
}
