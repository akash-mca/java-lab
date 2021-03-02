package packages;
import java.io.*;

public class person {
	String Name, EmailID, Phone;

	void add() throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter Name:");
		this.Name = br.readLine();

		System.out.println("Enter Email ID:");
		this.EmailID = br.readLine();

		System.out.println("Enter Phone:");
		String Phone = br.readLine();

		// checks if the length of the phone no is 10. If not, a default value is inserted
		if (Phone.length() == 10) this.Phone = Phone;
		else {
			System.out.println("Invalid Phone no. Default 0000000000 is placed");
			this.Phone = "0000000000";
		}
	}

	void add(String Name, String EmailID, String Phone) {	
		this.Name = Name;
		this.EmailID = EmailID;
		if (Phone.length() == 10) this.Phone = Phone;
		else {
			System.out.println("Invalid Phone no. Default 0000000000 is placed");
			this.Phone = "0000000000";
		}
	}

	void modify() throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("\nPress Enter to Continue...");
		br.readLine();
		System.out.println("\nEnter the new details (leave blank to not change)");

		System.out.println("Enter new Name:");
		String Name = br.readLine();
		if (Name != "") this.Name = Name;

		System.out.println("Enter new Email ID:");
		String EmailID = br.readLine();
		if (EmailID != "") this.EmailID = EmailID;

		System.out.println("Enter new Phone:");
		String Phone = br.readLine();
		if (Phone.length() == 10 && Phone != "") this.Phone = Phone;
	}

	void display() {
		System.out.println("Name     : " + Name);
		System.out.println("Email ID : " + EmailID);
		System.out.println("Phone    : " + Phone);
	}
}


