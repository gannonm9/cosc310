package chapter8;
// abstract forces other parts of our program to create a specfiic type of person whenever the construct a person
abstract public class Person {

    String name;
    protected String ID;
    protected String addr;
    protected String email;

    protected Person(String name, String ID, String addr, String email) {
        this.name = name;
        this.ID = ID;
        this.addr = addr;
        this.email = email;
    }

abstract public String getType();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
