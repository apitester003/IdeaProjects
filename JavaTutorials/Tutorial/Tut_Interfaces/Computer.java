package Tutorial.Tut_Interfaces;
import Tutorial.Tut_AbstractClass.*;

public class Computer extends Vehicle implements Info  {
	
	private int id = 1;
	
	public void start(){
		System.out.println("Computer Started.");
	}

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		
	}

	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.println("Computer ID is: " + id);
	}

}
