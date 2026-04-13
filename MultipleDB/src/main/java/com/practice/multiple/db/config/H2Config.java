package com.practice.multiple.db.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "com.practice.multiple.db.h2.repo",
		entityManagerFactoryRef = "h2EntityManager",
		transactionManagerRef = "h2TxManager"
)
public class H2Config {
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.d1")
	public DataSourceProperties h2Properties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean(name = "h2DataSource")
	public DataSource h2DataSource() {
		return h2Properties()
				.initializeDataSourceBuilder()
				.build();
	}
	
	@Bean(name="h2EntityManager")
	@Primary
	public LocalContainerEntityManagerFactoryBean h2EntityManager(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(h2DataSource())
				.packages("com.practice.multiple.db.h2.entity")
				.persistenceUnit("d1")
				.build();		
	}
	
	@Primary
	@Bean(name="h2TxManager")
	public PlatformTransactionManager h2TxManager(@Qualifier("h2EntityManager") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

}
