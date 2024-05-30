package com.multi.section01.connection.javaconfig;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service("productService") //확인 어플리케이션에서 productService를 겟빈으로 가져오기때문에 일치하였음
public class ProductServiceImpl implements ProductService {
	
	private final ProductDAO productDAO;
	private final SqlSessionTemplate sqlSession;
	
	public ProductServiceImpl(ProductDAO productDAO ,SqlSessionTemplate sqlSession ) {
		
		this.productDAO = productDAO;
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ProductDTO> selectProductList() {
		// TODO Auto-generated method stub
		return productDAO.selectProductList(sqlSession);
	}

}
