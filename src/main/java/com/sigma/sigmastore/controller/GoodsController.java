package com.sigma.sigmastore.controller;

import com.sigma.sigmastore.dao.GoodsDao;
import com.sigma.sigmastore.service.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
@AllArgsConstructor
public class GoodsController {

	private GoodsService goodsService;

	@GetMapping(path = "/{id}")
	public GoodsDao getGood(@PathVariable int id) {
		return goodsService.getGoods(id);
	}

	@GetMapping(path = "/all")
	public List<GoodsDao> getAllGoods(){
	 return goodsService.getAllGoods();
	}

	@GetMapping
	public List<GoodsDao> findByName(@RequestParam("name") String name) {
		if (name == null) {
			return goodsService.getAllGoods();
		} else {
			return goodsService.findByName(name);
		}
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public GoodsDao createGoods(@RequestBody GoodsDao goodsDao) {
		return goodsService.createGoods(goodsDao);
	}

	@PutMapping(path = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public GoodsDao updateGoods(@PathVariable int id,
								@RequestBody GoodsDao goodsDao) {
		return goodsService.updateGoods(id, goodsDao);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteGood(@PathVariable int id) {
		goodsService.deleteGoods(id);
	}

}
