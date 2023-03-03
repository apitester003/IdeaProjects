package Tutorial.Tut_Collections;

public class Tablet extends Computer {
    @Override
    public void start() {
        System.out.println("Tablet started");
    }

    @Override
    public void showInfo() {
        System.out.println("ShowInfo() method for tablet is called");
    }
}