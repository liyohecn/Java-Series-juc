package cn.liyohe.juc.chapter8.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolMain {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

    }
}
