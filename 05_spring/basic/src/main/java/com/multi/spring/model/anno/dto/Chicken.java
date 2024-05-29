package com.multi.spring.model.anno.dto;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;



@Primary //@Autowired 시에 여러 빈이 매칭되면 @Primary가 우선권을 가진다!
//@Component 는 클래스 레벨에서 선언함으로써 스프링이 런타임시에 컴포넌트스캔을 하여 자동으로 빈을 찾고(detect) 등록하는 애노테이션
@Component("chicken") 
// bean의 Id는 lower Camel Case(앞자리 소문자)를 사용
//명시해주지않으면 클래스이름의 맨앞글자만 소문자로하여 사용함
public class Chicken implements Food {

	@Override
	public void eat(String foodName) {
		System.out.println("한강에서 "+foodName + "치킨을 먹는중 ~~" );

	}

}
