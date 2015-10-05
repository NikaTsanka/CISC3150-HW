package myPackage1;

public class ParentClass {
	
	/*
	 * This variable can be accessed:
	 * 		Within the same class. "ParentClass"
	 * 		From any class in the same package. "myPackage1"
	 * 		From any subclass from different package. "myPackage2" 
	 */
	protected int protectedVar = 10;

}
