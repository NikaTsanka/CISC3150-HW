import java.util.Arrays;

public class MyString {

	//Character array to store the passed characters.
	private final char[] charsArray;

	/**
	 * Default Constructor
	 * Initializes charsArray[] to 0.
	 * Using this constructor is pointless since the
	 * charsArray[] is immutable.
	 */
	public MyString() {
		//this will simply create an empty charsArray
		this.charsArray = new char[0];
	}

	/**
	 * Main Constructor
	 * This constructor initializes the charsArray[] array
	 * with the passed charsArray argument.
	 * @param charsArray
	 */
	public MyString(char[] chars) {
		this.charsArray = new char[chars.length];

		for (int i = 0; i < chars.length; i++) {
			this.charsArray[i] = charsArray[i];
		}
	}

	/**
	 * Constructor for valueOf method
	 * First int is converted to char value
	 * and then it initializes charsArray to 1
	 * and stores "parsed" int to charsArray.
	 * Also this is private because valueOf method
	 * should be the only method to call it.
	 * @param i
	 * 		The passed int argument.
	 */
	private MyString(int i) {
		//This way didn't work. :)
		//char intToChar =  (char) (i);

		//Convert int to char and store it.
		char intToChar = Integer.toString(i).charAt(0);
		//Initialize tje charsArray to 1. 
		this.charsArray = new char[1];
		//And store the char to charsArray.
		this.charsArray[0] = intToChar;
	}

	/**
	 * This method returns a character at a specified
	 * index.
	 * @param index		the index of the value.
	 * @return the character value at the specified index.
	 */
	public char charAt(int index){
		return this.charsArray[index];
	}

	/**
	 * This method simply returns the length of the 
	 * charArray.
	 * @return the length of the characters.
	 */
	public int length() {
		return this.charsArray.length;
	}

	/**
	 * This method returns a substring of the MyString
	 * object specified by the beginning and ending 
	 * parameters. 
	 * @param begin the begin index, inclusive.
	 * @param end the end index.
	 * @return the substring of the string.
	 */
	public MyString substring(int begin, int end) {

		if (begin < 0 || end < 0) {
			System.out.println("/'Begin/' or /'End/' index " +
							"cannot be a negative number.");
			throw new IndexOutOfBoundsException();
		}
		if (begin > end) {
			System.out.println("/'Begin/' cannot be bigger " + 
							"than /'end/'.");
			throw new IndexOutOfBoundsException();
		}
		if (begin == end) {
			System.out.println("/'Begin/' and /'end/'" + 
							" cannot be the same.");
			throw new IndexOutOfBoundsException();
		}
		if (end > charsArray.length) {
			System.out.println("/'end/' is literarely" + 
					" out of bound :D .");
			throw new IndexOutOfBoundsException();
		}

		MyString subString = new MyString(
				Arrays.copyOfRange(this.charsArray, 
						begin, end));

		return subString;
	}

	/**
	 * This function overrides the 
	 * java.lang.Object.toString method 
	 * and returns MyString to print.
	 */
	@Override
	public String toString() {
		String printStr = new String(charsArray);

		return printStr;
	}

	/**
	 * This method accepts an int argument
	 * calls the MyString(int i) constructor
	 * to convert the int to char
	 * @param i integer to be converted.
	 * @return returns an int as a char.
	 */
	public static MyString valueOf(int i) {
		MyString val = new MyString(i);

		return val;
	}

	//works
	public boolean equals(MyString s) {
		int flag = 0;

		if (this.charsArray.length == s.length()) {
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
		return new MyString(charsArray);
	}

	public MyString toLowerCase() {

		for (int i = 0; i < charsArray.length; i++) { 
			this.charsArray[i]
					= Character.toLowerCase(this.charAt(i));
		}

		//I didn't know I could do this. :D 
		return this;
	}

	public MyString toUpperCase() {
		for (int i = 0; i < charsArray.length; i++) { 
			this.charsArray[i]
					= Character.toUpperCase(this.charAt(i));
		}
		return this;
	}


}
