package com.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class FourThreadPool {
    public static void main(String[] args) {
        
        //newFixedThreadPool创建一个长线程连接池，可控制最大并发数，超出的线程会在队列中等待
        //因为线程池大小为3，每个任务输出index后睡2s，所以每两秒打印3个数字
        //定长线程池的大小最好根据系统资源进行设置，如Runtime.getRuntime().availableProcessors()
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++){
            final int index =i;
            fixedThreadPool.execute(new Runnable() {
                
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    System.out.println("---------------"+index);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }
        
        
        //newScheduledThreadPool创建一个定长线程池，支持定时及周期性任务执行
        ScheduledExecutorService scheduledThreadPool =Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            
            @Override
            public void run() {
              System.out.println("延迟3s");
                
            }
        },3,TimeUnit.SECONDS);
        //定期执行
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("delay 1 seconds, and excute every 3 seconds"); 
            }
        }, 1, 4, TimeUnit.SECONDS);
        
        
        
        //newSingleThreadPoolExecutor 创建一个单线程化的线程，他只会用唯一的工作线程来执行任务
        //结果依次输出，相当于顺序执行个
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for(int i=0;i<10;i++){
            final int index = i;
            singleThreadPool.execute(new Runnable() {
                
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    System.out.println(index+"single");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }
        
        
        //newCachedThreadPool 创建一个可缓存的线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
        //线程池为无限大，当执行第二个任务时第一任务已经执行完成，会复用执行第一个任务的线程，而不是每次新建线程
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i=0;i<100;i++){
            final int index = i;
            try {
                Thread.sleep(index*1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    System.out.println(index);
                }
            });
        }
        
        
        
    }
}
