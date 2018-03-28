package com.lambazon.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.lambazon.domain.Customer;

/**
 * 
 * create table Customer(id bigint auto_increment, name varchar(255));
 * 
 * @author stanlick
 *
 */

@Repository
public class CustomerRepository {

	@Inject
    private JdbcTemplate jdbcTemplate;

	public List<Customer> customers() {
		RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<Customer>(Customer.class);
		return jdbcTemplate.query("select * from Customer", rowMapper);
	}
	
	public Customer customer(Long id) {
		String sql = "SELECT * from customer WHERE id=?";
		RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<Customer>(Customer.class);
	    return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	public Customer create(Customer customer) {
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(conn -> {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO customer (name) values (?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, customer.getName());
			return ps;
			} , holder);

		return customer(holder.getKey().longValue());
	}
	
	public void update(Customer customer) {
		String sql = "UPDATE customer SET name=? WHERE id=?";
	    jdbcTemplate.update(sql, customer.getName(), customer.getId());
	}
	public void delete(Long id) {
		String sql = "DELETE from customer WHERE id=?";
	    jdbcTemplate.update(sql, id);
	}
	
	public void deleteAll() {
		String sql = "DELETE from customer";
	    jdbcTemplate.update(sql);
	}
}
