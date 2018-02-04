package com.admin.professorproject.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoyBean = new LocalSessionFactoryBean();
		sessionFactoyBean.setDataSource(dataSource());
		sessionFactoyBean.setPackagesToScan("com.admin.professorproject.model");
		sessionFactoyBean.setHibernateProperties(hibernateProperties());
		
		return sessionFactoyBean;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		Localhost
//		dataSource.setUrl("jdbc:mysql://localhost:3306/jeeprofesional");
//		dataSource.setUsername("jeeprofesional");
//		dataSource.setPassword("1234");
//		ClearDB con Heroku		
		dataSource.setUrl("jdbc:mysql://us-cdbr-iron-east-05.cleardb.net:3306/heroku_89db8cd5e89a26b");
		dataSource.setUsername("b402b39d2aa217");
		dataSource.setPassword("18315949");
		
		
		return dataSource;
	}
	
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("show_sql", "true");
		
		return properties;
	}
	
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
		
		return hibernateTransactionManager;
	}
}
