
public class MyStringDriver {

	public static void main(String[] args) {
		
		char[] array = { 'a', 'r', 't', 'i', 's', 't' };
		
		char[] array2 = { 'a', 'r', 't', 'i', 's', 't', 's' };
		
		MyString test = new MyString(array);
		
		//toString works
		System.out.println(test);
		
		//charAt works
		System.out.println(test.charAt(2));
		
		//length works
		System.out.println(test.length());
		
		//substring works.
		System.out.println(test.substring(1, 4));
		
		//getMyString
		System.out.println(test.getMyString());
		
		//valueOf
		//System.out.println(MyString.valueOf(7));
		
		//equals
//		test = null;
//		test = new MyString('s', '5');
		
		MyString testTo = new MyString(array2);
		
		if (test.equals(testTo)) {
			System.out.println("Yes: " + test.toString() + 
							   " equals " + testTo.toString());
		} else {
			System.out.println("No: " + test.toString() + 
							   " doesn't equal " +
							   testTo.toString());
		}
		
		
		

	}

}
