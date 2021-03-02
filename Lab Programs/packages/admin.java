package packages;
import java.io.*;

public class admin extends person {
	static int id = 1;
	int Admin_ID;
	private String Admin_Password;

	public admin() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		this.Admin_ID = id++;
		super.add();
		System.out.println("Enter Password:");
		this.Admin_Password = br.readLine();
	}

	public void modify() throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Please enter your password, " + Name + ": ");
		String password = br.readLine();
		// checks if the input password and the stored password matches
		if (password.equals(Admin_Password)) {
			super.modify();
		} else System.out.println("Invalid Password");
	}

	public void display() {
		System.out.println("ID       : " + Admin_ID);
		super.display();
		System.out.println("");
	}
	
}

