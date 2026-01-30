package chapter8;

public class Banner {
public static void main (String[] args) {
    Person persons[] = new Person[15_000];
    persons[0] = new Student("John Smith", "900234567", "123 Street, city, state, zip, USA", "jsmith@samford.edu");
    persons[1] = new Faculty("Dr. Jane Doe", "800345678", "456 Avenue, city, state, zip, USA", "jdoe@samford.edu");
    persons[2] = new Staff ("Mr. Bob Brown", "700456789", "789 Boulevard, city, state, zip, USA", "bobby@samford.edu");

    

}
}