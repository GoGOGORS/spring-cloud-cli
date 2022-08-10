package com.rx.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-08-08 09:57}
 * {{@code @Description} @Description: }
 */

public class ForkJoinPoolTest {

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        forkJoinPool.invoke(new NoReresultClass());


        new Object().notify();

    }


}




/**
 * 无返回值
 */
class NoReresultClass extends RecursiveAction {

    @Override
    protected void compute() {
        System.out.println(111);
    }
}

/**
 * 有返回值
 */
class ResultClass extends RecursiveTask<Integer>{

    @Override
    protected Integer compute() {
        return null;
    }
}