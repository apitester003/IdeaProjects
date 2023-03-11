package testNGDemo;

import org.testng.annotations.Test;

@Test(groups={"AllClassTests"})		//When a group is defined in the class level, then all the methods inside the class becomes the part of the test
public class TestNGGroupDemo {
	
	@Test(groups={"sanity"})
	public static void test1() {
		System.out.println("This is Test 1");
	}
	
	@Test(groups={"sanity","smoke"})
	public static void test2() {
		System.out.println("This is Test 2");
	}
	
	@Test(groups={"regression","sanity"})
	public static void test3() {
		System.out.println("This is Test 3");
	}
	
	@Test
	public static void test4() {
		System.out.println("This is Test 4");
	}
}
