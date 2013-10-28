package com.company.sample.feature;

import com.company.sample.feature.service.FeatureService;
import com.company.sample.feature.service.FeatureServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.matchers.StringContains;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.junit.internal.matchers.StringContains.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FeatureControllerTestConfig.class})
@WebAppConfiguration
public class FeatureControllerTest {

    private MockMvc mockMvc;

    @Resource
    FeatureServiceImpl featureServiceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {

        Mockito.reset(featureServiceMock);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).alwaysDo(MockMvcResultHandlers.print()).build();
    }

    @Test
    public void welcome_whenCalled_shouldReturnAWelcomeString() throws Exception {
        // Arrange
        when(featureServiceMock.getGreeting()).thenReturn("Hello");

        // Act
        this.mockMvc.perform(get("/"))

        // Assert
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));
    }
}
