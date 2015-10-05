//Citations.
//http://stackoverflow.com/questions/5562548/protected-member-access-from-different-packages-in-java-a-curiosity
//http://javabeginnerstutorial.com/core-java-tutorial/access-modifier-in-java/
package myPackage2;

public class Q1DriverClass0 {

	public static void main(String[] args) {
		/*
		 * Accessing the protected variable through ChildClass
		 * object without extending the ChildClass will not 
		 * work because this class is not extending "inheriting"
		 * the parent class which is the ChildClass. However,
		 * if this class is extending the ChildClass and
		 * we had Q1DriverClass0 object then we would have the
		 * access to the "ParentClass" protected member because
		 * Q1DriverClass0 "is a" ChildClass and ChildClass "is a"
		 * ParentClass. (See Q1DriverClass1.java)
		 */
		
		/* This doesn't work.
		 ChildClass testObj = new ChildClass();
		 System.out.println(testObj.protectedVar);
		*/
		
	}

}

