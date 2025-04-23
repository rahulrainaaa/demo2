package com.example.demo.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    public String getFakeApi1() {
        String url = "https://mocki.io/v1/3cbcfd44-655f-49fc-93c3-5478ca5ba16a";
        return restTemplate.getForObject(url, String.class);
    }

}
