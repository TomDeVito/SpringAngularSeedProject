package com.company.sample.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@ComponentScan(basePackages = { "com.netcentric.sample" })
//@Import({PersistenceConfig.class})
public class RootConfig {

    @Bean
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
       ClassPathResource[] propertyFileLocations =  new ClassPathResource[] {
               new ClassPathResource("/persistence.properties"), new ClassPathResource("/sample.properties")
       };

        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocations(propertyFileLocations);
        return ppc;
	}
}