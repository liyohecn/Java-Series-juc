package cn.liyohe.juc.chapter8.readwritelock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Liyohe
 * @description TODO
 * @date 2022/6/30 11:51
 */

@Slf4j
public class DataContainer {

    private Object data;

    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    private ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();

    private ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    public Object read() {
        log.info("获取读锁...");
        readLock.lock();
        try {
            log.info("读取数据...");
            sleep(1);
            return data;
        } finally {
            log.info("释放读锁...");
            readLock.unlock();
        }
    }

    public void write(Object data) {
        log.info("获取写锁...");
        writeLock.lock();
        try {
            log.info("写入数据...");
            sleep(1);
            this.data = data;
        } finally {
            log.info("释放写锁...");
            writeLock.unlock();
        }
    }

    private void sleep(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
