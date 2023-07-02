package ThreadDeadlock;


/**
 * The following scenario demonstrate deadlock
 *      There are two objects and two resources
 *
 *      The first object locked first resource, and second object locked second resource.
 *      Now first object is trying to access second resource which is acquired by second object,
 *      and second object is trying to access first resource which is acquired by the first one.
 *
 *      Desktop ---> Printer ( locked)
 *      laptop  ---> Scanner ( locked)
 *
 *      Desktop ---> Scanner
 *      laptop  ---> Printer 
 */



public class RunnableDeadLock {
    public static void main(String[] args) {
        final String printer = "My Printer";
        final String scanner = "My Scanner";

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                synchronized(printer) {
                    
                    System.out.println(Thread.currentThread().getName() + " Locked resource : " + printer);

                    try {
                        Thread.sleep(1000);  // sleep for 1 second
                    } catch (Exception e) {
                        // TODO: handle exception
                    }

                    synchronized(scanner) {
                        System.out.println(Thread.currentThread().getName() + " Locked resource : " + scanner);
                    }

                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                synchronized(scanner) {
                    
                    System.out.println(Thread.currentThread().getName() + " Locked resource : " + scanner);

                    try {
                        Thread.sleep(1000);  // sleep for 1 second
                    } catch (Exception e) {
                        // TODO: handle exception
                    }

                    synchronized(printer) {
                        System.out.println(Thread.currentThread().getName() + " Locked resource : " + printer);
                    }

                }
            }
        };


        Thread T1 = new Thread(task1);
        T1.setName("DeskTop");

        Thread T2 = new Thread(task2);
        T2.setName("Laptop");

        T1.start();
        T2.start();

    }
}
