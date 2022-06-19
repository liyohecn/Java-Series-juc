package cn.liyohe.juc.chapter8;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;


@Slf4j
public class CachedThreadPoolMain {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            testSynchronousQueue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testSynchronousQueue() throws InterruptedException {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                log.info("put 1");
                synchronousQueue.put(1);
                log.info("put 1 success");

                log.info("put 2");
                synchronousQueue.put(2);
                log.info("put 2 success");

                log.info("put 3");
                synchronousQueue.put(3);
                log.info("put 3 success");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            try {
                log.info("take");
                Integer i = synchronousQueue.take();
                log.info("take {} success", i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            try {
                log.info("take");
                Integer i = synchronousQueue.take();
                log.info("take {} success", i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            try {
                log.info("take");
                Integer i = synchronousQueue.take();
                log.info("take {} success", i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
