package Logic;

import java.util.Random;

public class RunnableClass implements Runnable{

    private String name;
    private  int cont = 1;

    public RunnableClass(String name) {
        this.name = name;
    }

    @Override
    public synchronized void run() {
        for (cont =1; cont < 10 ; cont++){
            System.out.printf("%s------>%d\n",Thread.currentThread().getName(),cont);
            try{
                Thread.sleep(new Random().nextInt(2000));
            }catch (InterruptedException e){
                throw  new RuntimeException(e);
            }
        }
    }
}
