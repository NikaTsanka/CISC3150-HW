
public class MyStringDriver {

	public static void main(String[] args) {

		//Character arrays to test the MyString class.
		char   s      = 'c';
		char[] array  = { 'j', 'a', 'v', 'a' };
		char[] array0 = { 'j', 'a', 'v', 'a' };
		char[] array1 = { 'C', 'A', 'P', 'I', 'T', 'A', 'L' };
		char[] array2 = { 'P', 'l', 'a', 't', 'f', 'o', 'r', 'm' };

		//Single char constructor. Works.
		MyString testSingleChar = new MyString(s);
		System.out.printf("\"MyString(char singleChar)\" constructor: "
				+ "%s\n", testSingleChar);

		//This object will be used to test rest of the methods.
		MyString test = new MyString(array);

		//toString. Works.
		System.out.println("\"toString()\" method: " + test);

		//charAt. Works.
		System.out.println("\"charAt(int index)\" method: "
				+ test.charAt(2));

		//length. Works.
		System.out.println("\"length()\" method: " + test.length());

		//substring. Works.
		System.out.println("\"substring(int begin, int end)\" method: "
				+ test.substring(1, 3));

		//toLoweCase. Works.
		MyString testObj;
		MyString test0 = new MyString(array1);
		testObj = test0.toLowerCase();
		System.out.println("\"toLowerCase()\" method: " 
				+ testObj);

		//toUpperCase. Works.
		MyString test1 = new MyString(array2);
		System.out.println("\"toUpperCase()\" method: " 
				+ test1.toUpperCase());

		//equals works
		MyString test2 = new MyString(array0);
		System.out.println("\"equals(MyString s)\" method: ");
		if (test.equals(test2)) {
			System.out.println("\tYes: " + test.toString() + 
					" equals " + test2.toString());
		} 
		if (!(test.equals(test0))) {
			System.out.println("\tNo: " + test.toString() + 
					" doesn't equal " +
					test0.toString());
		}

		//getMyString. Works
		System.out.println("\"getMyString()\" method: " 
				+ test.getMyString());

		//valueOf. Works
		System.out.println("\"valueOf(int i)\" method: "
				+ MyString.valueOf(8));

	}
}
