package com.multi.section01.connection.javaconfig.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // 확인 설정파일이다
@ComponentScan("com.multi.section01.connection.javaconfig") // 확인 자바컨피그 까지만 읽어야 세션1의 모든파일이 읽힘
@PropertySource("connection-info.properties") // 확인 resources에 있는 properties 읽기
public class ContextConfiguration {

	// 필드 4개 만들고 값 할당
	// 치환자문법 (placeholder)을 활용해서 properties파일의 키값으로 value값을 얻어옴
	@Value("${jdbc.dev.driver}")
	private String driver;

	@Value("${jdbc.dev.url}")
	private String url;

	@Value("${jdbc.dev.username}")
	private String username;

	@Value("${jdbc.dev.password}")
	private String password;

	@Bean(destroyMethod = "close") // 확인 자원을 다쓰면 닫아주겠다
	public BasicDataSource dataSource() { // db접속정보를 저장하기위한 인터페이스를 상속받은 클래스

		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDefaultAutoCommit(false);

		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(ApplicationContext context) throws Exception {

		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());

		factoryBean.setConfigLocation(context.getResource("classpath:mybatis-config.xml"));

		return factoryBean.getObject();
	}

	@Bean // 마이바티스 스프링에서 SqlSessionTemplate 인스턴스 를 제공 - JDBC 템플릿 만들었던것 처럼 사용 할수 있게 제공,
	public SqlSessionTemplate sqlSessionTemplate(ApplicationContext context) throws Exception {

		return new SqlSessionTemplate(sqlSessionFactory(context));

	}

}
