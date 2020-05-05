package ru.parsertest.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
@ComponentScan(basePackages = "ru.parsertest.application")
@PropertySource(value = "classpath:db/postgres-pool.properties")
public class AppConfig {

    @Autowired
    Environment env;

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        PoolProperties p = new PoolProperties();
        p.setUrl(env.getProperty("database.url"));
        p.setDriverClassName(env.getProperty("database.driverClassName"));
        p.setUsername(env.getProperty("database.username"));
        p.setPassword(env.getProperty("database.password"));
        p.setValidationQuery("SELECT 1");
        p.setMaxActive(10);
        p.setInitialSize(2);
        p.setMaxWait(10000);
        p.setMaxIdle(5);
        p.setMinIdle(2);
        p.setTestOnBorrow(true);
        p.setTestOnConnect(true);
        p.setTestWhileIdle(true);
        dataSource.setPoolProperties(p);

        Resource initSchema = new ClassPathResource("db/initDB.sql");
        Resource initData = new ClassPathResource("db/populateDB.sql");
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, initData);
        DatabasePopulatorUtils.execute(databasePopulator, dataSource);
        return dataSource;
    }
}