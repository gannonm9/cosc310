package chapter8;

public class Student extends Person {




    public Student(String name, String ID, String addr, String email) {
        super(name, ID, addr, email);
    }
    

       @Override
    public String getType() {
        return "Student";
    }
}
