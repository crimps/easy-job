package Interviewanalysis.thread_skill;

/**
 * 实现runnable接口
 *
 * @author crimps
 * @create 2018-01-31 10:39
 **/
public class RunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println(" runnable Thread");
    }

    public static void main(String[] args) {
        new Thread(new RunnableThread()).start();
    }
}
