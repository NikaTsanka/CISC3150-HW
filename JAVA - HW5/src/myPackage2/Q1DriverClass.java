//Citations.
//http://stackoverflow.com/questions/5562548/protected-member-access-from-different-packages-in-java-a-curiosity
//http://javabeginnerstutorial.com/core-java-tutorial/access-modifier-in-java/
package myPackage2;

public class Q1DriverClass {

	public static void main(String[] args) {
		/*
		 * This will not work because this class is not
		 * extending "inheriting" the parent class.
		 * If this class was extending the ChildClass and
		 * we had Q1DriverClass object then we would have the
		 * access to the "ParentClass" protected member.
		 */
		ChildClass testObj = new ChildClass();
		
		//This doesn't work.
		//System.out.println(testObj.protectedVar);
		
	}

}
