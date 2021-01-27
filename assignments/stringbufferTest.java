/*
Program: Tests various StringBuffer methods
Author: Akash Roshan A
Reg No: 2047207
Github: akashroshan135
*/
import java.io.*;
class stringbufferTest {
	public static void main(String args[]) throws IOException {

		StringBuffer text = new StringBuffer("Text");
		text.append(", More Text");

		String stringText = text.toString();

		StringBuffer revText = new StringBuffer();
		revText.append(text);
		revText.reverse();

		System.out.println("Text : " + text);
		System.out.println("Text to string : " + stringText);
		System.out.println("Text capacity : " + text.capacity());
		System.out.println("Text lenght : " + text.length());
		System.out.println("Reversed Text  : " + revText);
	}
}
