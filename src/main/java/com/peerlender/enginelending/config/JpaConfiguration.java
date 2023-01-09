package com.peerlender.enginelending.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@EnableTransactionManagement
@ComponentScan({"com.peerlender.enginelending"})
@Configuration
public class JpaConfiguration {

        @Bean
        public DataSource dataSource() {

            DriverManagerDataSource  dataSource = new DriverManagerDataSource();

            //SimpleDriverDataSource dataSource = new SimpleDriverDataSource ();
            dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //dataSource.setDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=Test");
            dataSource.setUsername("root");
            dataSource.setPassword("root");

            return dataSource;
        }

       @Bean
        public JpaVendorAdapter jpaVendorAdapter() {
            HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
            jpaVendorAdapter.setGenerateDdl(true);
            jpaVendorAdapter.setShowSql(true);
            jpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.SQLServer2012Dialect");
           //jpaVendorAdapter.setDatabasePlatform(MsSQLDialect.class.getName());

            return jpaVendorAdapter;
        }

        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

            LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
            lef.setPackagesToScan("com.peerlender.enginelending.domain.model");
            lef.setDataSource(dataSource());
            lef.setJpaVendorAdapter(jpaVendorAdapter());

            //lef.setJpaVendorAdapter(jpaVendorAdapter());

            Properties properties = new Properties();
            properties.setProperty("hibernate.show_sql", "true");
            properties.setProperty("hibernate.jdbc.fetch_size", "100");
            properties.setProperty("hibernate.hbm2ddl.auto", "update");

            lef.setJpaProperties(properties);
            return lef;
        }

        @Bean
        public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){

            JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
            jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
            return jpaTransactionManager;
        }


}
