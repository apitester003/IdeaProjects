package Tutorial.Tut_AbstractClass;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.setID(1);
		car.drive();
		
		System.out.println("The car brand is: " + car.getBrand());
	}

}
