import java.util.Hashtable;

public class TestUTStaticInstance {
    public static void main(String[] args) {

        TestUTStaticInstance test1 = new TestUTStaticInstance();
        test1.setInstance1();

        TestUTStaticInstance test2 = new TestUTStaticInstance();
        test2.setInstance2();

        TestUTStaticInstance test3 = new TestUTStaticInstance();
        test3.setInstance3();

        test1.setInstance1a();

        test1.test();
    }

    private class UTStaticInstance {

        private String name;
        private int age;
        private String gender;
    
        public UTStaticInstance(String n, int a, String g) {
            name    = n;
            age     = a;
            gender  = g;
        }
    
        public String ToString() {
            String ret = "";
            ret += "Name : " + name + " Age : " + age + " Gender : " + gender; 
            return ret;
        }

    }

    private static Hashtable<String, UTStaticInstance> h = new Hashtable<>();


    private Hashtable<String, UTStaticInstance> getInstance() {
        return h;
    }
    
    private void setData(String ip, UTStaticInstance instance) {
        if (instance != null) h.put(ip, instance);
        
    }
    
    private void setInstance1() {
        UTStaticInstance u1 = new UTStaticInstance("A", 18, "Female");

        setData("1", u1);
    }

    private void setInstance2() {
        UTStaticInstance u2 = new UTStaticInstance("B", 30, "Man");
        setData("2", u2);
    }

    private void setInstance3() {
        UTStaticInstance u3 = new UTStaticInstance("C", 60, "Female");
        setData("3", u3);
    }

    private void setInstance1a() {
        UTStaticInstance u1 = new UTStaticInstance("A", 25, "Man");

        setData("1", u1);
    }

    private void test()  {
        for (;;) {

            try {
                
                if (getInstance().containsKey("1")) {
                    System.out.println("TestUTStaticInstance.test() ----> key 1 = " + getInstance().get("1").ToString());
                }


                if (getInstance().containsKey("2")) {
                    System.out.println("TestUTStaticInstance.test() ----> key 2 = " + getInstance().get("2").ToString());
                }

                if (getInstance().containsKey("3")) {
                    System.out.println("TestUTStaticInstance.test() ----> key 3 = " + getInstance().get("3").ToString());
                }

                
                Thread.sleep(3000);

            } 
            catch (Exception e) {
                
                e.printStackTrace();

            }
            
        }
    }
}
