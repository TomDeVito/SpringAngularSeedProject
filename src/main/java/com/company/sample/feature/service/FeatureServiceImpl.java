package com.company.sample.feature.service;

import org.springframework.stereotype.Service;

@Service
public class FeatureServiceImpl implements FeatureService {

    public String getGreeting() {
        return "Welcome!";
    }
}
