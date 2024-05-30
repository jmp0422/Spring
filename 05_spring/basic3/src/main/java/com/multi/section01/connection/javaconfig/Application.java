package com.multi.section01.connection.javaconfig;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.multi.section01.connection.javaconfig.config.ContextConfiguration;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

		
		System.out.println("전체 메뉴 조회하기");
		
		ProductService productService = (ProductService) context.getBean("productService"); //확인 @Service("productService")빈을 impl에서구현함
		List<ProductDTO> productList = productService.selectProductList();
		for(ProductDTO product : productList) {
			System.out.println(product);
		}
	}

}


//확인 https://mybatis.org/spring/ko/mappers.html api설명페이지