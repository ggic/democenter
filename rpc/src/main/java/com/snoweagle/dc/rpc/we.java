package com.snoweagle.dc.rpc;




import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * description
 *
 * @author patrick
 * @date 2020/2/20 3:27 PM
 */
@Slf4j
public class we {
    public static void main(String[] args) throws InterruptedException {
        final int[] counter = {0};
        final ReentrantLock lock = new ReentrantLock();
        for (int i= 0; i < 50; i++){
            new Thread(() -> {
                lock.lock();
                try {
                    int a = counter[0];
                    counter[0] = a + 1;
                    Thread.sleep(1000);
                    log.info("----{}--{}" ,Thread.currentThread().getName(),a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();
        }
        // 主线程休眠，等待结果
        Thread.sleep(5000);
        System.out.println(counter[0]);
    }
}
