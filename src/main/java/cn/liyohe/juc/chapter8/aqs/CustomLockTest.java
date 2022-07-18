package cn.liyohe.juc.chapter8.aqs;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Liyohe
 * @description TODO
 * @date 2022/7/16 17:42
 */

@Slf4j
public class CustomLockTest {

    public static void main(String[] args) {
        CustomLock customLock = new CustomLock();

        new Thread(() -> {
            customLock.lock();
            try {
                log.info("locking......");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log.info("unlocking......");
                customLock.unlock();
            }
        }, "Thread-one").start();

        new Thread(() -> {
            customLock.lock();
            try {
                log.info("locking......");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                log.info("unlocking......");
                customLock.unlock();
            }
        }, "Thread-two").start();

    }
}
