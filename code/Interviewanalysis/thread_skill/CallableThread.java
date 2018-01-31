package Interviewanalysis.thread_skill;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 实现callable接口
 *
 * @author crimps
 * @create 2018-01-31 10:42
 **/
public class CallableThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "#" + i);
        }
        return i;
    }

    public static void main(String[] args) {
        try {
            CallableThread callableThread = new CallableThread();
            FutureTask<Integer> futureTask = new FutureTask<Integer>(callableThread);
            new Thread(futureTask).start();
            System.err.println("&&&&&&" + futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
