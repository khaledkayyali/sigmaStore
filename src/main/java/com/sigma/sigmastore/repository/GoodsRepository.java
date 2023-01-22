package com.sigma.sigmastore.repository;

import com.sigma.sigmastore.domain.Goods;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

@AllArgsConstructor
public class GoodsRepository {

	private final JdbcTemplate jdbcTemplate;
	private final RowMapper<Goods> rowMapper;

	public Goods getGoods(int id) {
		return jdbcTemplate.queryForObject("select * from `sigmastore`.`goods` where `id` =? ", rowMapper, id);
	}

	public Goods createGoods(Goods goods) {

		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(con -> {
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO `sigmastore`.`goods` " +
					"(`name`, `price`, `units`) " +
					"VALUES(?, ?, ?);", new String[]{"id"});
			setStatementParams(goods, preparedStatement);
			return preparedStatement;
		}, keyHolder);

		int generatedKey = Objects.requireNonNull(keyHolder.getKey()).intValue();
		return getGoods(generatedKey);
	}

	public Goods updateGoods(int id, Goods goods) {
		jdbcTemplate.update(con -> {
			PreparedStatement preparedStatement = con.prepareStatement("UPDATE `sigmastore`.`goods` " +
					"SET `name` = ?, `price` = ?, `units` = ? " +
					"WHERE `id` = ?;");
			setStatementParams(goods, preparedStatement);
			preparedStatement.setInt(4, id);
			return preparedStatement;
		});

		return getGoods(id);
	}

	public void deleteGoods(int id) {
		jdbcTemplate.update("DELETE FROM `sigmastore`.`goods` WHERE `id`=?;", id);

	}

	private void setStatementParams(Goods goods, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, goods.getName());
		preparedStatement.setDouble(2, goods.getPrice());
		preparedStatement.setInt(3, goods.getUnits());
	}

}
