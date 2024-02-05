package View;

import Logic.RunnableClass;
import Logic.ThreadClass;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("**************BEGIN**************");

        /*new Thread(() -> {
            int cont = 10;
            while (true) {
                System.out.println(cont++);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (cont == 20) break;
            }*/

            new Thread(() -> {
                int cont = 10;
                while (true) {
                    LocalTime time =LocalTime.now();
                    System.out.printf("%d:%d:%d\n",time.getHour(), time.getMinute(),time.getSecond());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

        }).start();

        ThreadClass th1 = new ThreadClass("Hilo uno");
        ThreadClass th2 = new ThreadClass("Hilo dos");
        ThreadClass th3 = new ThreadClass("Hilo tres");


        RunnableClass run1 = new RunnableClass("Run uno");
        RunnableClass run2 = new RunnableClass("Run dos");
        RunnableClass run3 = new RunnableClass("Run tres");

        Thread thr1 =new Thread(run1);
        Thread thr2 =new Thread(run2);
        Thread thr3 =new Thread(run3);

        th1.start();
        th2.start();
        th3.start();
        thr1.start();
        thr2.start();
        thr3.start();

        System.out.println("**************END**************");
    }
}