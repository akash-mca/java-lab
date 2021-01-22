/*
Program: Reads values from the BufferedReader and wraps it into an integer
Author: Akash Roshan A
Reg No: 2047207
Github: akashroshan135
*/

import java.io.*;
class readIntBuff {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));

		System.out.println("Enter num:");
		int num = Integer.parseInt(br.readLine());

		System.out.println("Num = " + num);
	}
}