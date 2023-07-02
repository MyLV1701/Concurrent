package ThreadSYnc;

// A Java program to demonstrate working of
// synchronized.

class Sender {
    
	// public synchronized void send(String msg) {
    public void send(String msg) {

        synchronized(this) {

            
            System.out.println("Sender say  : " + msg);

            try {
                
                Thread.sleep(1000);

            } catch (Exception e) {

                e.printStackTrace();

            }

            System.out.println("the end of Send() method : " + msg);
        }

    }

}


class ThreadTest implements Runnable {

    private String msg;
    private Sender sender;

    public ThreadTest(String msg, Sender sender) {
        this.msg = msg;
        this.sender = sender;
    }
    @Override
    public void run() {

        // synchronized (sender) {
        //     sender.send(msg);
        // }

        sender.send(msg);
        
    }
}


// class ThreadTest extends Thread {

//     private String msg;
//     private Sender sender;

//     public ThreadTest(String msg, Sender sender) {
//         this.msg = msg;
//         this.sender = sender;
//     }
//     @Override
//     public void run() {

//         // synchronized (sender) {
//         //     sender.send(msg);
//         // }

//         sender.send(msg);
        
//     }
// }



public class SyncDemo {

    public static void main(String[] args) {

        // create 2 threads and send 2 message hi, bye 
        Sender sender = new Sender();

        // ThreadTest T1 = new ThreadTest("hi", sender);
        // ThreadTest T2 = new ThreadTest("bye", sender);
        

        // T1.start();
        // T2.start();


        // try {

        //     T1.join();
        //     T2.join();

        // } 
        // catch (Exception e) {

        //     e.printStackTrace();            

        // }

        ThreadTest T1 = new ThreadTest("hi", sender);
        ThreadTest T2 = new ThreadTest("bye", sender);

        Thread thread1 = new Thread(T1);
        Thread thread2 = new Thread(T2);

        thread1.start();
        thread2.start();

        try {

            thread1.join();
            thread1.join();

        } 
        catch (Exception e) {

            e.printStackTrace();            

        }
    }


}