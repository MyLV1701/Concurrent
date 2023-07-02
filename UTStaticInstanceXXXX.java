public class UTStaticInstanceXXXX {
    private String name;
    private int age;
    private String gender;

    public UTStaticInstanceXXXX(String n, int a, String g) {
        name    = n;
        age     = a;
        gender  = g;
    }

    public String ToString() {
        String ret = "";
        ret += "Name : " + name + " Age : " + age + " Gender : " + gender; 
        return ret;
    }


    public String getName() {
        return name;
    }

    public void setName(String n)  {
        name =  n;
    }

    public void setAge(int ag) {
        age = ag;
    }

    public int getAge()  {
        return age;
    }

    public void setGender(String g) {
        gender = g;
    }

    public String getGender() {
        return gender;
    }

}
