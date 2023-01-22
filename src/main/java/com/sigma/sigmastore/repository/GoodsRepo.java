package com.sigma.sigmastore.repository;

import com.sigma.sigmastore.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface GoodsRepo extends JpaRepository<Goods, Integer> {
	List<Goods> findAllByName(String name);
}
