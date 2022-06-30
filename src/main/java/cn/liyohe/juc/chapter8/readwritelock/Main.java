package cn.liyohe.juc.chapter8.readwritelock;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Liyohe
 * @description TODO
 * @date 2022/6/30 11:57
 */

@Slf4j
public class Main {

    public static void main(String[] args) {
        DataContainer dataContainer = new DataContainer();
        dataContainer.write("Hello World");

//        concurrRead(dataContainer);
        concurrWrite(dataContainer);
    }

    public static void concurrRead(DataContainer dataContainer) {
        new Thread(() -> {
            dataContainer.read();
        }).start();
        new Thread(() -> {
            dataContainer.read();
        }).start();
    }

    public static void concurrWrite(DataContainer dataContainer) {
        new Thread(() -> {
            dataContainer.write("Thread-1");
        }).start();
        new Thread(() -> {
            dataContainer.write("Thread-2");
        }).start();
    }
}

