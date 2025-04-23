package com.example.demo.dummy;

import com.example.demo.client.FakeClientService;
import com.example.demo.resttemplate.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class FirstController {

    @Autowired
    private FakeClientService fakeClientService;

    @Autowired
    private RestTemplateService restTemplateService;

    @GetMapping("/1")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("FeignClient = " + fakeClientService.getFakeApi1());
    }

    @GetMapping("/2")
    public ResponseEntity<String> post() {
        return ResponseEntity.ok("RestTemplate = " + restTemplateService.getFakeApi1());
    }


}
