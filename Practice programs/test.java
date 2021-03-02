import java.io.*;

public class test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int no1, no2, sum;
		System.out.println("Enter the number 1:");
		try {
			no1 = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			System.out.println("no a number");
			no1 = 1;
		}
		
		System.out.println("Enter the number 2:");
		no2 = Integer.parseInt(br.readLine());
		sum = 0;
		try {
			sum = no1 / no2;
		} catch (ArithmeticException e) {
			System.out.println("number is divided by zero");
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			System.out.println("Sum = " + sum);
		}
		
	}
}
