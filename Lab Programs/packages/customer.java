package packages;
import java.io.*;

public class customer extends person {
	static int id = 1;
	int Customer_ID;
	String Customer_Address;

	public customer() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.Customer_ID = id++;
		super.add();

		System.out.println("Enter Address:");
		this.Customer_Address = br.readLine();
	}

	public void display() {
		System.out.println("ID       : " + Customer_ID);
		super.display();
		System.out.println("Address  : " + Customer_Address);
		System.out.println("");
	}
}