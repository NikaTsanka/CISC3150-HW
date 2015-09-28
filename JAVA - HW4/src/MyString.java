import java.util.Arrays;

public class MyString {

	//Character array to store the passed characters.
	private char[] chars;

	public MyString(char cPass) {
		this.chars = new char[1];
		
		this.chars[0] = cPass;
	}
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

	public MyString(int i) {


		char intToChar =  (char) ('0' + i);

		this.chars = new char[1];

		this.chars[0] = intToChar;
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
	public String toString() {
		String printStr = new String(chars);

		return printStr;
	}

	//not working.
	//	public static MyString valueOf(int i) {
	//		
	//		MyString val = new MyString(i);
	//		
	//		return val;
	//	}

	//works
//	public boolean equals(MyString s) {
//		if (this.chars.length == s.length() &&
//			this.chars[0] == s.charAt(0)) {
//			return true;
//		}
//		return false;
//	}
	
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
	

	//
	public MyString getMyString() {
		return new MyString(chars);
	}



}
