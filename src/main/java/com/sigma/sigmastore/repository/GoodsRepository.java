package com.sigma.sigmastore.repository;

import com.sigma.sigmastore.domain.Goods;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.Objects;

@Repository
public class GoodsRepository {

    private final JdbcTemplate jdbcTemplate;

    public GoodsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Goods getGoods(int id) {
        RowMapper<Goods> rawMapper = new BeanPropertyRowMapper<>(Goods.class);
        return jdbcTemplate.queryForObject("select * from `sigmastore`.`goods` where `id` =? ", rawMapper, id);
    }

    public Goods createGoods(Goods goods) {

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO `sigmastore`.`goods` " +
                    "(`name`, `price`, `units`) " +
                    "VALUES(?, ?, ?);", new String[]{"id"});
            preparedStatement.setString(1, goods.getName());
            preparedStatement.setDouble(2, goods.getPrice());
            preparedStatement.setInt(3, goods.getUnits());
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
            preparedStatement.setString(1, goods.getName());
            preparedStatement.setDouble(2, goods.getPrice());
            preparedStatement.setInt(3, goods.getUnits());
            preparedStatement.setInt(4, id);
            return preparedStatement;
        });

        return getGoods(id);
    }

    public void deleteGoods(int id) {
        jdbcTemplate.update("DELETE FROM `sigmastore`.`goods` WHERE `id`=?;", id);

    }
}
