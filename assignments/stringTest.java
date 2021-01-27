/*
Program: Tests various string methods
Author: Akash Roshan A
Reg No: 2047207
Github: akashroshan135
*/
import java.io.*;
class stringTest {
	public static void main(String args[]) throws IOException {
		int choice;
		String string1, string2;
		do {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("\tString Operations\n1. concat\n2. length\n3. charAt\n4. equals\n5. compareTo\n6. toLowerCase\n7. toUpperCase\n8. trim\n9. Exit\n");
			System.out.println("Enter your choice:");
			choice = Integer.parseInt(br.readLine());

			switch(choice) {
				case 1: System.out.println("\nEnter the first string: ");
					string1 = br.readLine();
					System.out.println("Enter the second string: ");
					string2 = br.readLine();
					System.out.println("\nThe concatenated string  is: " + string1.concat(string2));
					break;
				case 2: System.out.println("\nEnter the string: ");
					string1 = br.readLine();
					System.out.println("\nThe length of the string is " + string1.length());
					break;
				case 3: System.out.println("\nEnter the  string: ");
					string1 = br.readLine();
					System.out.println("Enter the position: ");
					int n = Integer.parseInt(br.readLine());
					System.out.println("\nThe character at position " + n + " is " + string1.charAt(n));
					break;
				case 4: System.out.println("\nEnter the first string: ");
					string1 = br.readLine();
					System.out.println("Enter the second string: ");
					string2 = br.readLine();
					System.out.println("\nThe strings are equal -> " + string1.equals(string2));
					break;
				case 5: System.out.println("\nEnter the first string: ");
					string1 = br.readLine();
					System.out.println("Enter the second string: ");
					string2 = br.readLine();
					System.out.println("\nThe strings are equal -> (0), not equal -> (-ve value): " + string1.compareTo(string2));
					break;
				case 6: System.out.println("\nEnter the string: ");
					string1 = br.readLine();
					System.out.println("\nThe lowercase of the string is " + string1.toLowerCase());
					break;
				case 7: System.out.println("\nEnter the string: ");
					string1 = br.readLine();
					System.out.println("\nThe uppercase of the string is " + string1.toUpperCase());
					break;
				case 8: System.out.println("\nEnter the string: ");
					string1 = br.readLine();
					System.out.println("\nThe trimmed string is " + string1.trim());
					break;
			}
			
			System.out.println("\nPress Enter to Continue...");
			br.readLine();	
		} while (choice < 9);
	}
}
