package Logic;

import java.util.Random;

public class ThreadClass extends Thread{

    private String name;

    public ThreadClass(String name) {
        this.name = name;
    }

    @Override
    public void run() {
       for (int cont =1; cont < 10 ; cont++){
           System.out.printf("%s------>%d\n",name,cont);
           try{
               sleep(new Random().nextInt(2000));
           }catch (InterruptedException e){
               throw  new RuntimeException(e);
           }
       }
    }
}
