package com.example.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FakeClientService {

    @Autowired
    private FakeApi fakeApi;

    public String getFakeApi1() {
        return fakeApi.getFakeApi1();
    }
}
