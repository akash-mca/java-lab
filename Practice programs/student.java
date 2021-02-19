import java.io.*;

class test {
	static id = 1;
	static Student mca[] = new Student[5];

	public static void main(String[] args) throws IOException {
		int totalstudents;

		mca[id] = new Student();
		mca[id].display();
		totalstudents= id
		id++;
		for (int i = 1; i <= totalstudents; id++)
	}
}

class Student {
	int regno;
	String name;
	String mailid;
	String DOB;
	int[] subMarks = new int[5];
	int totalMarks;
	float percentage;
	static int id = 201;
	Student() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		this.regno = id++;

		System.out.println("Enter Name:");
		this.name = br.readLine();
		
		System.out.println("Enter mailid:");
		this.mailid = br.readLine();

		System.out.println("Enter Dob (dd-mm-yyyy):");
		this.DOB = br.readLine();

		this.totalMarks = 0;
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter Subject " + i+1 + " marks : ");
			subMarks[i] = Integer.parseInt(br.readLine());
			this.totalMarks += subMarks[i];
		}
		this.percentage = (this.totalMarks / 500) * 100;
	}
	void display() {
		System.out.println("Reg No          : " + regno);
		System.out.println("Name            : " + name);
		System.out.println("Email           : " + mailid);
		System.out.println("DOB             : " + DOB);
		for (int i = 0; i < 5; i++) {
			System.out.println("Subject "+ (i+1) + "marks :" + subMarks[i]);
		}
		System.out.println("Total           : " + totalMarks);
		System.out.println("Percentage      : " + percentage);
		System.out.println("");
	}
}

