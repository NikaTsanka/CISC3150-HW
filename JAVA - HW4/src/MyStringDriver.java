
public class MyStringDriver {

	public static void main(String[] args) {
		
		char[] array = { 'a', 'r', 't', 'i', 's', 't' };
		
		char[] array1 = { 'R', 'A', 'W'};
		
		char[] array2 = { 'a', 'r', 't', 'i', 's', 't', 's' };
		
		MyString test = new MyString(array);
		
		//
		
		//toString works
		System.out.println(test);
		
		//charAt works
		System.out.println(test.charAt(2));
		
		//length works
		System.out.println(test.length());
		
		//substring works.
		System.out.println(test.substring(1, 4));
		
		//getMyString works
		System.out.println(test.getMyString());
		MyString newmystring = new MyString();
		newmystring = test.getMyString();
		System.out.println(newmystring);
		
		//valueOf works
		System.out.println(MyString.valueOf(6));
		MyString some;
		some = MyString.valueOf(6);
		System.out.println(some);
		
		
		//equals works
		MyString testTo = new MyString(array2);
		
		if (test.equals(testTo)) {
			System.out.println("Yes: " + test.toString() + 
							   " equals " + testTo.toString());
		} else {
			System.out.println("No: " + test.toString() + 
							   " doesn't equal " +
							   testTo.toString());
		}
		
		
		//toLoweCase works
		MyString test2 = new MyString(array1);
		
		System.out.println(test2.toLowerCase());
		
		//toUpperCase 
		System.out.println(testTo.toUpperCase());
		
	}

}
