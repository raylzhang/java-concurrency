package com.zwtech.tech.concurrency.sync;

/**
 * 对象锁，代码块形式
 *
 * @author Ray
 * @since 2020/8/18 6:50 下午
 */
public class SynchronizedObjectCodeBlock implements Runnable {
    static SynchronizedObjectCodeBlock instance = new SynchronizedObjectCodeBlock();

    /**
     * 锁对象
     */
    Object lock1 = new Object();
    Object lock2 = new Object();

    public void run() {
        synchronized (lock1) {
            System.out.println("我是lock1。我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "lock1部分运行结束。");
        }

        synchronized (lock2) {
            System.out.println("我是lock2。我叫" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "lock2部分运行结束。");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        // t1.join(); t2.join(); 这样写同样可以等待t1和t2执行结束后再继续执行。
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }
}
