import java.util.Arrays;

public class MyString {

	//Character array to store the passed characters.
	private final char[] chars;

	/**
	 * Constructor to store the passed characters in
	 * private character array.
	 * @param charPass
	 */
	public MyString(char[] charsPass) {
		this.chars = new char[charsPass.length];

		for (int i = 0; i < charsPass.length; i++) {
			this.chars[i] = charsPass[i];
		}
	}

	private MyString(int i) {
		//char intToChar =  (char) (i);
		
		char intToChar = Integer.toString(i).charAt(0);

		this.chars = new char[1];

		this.chars[0] = intToChar;
	}
	
	public MyString() {
		//this will simply create an empty chars 
		this.chars = new char[0];
	}

	//works
	public char charAt(int index){
		return this.chars[index];
	}

	//works
	public int length() {
		return this.chars.length;
	}

	public MyString substring(int begin, int end) {
		MyString subString = new MyString(
				Arrays.copyOfRange(this.chars, begin, end));

		return subString;
	}

	//works
	@Override
	public String toString() {
		String printStr = new String(chars);

		return printStr;
	}

	//works
	
	//this simply has to return a mystring. 
	
	public static MyString valueOf(int i) {
		
		MyString val = new MyString(i);

		return val;
	}

	//works
	public boolean equals(MyString s) {

		int flag = 0;

		if (this.chars.length == s.length()) {
			for (int i = 0; i < s.length(); i++) {
				if (this.charAt(i) == s.charAt(i)){
					flag++;
				}
			}
			if (flag == s.length()) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}


	//works
	public MyString getMyString() {
		return new MyString(chars);
	}
	
	public MyString toLowerCase() {
		
		for (int i = 0; i < chars.length; i++) { 
			this.chars[i]
			= Character.toLowerCase(this.charAt(i));
		}
		
		//I didn't know I could do this. :D 
		return this;
	}
	
	public MyString toUpperCase() {
		for (int i = 0; i < chars.length; i++) { 
			this.chars[i]
			= Character.toUpperCase(this.charAt(i));
		}
		return this;
	}
	
	
}
