package com.sumit.learning.springbatch.etlprocess.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;
import com.sumit.learning.springbatch.etlprocess.model.Product;

public class ProductFieldSetMapper implements FieldSetMapper<Product>{

	public Product mapFieldSet(FieldSet arg0) throws BindException {
		// TODO Auto-generated method stub
		
		Product p = new Product();
		p.setProductName(arg0.readString("Product_Name"));
		p.setProductPrize(arg0.readString("Product_Prize"));
		p.setProductType(arg0.readString("Product_Type"));
		
		return p;
	}

}
