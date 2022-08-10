package com.rx.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-08-02 14:20}
 * {{@code @Description} @Description: }
 */

public class TestThread2 {

    public static void main(String[] args) {

        // ExecutorService threadPoolExecutor = new ThreadPoolExecutor();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> System.out.println(System.currentTimeMillis()));
        executorService.shutdown();
    }

}
