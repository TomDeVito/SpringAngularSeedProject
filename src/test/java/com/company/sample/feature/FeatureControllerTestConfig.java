package com.company.sample.feature;

import com.company.sample.feature.service.FeatureService;
import com.company.sample.feature.service.FeatureServiceImpl;
import config.WebMvcConfigTest;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.mockito.Mockito.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.company.sample.feature.controller" })
public class FeatureControllerTestConfig extends WebMvcConfigTest {
	
    @Bean
    FeatureServiceImpl featureServiceMock() {
        return mock(FeatureServiceImpl.class);
    }

}