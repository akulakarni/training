package com.pkma.spring.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.pkma.spring.controller.PlayerController;
import com.pkma.spring.dao.PlayerDAOImplUsingJDBC;
import com.pkma.spring.dao.PlayerDAOImplUsingJDBCTemplate;
import com.pkma.spring.dao.PlayerDAOImplUsingNamedParameterJDBCTemplate;
import com.pkma.spring.dao.PlayerDAOUsingJDBC;
import com.pkma.spring.dao.PlayerDAOUsingJDBCTemplate;
import com.pkma.spring.dao.PlayerDAOUsingNamedParameterJDBCTemplate;
import com.pkma.spring.dao.PlayerResultSetExtractor;
import com.pkma.spring.dao.PlayerRowMapper;
import com.pkma.spring.dao.SequenceDao;
import com.pkma.spring.dao.SequenceDaoImpl;
import com.pkma.spring.repository.PlayerRepository;
import com.pkma.spring.repository.PlayerRepositoryImpl;
import com.pkma.spring.services.PlayerService;
import com.pkma.spring.services.PlayerServiceImpl;

// If there are plenty of beans then isolate them into seperate classes
@Configuration
@ComponentScan(basePackages = "com.pkma.spring")
public class BeanContextConfig {

    @Bean
    public PlayerController playerController() {
        return new PlayerController();
    }

    @Bean
    public PlayerService playerService() {
        return new PlayerServiceImpl();
    }

    @Bean
    public PlayerRepository playerRepository() {
        return new PlayerRepositoryImpl();
    }

    @Bean
    public PlayerDAOUsingJDBCTemplate playerDAOUsingJDBCTemplate() {
        return new PlayerDAOImplUsingJDBCTemplate();
    }

    @Bean
    public PlayerDAOUsingJDBC playerDAOUsingJDBC() {
        return new PlayerDAOImplUsingJDBC();
    }

    @Bean
    public PlayerDAOUsingNamedParameterJDBCTemplate playerDAOImplUsingNamedParameterJDBCTemplate() {
        return new PlayerDAOImplUsingNamedParameterJDBCTemplate();
    }

    @Bean
    public PlayerRowMapper playerRowMapper() {
        return new PlayerRowMapper();
    }

    @Bean
    public PlayerResultSetExtractor playerResultSetExtractor() {
        return new PlayerResultSetExtractor();
    }

    @Bean
    public DBCPDataSourceFactory dataSourceFactory() {
        return new DBCPDataSourceFactory();
    }

    @Bean
    public SequenceDao sequenceDao() {
        return new SequenceDaoImpl();
    }
}
