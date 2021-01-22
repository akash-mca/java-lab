/*
Program: menu driven program to print all even and odd numbers from 1-50
Author: Akash Roshan A
Reg No: 2047207
Github: akashroshan135
*/

import java.io.*;
class OddEven {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		do {
			System.out.println("\tOdd or Even");
			System.out.println("1. Odd numbers from 1-50\n2. Even numbers from 1-50\n3. Exit");
			System.out.println("Enter your choice:");
			choice = Integer.parseInt(br.readLine());

			switch (choice) {
				case 1: for (int i = 1; i < 50; i+=2) System.out.print(i + ", ");
					break;
				case 2: for (int i = 2; i <= 50; i+=2) System.out.print(i + ", ");
					break;
				case 3: break;
				default:break;
			}

			System.out.println("\nPress Enter to Continue...");
			br.readLine();
		} while (choice < 3);
	}
}