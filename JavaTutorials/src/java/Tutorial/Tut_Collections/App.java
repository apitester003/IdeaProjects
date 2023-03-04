package Tutorial.Tut_Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrStr = {"Hello", "World"};
		Laptop laptop = new Laptop();
		Laptop anotherLaptop = new Laptop();
		Integer[] arrInts = {1, 2, 3};
		laptop.genericMethod(arrStr);
		laptop.genericMethod(arrInts);	
		
		//equals demo
		laptop.setManufacturer("Lenovo");
		anotherLaptop.setManufacturer("lenovo");
		System.out.println(laptop.equals(anotherLaptop));		//result will be false
		
		List<String> list = new ArrayList<String>();
		List<String> list1 = new LinkedList<String>();
		
		//Add Values
		list.add("Samarendra");
		list.add("Pratap");
		list.add("Sahoo");
		
		//Remove Values
		list.remove(1);	//Removes "Pratap"
		
		//Retrieve Values
		list.get(1);	//Returns "Sahoo"
		
		//Update values
		list.set(0, "Sam");
		
		System.out.println(list);
		
		//Length of the list
		System.out.println(list.size());
		
		for(String item : list){
			System.out.println(item);
		}		
	}

}
