package packages;
import java.io.*;

public class courier extends person {
	static int id = 1;
	int Courier_ID;
	private String Courier_Password;
	String Courier_Hub;
	String Courier_Manager;
	float Courier_Salary;

	public courier() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.Courier_ID = id++;
		super.add();

		System.out.println("Enter Password:");
		this.Courier_Password = br.readLine();

		System.out.println("Enter Hub:");
		this.Courier_Hub = br.readLine();

		System.out.println("Enter Manager:");
		this.Courier_Manager = br.readLine();

		System.out.println("Enter Salary:");
		try {
			this.Courier_Salary = Float.parseFloat(br.readLine());
		} catch (Exception e) {
			System.out.println("Incorrect input. Salary is set to 20000");
			this.Courier_Salary = 20000;
		}
	}

	public void modify() throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Please enter your password, " + Name + ": ");
		String password = br.readLine();

		// checks if the input password and the stored password matches
		if (password.equals(Courier_Password)) {
			super.modify();

			System.out.println("Enter new Hub:");
			String hub = br.readLine();
			if (hub != "") this.Courier_Hub = hub;

			System.out.println("Enter new Manager:");
			String manager = br.readLine();
			if (manager != "") this.Courier_Manager = manager;

			System.out.println("Enter new Salary:");
			String salary = br.readLine();
			if (salary != "") this.Courier_Salary = Float.parseFloat(salary);

		} else System.out.println("Invalid Password");

	}

	public void display() {
		System.out.println("ID       : " + Courier_ID);
		super.display();
		System.out.println("Hub      : " + Courier_Hub);
		System.out.println("Manager  : " + Courier_Manager);
		System.out.println("Salary   : " + Courier_Salary);
		System.out.println("");
	}
}
