package ThreadWaitNotify;

public class ThreadWaitNotify {
    
    static class Customer {

        private int amount;

        public Customer(int amount) {
            super();
            this.amount = amount;
        }

        // withdraw method
        public synchronized void withdraw(int money) {
            
            if (amount < money) {

                System.out.println("Current amount : " + amount + " NOT ENOUGH for purchasing");

                try {
                    
                    System.out.println("To be waiting for deposit ...");
                    wait();    
                    
                } catch (Exception e) {
                    
                    e.printStackTrace();
                }
                
            }
            
            System.out.println("Already purchased --> available balance : " + (amount - money));

        }


        // deposit method 
        public synchronized void deposit(int money) {
            System.out.println("Deposit amout : " + money + "$");
            this.amount += money;
            
            try {

                System.out.println("Notify to another threads are waiting for ");
                // notify();
                notifyAll();
                  

            } catch (Exception e) {
            
                e.printStackTrace();
            
            }

            System.out.println("Balance now is : " + this.amount + "$");
        }

    }


    public static void main(String[] args) {

        Customer customer = new Customer(1000);

        //  create new thread --> call withdraw --> 1500$
        new Thread() {
            @Override
            public void run() {
                customer.withdraw(1500);
            };
        }.start();


        // create new thread --> deposit 1000$ 
        new Thread() {
            @Override
            public void run() {
                customer.deposit(1000);
            }
        }.start();


        // Thread T1 = new Thread() {
        //     @Override
        //     public void run() {
        //         customer.withdraw(1500);
        //     };
        // };

        // Thread T2 = new Thread() {
        //     @Override
        //     public void run() {
        //         customer.deposit(1000);
        //     }
        // };

        
        // T1.start();
        // T2.start();
        

        // try {

        //     T1.join();
        //     T2.join();
            
        // } catch (Exception e) {

        //     e.printStackTrace();

        // }

        
    }
}
