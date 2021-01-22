/*
Program: Testing BufferedReader
Author: Akash Roshan A
Reg No: 2047207
Github: akashroshan135
*/

import java.io.*;
class TestBuffer {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));

		System.out.println("Enter num:");
		int num = Integer.parseInt(br.readLine());

		System.out.println("Enter name:");
		String name = br.readLine();

		System.out.println("You have entered " + num  + " and name as " + name);
	}
}