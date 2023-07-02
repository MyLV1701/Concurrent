package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestThread {
    

    private static ExecutorService ex = null;

    public ExecutorService getExecutors() {
        if (ex != null) {
            System.out.println("EXISTED");
            return ex;

        }
        else {
            System.out.println("CREATING NEW ");
            ex = Executors.newSingleThreadExecutor();
        }

        return ex;
    }

    public static void main(String[] args) {

        System.out.println("hello world");

        TestThread test = new TestThread();
        test.test();

    }


    private void test() {

        for (;;) {
            
            ExecutorService executor = getExecutors();

            Callable<Integer> callable = new Callable<Integer>() {
                @Override
                public Integer call() {
                    return (int)(Math.random()*100);
                }
            };
            Future<Integer> future = executor.submit(callable);
            try {
                if (future.get() % 2 < 1) {
                    System.out.println("-------------------->>> : " + "TRUE");
                }
                else
                {
                    System.out.println("-------------------->>> : " + "FALSE");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(3000);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
