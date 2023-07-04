package Thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class A {
    private String  name;
    private int counter;

    public A(String name) {
        super();
        this.name = name;
        counter = 0;
    }

    public void runTest() {

        counter++;

        ScheduledExecutorService sc = Executors.newSingleThreadScheduledExecutor();

        Runnable mytask = ()->{
          
                System.out.println("ThreadName :" + Thread.currentThread().getName() + " name : " + name + "counter ---> " + counter);
                counter++;

        };

        

        sc.scheduleAtFixedRate(mytask, 100, 800, TimeUnit.MILLISECONDS);
    }


}
