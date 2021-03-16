package packages;
import java.io.*;

public class manager extends person {
	static int id = 1;
	int Manager_ID;
	private String Manager_Password;
	String Manager_Hub;
	float Manager_Salary;

	public manager() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.Manager_ID = id++;
		super.add();

		System.out.println("Enter Password:");
		this.Manager_Password = br.readLine();

		System.out.println("Enter Hub:");
		this.Manager_Hub = br.readLine();

		System.out.println("Enter Salary:");
		try {
			this.Manager_Salary = Float.parseFloat(br.readLine());
		} catch (Exception e) {
			System.out.println("Incorrect input. Salary is set to 30000");
			this.Manager_Salary = 30000;
		}
	}

	public void modify() throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Please enter your password, " + Name + ": ");
		String password = br.readLine();

		// checks if the input password and the stored password matches
		if (password.equals(Manager_Password)) {
			super.modify();

			System.out.println("Enter new Hub:");
			String hub = br.readLine();
			if (hub != "") this.Manager_Hub = hub;

			System.out.println("Enter new Salary:");
			String salary = br.readLine();
			if (salary != "") this.Manager_Salary = Float.parseFloat(salary);

		} else System.out.println("Invalid Password");

	}

	public void display() {
		System.out.println("ID       : " + Manager_ID);
		super.display();
		System.out.println("Hub      : " + Manager_Hub);
		System.out.println("Salary   : " + Manager_Salary);
		System.out.println("");
	}
}
