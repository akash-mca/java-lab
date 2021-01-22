/*
Program:  does a Floyd Triangle
Author: Akash Roshan A
Reg No: 2047207
Github: akashroshan135
*/
import java.io.*;
class floydtriangle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the number of rows:");
		int rows = Integer.parseInt(br.readLine());
		int num = 1;

		System.out.println("");
		for (int i = 1; i <= rows; i++) {
			for (int j = 0; j < i; j++) System.out.print(num++ + " ");
			System.out.println("");
		}
	}
}