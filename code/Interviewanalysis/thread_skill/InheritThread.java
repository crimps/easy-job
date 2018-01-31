package Interviewanalysis.thread_skill;

/**
 * 继承Thread
 *
 * @author crimps
 * @create 2018-01-31 10:35
 **/
public class InheritThread extends Thread{
    @Override
    public void run() {
        System.out.println("inherit thread");
    }

    public static void main(String[] args) {
        new InheritThread().start();
    }
}
