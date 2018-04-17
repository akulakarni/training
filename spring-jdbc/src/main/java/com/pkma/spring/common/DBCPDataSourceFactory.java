package com.pkma.spring.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class DBCPDataSourceFactory {

    public static DataSource getDataSource(final String dbType) {
        final Properties props = new Properties();
        FileInputStream fis = null;
        final BasicDataSource ds = new BasicDataSource();
        try {
            fis = new FileInputStream(
                    "C:/Users/xprk266/vveerender/WCMV3/12-23-2014/spring-jdbc/src/main/resources/application.properties");
            props.load(fis);
        } catch (final IOException e) {
            e.printStackTrace();
            return null;
        }
        if ("mysql".equals(dbType)) {
            ds.setDriverClassName(props.getProperty("MYSQL_DB_DRIVER_CLASS"));
            ds.setUrl(props.getProperty("MYSQL_DB_URL"));
            ds.setUsername(props.getProperty("MYSQL_DB_USERNAME"));
            ds.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
        } else if ("oracle".equals(dbType)) {
            ds.setDriverClassName(props.getProperty("ORACLE_DB_DRIVER_CLASS"));
            ds.setUrl(props.getProperty("ORACLE_DB_URL"));
            ds.setUsername(props.getProperty("ORACLE_DB_USERNAME"));
            ds.setPassword(props.getProperty("ORACLE_DB_PASSWORD"));
        } else {
            ds.setDriverClassName(props.getProperty("dbc.driverClassName"));
            ds.setUrl(props.getProperty("jdbc.url"));
            ds.setUsername(props.getProperty("jdbc.username"));
            ds.setPassword(props.getProperty("jdbc.password"));
        }

        return ds;
    }
}
