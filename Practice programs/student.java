import java.io.*;

class test {
	static int id = 1;
	static Student mca[] = new Student[5];

	public static void main(String[] args) throws IOException {
		int choice, totalstudents = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println("\tMain Menu");
			System.out.println("1. Enter new Student\n2. Display all Students\n3. Exit");
			System.out.println("Enter your choice:");
			choice = Integer.parseInt(br.readLine());

			switch (choice) {
				case 1:
					System.out.println("Enter the details of Student " + id + ":");
					mca[id] = new Student();
					totalstudents = id;
					id++;
					break;
				case 2:
					for (int i = 1; i <= totalstudents; i++) {
						System.out.println("-----------------------------");
						System.out.println("Details of Student " + i + ":");
						mca[i].display();
					}
					break;
				default:
					System.out.println("\nProgram will exit");
					break;
			}
		} while (choice < 3);
	}
}

class Student {
	int regno;
	String name;
	String mailid;
	int age;
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

		System.out.println("Enter age:");
		int years = Integer.parseInt(br.readLine());
		this.age = years > 100 || years < 15 ? 20 : years;

		this.totalMarks = 0;
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter Subject " + (i + 1) + " marks : ");
			subMarks[i] = Integer.parseInt(br.readLine());
			this.totalMarks += subMarks[i];
		}
		this.percentage = this.totalMarks * 100 / 500;
	}
	void display() {
		System.out.println("Reg No          : " + regno);
		System.out.println("Name            : " + name);
		System.out.println("Email           : " + mailid);
		System.out.println("Age             : " + age);
		for (int i = 0; i < 5; i++) {
			System.out.println("Subject "+ (i + 1) + " marks : " + subMarks[i]);
		}
		System.out.println("Total           : " + totalMarks);
		System.out.println("Percentage      : " + percentage);
		System.out.println("");
	}
}

