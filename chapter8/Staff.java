package chapter8;

public class Staff extends Employee {


    public Staff(String name, String ID, String addr, String email) {
        super(name, ID, addr, email);
    }



       @Override
    public String getType() {
        return "Staff";
    }
}



