/*
Program: Checks if string is palindrome or not with and without using inbuilt methods
Author: Akash Roshan A
Reg No: 2047207
Github: akashroshan135
*/

import java.io.*;
class palindrome {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		String text;
		StringBuffer revText = new StringBuffer();

		do {
			System.out.println("Enter a string:");
			text = br.readLine();
			// used to clear StringBuffer memory
			revText.setLength(0);

			System.out.println("\tPalindrome");
			System.out.println("1. Inbuilt function\n2. User function\n3. Exit");
			System.out.println("Enter your choice:");
			choice = Integer.parseInt(br.readLine());

			switch (choice) {
				case 1: revText.append(text);
						revText.reverse();
						break;
				case 2: for (int i = text.length() - 1; i >= 0; i--) revText.append(text.charAt(i));
						break;
				default:break;
			}

			if (text.equals(revText.toString())) System.out.println(text + " is a palindrome");
			else System.out.println(text + " is not a palindrome");

			System.out.println("\nPress Enter to Continue...");
			br.readLine();
		} while (choice < 3);
	}
}