package com.kiheyunkim.bank.springconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:Properties/dbUser.properties")
public class DaoBeanConfiguration {
	
	@Bean
	public DataSource datasource(@Value("${dbuser}")String user, @Value("${password}")String password) {
		HikariDataSource datasource = new HikariDataSource();
		datasource.setUsername(user);
		datasource.setPassword(password);
		datasource.setJdbcUrl("jdbc:mysql://localhost:3306/bankdb?characterEncoding=UTF-8&serverTimezone=UTC");
		datasource.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());
		datasource.setMaximumPoolSize(10);
		datasource.setMaxLifetime(30000);
		
		return datasource;
	}
	/*
	@Bean
	public LoginDao loginDao(SessionFactory sessionFactory) {
		return new LoginDaoImp(sessionFactory);
	}
	
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean(DataSource dataSource) {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
		localSessionFactoryBean.setDataSource(dataSource);
		localSessionFactoryBean.setAnnotatedClasses(LoginModel.class);
		
		return localSessionFactoryBean;
	}
	@Bean
	public HibernateTransactionManager traHibernateTransactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put(AvailableSettings.DIALECT,MySQL5Dialect.class.getName());
		properties.put(AvailableSettings.SHOW_SQL,String.valueOf(true));
		properties.put(AvailableSettings.HBM2DDL_AUTO,"update");
		
		return properties;
	}
	 */
}
