package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "fakeApi1", url = "https://mocki.io")
public interface FakeApi {

    @GetMapping("/v1/3cbcfd44-655f-49fc-93c3-5478ca5ba16a")
    String getFakeApi1();

}
