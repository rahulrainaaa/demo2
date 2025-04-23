package com.example.demo.dummy;

import com.example.demo.logginAnnotation.CustomLogging;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class MyService {

    @CustomLogging
    public void work1() throws InterruptedException {

        Optional<String> optional = Optional.of("String");

        Boolean matching = optional.stream().anyMatch(str -> str.equals("String"));

        System.out.println(matching + "kdslfnsdkfndsjkf");

        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 11;
        });

        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(100);
//                if (System.currentTimeMillis() % 2 == 0)
//                    throw new NullPointerException("Data cannot be null...");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 44;
        });


        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Resulting = ";
        }).handle((g, h) -> {
            return "EXC";
        });

        CompletableFuture<String> a = task1.thenCombine(task3, (result1, result2) -> {
            return result1 + result2;
        }).handle((g, h) -> {
            return "exc";
        });

        CompletableFuture<String> b = a.thenCombine(task2, (r1, r2) -> {
            return r1 + r2;
        });

        String msg = b.join();

        b.whenComplete((g, h) -> {

        });

        System.out.println(msg);
    }
}
