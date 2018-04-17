package com.pkma.standalone;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableTransactionManagement
// @Import({BeanContextConfig.class, DataSourceConfig.class})
public class StandaloneWebMvcConfig extends WebMvcConfigurerAdapter {

}
