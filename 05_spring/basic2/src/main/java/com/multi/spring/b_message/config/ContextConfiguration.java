package com.multi.spring.b_message.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.multi.spring.b_message.Beverage;
import com.multi.spring.b_message.Bread;
import com.multi.spring.b_message.Product;
import com.multi.spring.b_message.ShoppingCart;

@Configuration // 설정파일이다 설정
@PropertySource("product-info.properties") // 리소스에있는 product-info.properties 파일읽어들이기
public class ContextConfiguration {

	// 치환자문법 (placeholder)을 활용해서 properties파일의 키값으로 value값을 얻어옴
	@Value("${bread.carpbread.name:붕어빵}") // {bread.carpbread.name:붕어빵}을사용하면 초기값지정가능
	private String carpBreadName;

	@Value("${bread.carpbread.name:붕어빵}") // {bread.carpbread.name:붕어빵}을사용하면 초기값지정가능
	private String carpBreadName2;

	@Value("${bread.carpbread.name:붕어빵}") // {bread.carpbread.name:붕어빵}을사용하면 초기값지정가능
	private String carpBreadName3;

	@Value("${bread.carpbread.price:0}") // 0 초기값지정가능
	private int carpBreadPrice;

	private String milkName;
	private int milkPrice;
	private int milkCapacity;

	@Bean // 빈생성
	public Product carpBread() {
		return new Bread(carpBreadName, carpBreadPrice, new java.util.Date());
	}

	@Bean
	public Product milk() {

		return new Beverage(milkName, milkPrice, milkCapacity);
	}

	@Bean
	public Product water(@Value("${beverage.water.name:}") String waterName,
			@Value("${beverage.water.price:0}") int waterPrice,
			@Value("${beverage.water.capacity:0}") int waterCapacity) {

		return new Beverage(waterName, waterPrice, waterCapacity);
	}
	
	@Bean
	@Scope("prototype") //cart1과 cart2가 각각생성되어 이제 주소값이 다르게나옴
	public ShoppingCart cart() {

		return new ShoppingCart();
	}

}
