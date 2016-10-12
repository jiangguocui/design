package com.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private final Lock lock = new ReentrantLock();
    
    public void printJob(Object doc){
        lock.lock();
        System.out.println(Thread.currentThread().getName()+":Going to print document");
        
        Long duration = (long) (Math.random()*10000);
        System.out.println(Thread.currentThread().getName()+":PrintQueue: Printing a Job during " + (duration / 1000));
        
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    
    public static void main(String[] args) {
        final ReentrantLockDemo demo = new ReentrantLockDemo();
        
        Thread[] threads = new Thread[10];
        for(int i=0;i<10;i++){
            threads[i] = new Thread(new Runnable() {
                
                @Override
                public void run() {
                    demo.printJob(new Object());
                    
                }
            },"Thread"+i);
        }
        for(int i=0;i<10;i++){
            threads[i].start();
        }
    }
}
