package com.lti.configuration;

<<<<<<< HEAD

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author Naman,Purnima,Radha,Ramit,Sai,Vignesh
 *
 */
@PropertySource("classpath:application.properties")
@Configuration
public class JDBCConfiguration {

	/**
	 * This is used to autowire  JDBCConfiguration bean
	 */
	@Autowired
	Environment environment;

	/**
	 * @return
	 * This is used to initialize DriverManagerDataSource.
	 */
	@Bean
	DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("spring.datasource.url"));
		dataSource.setUsername(environment.getProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getProperty("spring.datasource.password"));
		dataSource.setDriverClassName(environment.getProperty("spring.datasource.driverClassName"));

		return dataSource;
	}

	/**
	 * @return
	 * This is used to return jdbcTemplate object.
	 */
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
=======
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
@PropertySource("classpath:application.properties")
@Configuration
public class JDBCConfiguration {
    /**
     * This is used to autowire  JDBCConfiguration bean
     */
    @Autowired
    Environment environment;
    /**
     * @return
     * This is used to initialize DriverManagerDataSource.
     */
    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driverClassName"));
        return dataSource;
    }
    /**
     * @return
     * This is used to return jdbcTemplate object.
     */
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
>>>>>>> branch 'main' of https://github.com/n-man13/CRS-Group-B-JAVA-POS.git
}