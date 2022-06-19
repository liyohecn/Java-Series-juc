package cn.liyohe.juc.chapter8;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author Liyohe
 */

@Slf4j(topic = "ThreadPoolStatus-")
public class ThreadPoolStatus {

    private static final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
            2, 4, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));

    public static void main(String[] args) {
        status();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService1 = Executors.newCachedThreadPool();

    }

    public static void status() {
        boolean terminated = poolExecutor.isTerminated();
        log.info("terminated={}", terminated);
        poolExecutor.shutdown();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("terminated={}", terminated);
    }

}
