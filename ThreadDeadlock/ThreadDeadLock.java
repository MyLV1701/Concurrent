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
 * 
 *      https://www.youtube.com/watch?v=U9xgNfjIFlQ
 */


class Printer {
    
    private String name;
    
    public Printer(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

class Scanner {
    
    private String name;

    public Scanner(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}



class ThreadPrinter extends Thread {

    Printer printer;
    Scanner scanner;

    public ThreadPrinter(Printer pt, Scanner sc ) {

        this.printer = pt;
        this.scanner = sc;

    }

    @Override
    public void run() {
        super.run();

        useDevices(printer, scanner);

    }


    public void useDevices(Printer pt, Scanner sc) {

        synchronized(pt) {

            System.out.println("Using printer name : " + pt.getName());

            try {

                Thread.sleep(1000);  // sleep 1 second

            } catch (Exception e) {

                e.printStackTrace();

            }

            synchronized(sc) {
                System.out.println("Using Scanner name : " + sc.getName());
            }

        }



    }

}

class ThreadScanner extends Thread {

    Printer printer;
    Scanner scanner;

    public ThreadScanner(Printer pt, Scanner sc ) {

        this.printer = pt;
        this.scanner = sc;

    }

    @Override
    public void run() {
        super.run();

        useDevices(printer, scanner);

    }


    public void useDevices(Printer pt, Scanner sc) {

        synchronized(sc) {

            System.out.println("Using printer name : " + sc.getName());

            try {

                Thread.sleep(1000);  // sleep 1 second

            } catch (Exception e) {
                e.printStackTrace();
            }

            synchronized(pt) {
                System.out.println("Using Scanner name : " + pt.getName());
            }
        }


    }


}

 
public class ThreadDeadLock {
 
    public static void main(String[] args) {

        Printer pt = new Printer("My Printer");
        Scanner sc = new Scanner("My Scanner");

        System.out.println("Programe demonstrate Deadlock ----->>> ");

        ThreadPrinter T1  = new ThreadPrinter(pt, sc);
        ThreadScanner T2  = new ThreadScanner(pt, sc);
        
        T1.start();
        T2.start();

        // try {
            
        //     T1.join();
        //     T2.join();

        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

    }

}
