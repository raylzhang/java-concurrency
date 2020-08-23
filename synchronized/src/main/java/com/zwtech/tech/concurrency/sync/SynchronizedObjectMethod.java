package com.zwtech.tech.concurrency.sync;

/**
 * 对象锁，方法修饰符形式
 *
 * @author Ray
 * @since 2020/8/23 9:56 下午
 */
public class SynchronizedObjectMethod implements Runnable {
    static SynchronizedObjectMethod instance = new SynchronizedObjectMethod();

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

    public void run() {
        method();
    }

    public synchronized void method() {
        System.out.println("我的对象锁的方法修饰符形式，我叫" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }
}
