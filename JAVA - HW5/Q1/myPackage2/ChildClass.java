package myPackage2;

import myPackage1.ParentClass;

public class ChildClass extends ParentClass {

	public static void main(String[] args) {
		/*
		 * This class extends the "ParentClass" so it has access
		 * to the protected variable "protectedVar" through the
		 * its own instance because the relationship is "IS A" and
		 * if we simply created parent class object we will not
		 * have access to it since this class is in the different
		 * package. Protected variable is only accessible by inheritance
		 * in different packages.
		 */
		ChildClass testObj = new ChildClass();
		
		//This works
		System.out.println(testObj.protectedVar);
		
	}

}
