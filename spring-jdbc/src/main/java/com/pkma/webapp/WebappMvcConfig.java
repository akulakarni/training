package com.pkma.webapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableTransactionManagement
// @Import({BeanContextConfig.class, DataSourceConfig.class})
public class WebappMvcConfig extends WebMvcConfigurationSupport {

}
