/*
Program:  obtains values from the command line args and BufferedReader
Author: Akash Roshan A
Reg No: 2047207
Github: akashroshan135
*/

import java.io.*;
class CmdArgs {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		
		int num1 = Integer.parseInt(args[0]);

		System.out.println("Enter a num:");
		int num2 = Integer.parseInt(br.readLine());

		System.out.println("Enter another num:");
		int num3 = Integer.parseInt(br.readLine());

		System.out.println("The three integer numbers are " + num1 + ", " + num2 + " and " + num3);
	}
}