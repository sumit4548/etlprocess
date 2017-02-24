package com.sumit.learning.springbatch.etlprocess.model.util;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sumit.learning.springbatch.etlprocess.model.Product;

public class ProductJdbcItemWriter implements ItemWriter<Product> {

	private static final String INSERT_PRODUCT = "insert into product "
			+ "(productName,productPrize,productType) values(?,?,?)";

	private static final String UPDATE_PRODUCT = "update product set "
			+ "productName=?, productPrize=?, productType=? where productName=?";

	private JdbcTemplate jdbcTemplate;

	public ProductJdbcItemWriter(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	public void write(List<? extends Product> arg0) throws Exception {
		// TODO Auto-generated method stub
		
		for(Product a :arg0){
			int updated = jdbcTemplate.update(UPDATE_PRODUCT,a.getProductName(),a.getProductPrize(),a.getProductType(),a.getProductName());
			if(updated == 0){
				jdbcTemplate.update(INSERT_PRODUCT,a.getProductName(),a.getProductPrize(),a.getProductType());
			}
		}
		

	}

}
