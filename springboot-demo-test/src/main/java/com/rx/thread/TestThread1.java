package com.rx.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-08-02 10:41}
 * {{@code @Description} @Description: 模拟java多线程卖票问题 }
 */

public class TestThread1 {


    public static void main(String[] args) {
        SellThread sellThread = new SellThread();
        SellThread2 sellThread2 = new SellThread2();
        // new Thread(sellThread, "一号窗口").start();
        // new Thread(sellThread, "二号窗口").start();


        new Thread(sellThread2, "一号窗口").start();
        new Thread(sellThread2, "二号窗口").start();

    }

}


class SellThread implements Runnable{

    private AtomicInteger atomicInteger = new AtomicInteger(100);

    @Override
    public void run() {
        while (atomicInteger.get() > 0){
            try {
                Thread.sleep(800);
                String threadName = Thread.currentThread().getName();

                System.out.println(threadName + "窗口正在卖: " + atomicInteger.getAndDecrement());

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

}


class SellThread2 implements Runnable{

    private int num = 100;

    @Override
    public void run() {
        while (num > 0){
            synchronized (this){
                try {
                    Thread.sleep(800);
                    String threadName = Thread.currentThread().getName();

                    System.out.println(threadName + "窗口正在卖: " + num--);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }

}
