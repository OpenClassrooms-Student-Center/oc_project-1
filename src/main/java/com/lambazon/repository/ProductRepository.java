package com.lambazon.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.lambazon.API;
import com.lambazon.domain.Customer;
import com.lambazon.domain.Product;

/**

 * create table Product(id bigint auto_increment, quantity int, price double, name varchar(255), description varchar(255));
 * 
 * @author stanlick
 *
 */

@Repository
public class ProductRepository {
	
	@Inject
    private JdbcTemplate jdbcTemplate;

	public List<Product> products() {
		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
		return jdbcTemplate.query("select * from Product", rowMapper);
	}
	
	public Product product(Long id) {
		String sql = "SELECT * from Product WHERE id=?";
		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
	    return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}
	
	public Product create(Product product) {
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(conn -> {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO product (quantity, price, name, description) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, product.getInventoryQuantity());
			ps.setDouble(2, product.getInventoryPrice());
			ps.setString(3, product.getName());
			ps.setString(4, product.getDescription());
			return ps;
			} , holder);

		return product(holder.getKey().longValue());
	}
	
	public void deleteAll() {
		String sql = "DELETE from product";
	    jdbcTemplate.update(sql);
	}

}
