/*
Program: Reads values from Scanner class
Author: Akash Roshan A
Reg No: 2047207
Github: akashroshan135
*/

import java.util.*;
class TestScan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter an integer:");
		int num = sc.nextInt();

		System.out.println("Enter name:");
		String name = sc.next();

		System.out.println("You have entered " + num  + " and name as " + name);
	}
}