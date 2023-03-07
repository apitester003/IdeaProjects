package Tutorial;

import Tutorial.Tut_Collections.Laptop;

public class Tut_CustomToStringDemo {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.setManufacturer("HP");
        System.out.println(laptop.getManufacturer());
    }
}
