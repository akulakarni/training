package com.pkma.spring.common;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.transaction.PlatformTransactionManager;

// to load data source properties based on environment
@PropertySource(value = {"classpath:application.properties"})
@Configuration
public class DataSourceConfig {
    private Server webServer;

    @Bean
    public String runScripts(final DataSource dataSource) throws Exception {
        try {
            ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("database/create-db.sql"));
            ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("database/insert-data.sql"));
            return "success";
        } catch (final SQLException e) {
            throw new Exception("Unable to run scripts", e);
        }
    }

    @Bean
    public DataSource dataSource() throws SQLException {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
        dataSource.setUsername("root");
        dataSource.setPassword("P@ssw0rd");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager txManager(final DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(final DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @PostConstruct
    private void startH2() throws Exception {
        try {
            Server.createTcpServer("-tcpAllowOthers").start();
            webServer = Server.createWebServer().start();
        } catch (final SQLException e) {
            throw new Exception("Unable to start local h2 server", e);
        }
    }

    @PreDestroy
    private void stopH2() {
        webServer.stop();
    }
}
