package com.practice.multiple.db.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "com.practice.multiple.db.mysql.repo",
		entityManagerFactoryRef = "mysqlEntityManager",
		transactionManagerRef = "mysqlTxManager"
)
public class MysqlConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.d2")	
	public DataSourceProperties mysqlProperties() {
		return new DataSourceProperties();
	}
	
	@Bean(name = "mysqlDataSource")
	public DataSource mysqlDataSource() {
		return mysqlProperties()
				.initializeDataSourceBuilder()
				.build();
	}
	
	@Bean("mysqlEntityManager")
	public LocalContainerEntityManagerFactoryBean mysqlEntityManager(EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(mysqlDataSource())
				.packages("com.practice.multiple.db.mysql.entity")
				.persistenceUnit("d2")
				.build();
	}
	
	@Bean(name = "mysqlTxManager")
	public PlatformTransactionManager mysqlTxManager(@Qualifier("mysqlEntityManager") EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
