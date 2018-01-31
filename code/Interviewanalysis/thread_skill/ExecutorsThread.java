package Interviewanalysis.thread_skill;

import java.util.concurrent.Executors;

/**
 * 线程池创建多线程
 *
 * @author crimps
 * @create 2018-01-31 10:48
 **/
public class ExecutorsThread {

    public static void main(String[] args) {
        Executors.newFixedThreadPool(30).execute(new Runnable(){
            @Override
            public void run() {
                System.out.println("newFixedThreadPool_" + Thread.currentThread().getName());
            }
        });

        Executors.newCachedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("newCachedThreadPool_" + Thread.currentThread().getName());
            }
        });

        Executors.newScheduledThreadPool(3).execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("newScheduleThreadPool_" + Thread.currentThread().getName());
            }
        });
    }
}
