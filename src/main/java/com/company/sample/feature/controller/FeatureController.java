package com.company.sample.feature.controller;

import com.company.sample.feature.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FeatureController {

    private FeatureService featureServiceImpl;

    @Autowired
    public FeatureController(FeatureService featureService) {
        this.featureServiceImpl = featureService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String welcome() {
        return featureServiceImpl.getGreeting();
    }

}
