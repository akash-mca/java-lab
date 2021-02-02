/* Task to complete: Feb 1, 12-1pm. An incomplete/not properly formatted code snippet for demo of array of objects is given below.
This code accepts name and age of three students and display the same details.
Try to modify the program adding on more details of students and neatly format the output
Can try with different methods for initialisation, reading the input, writing the output etc
 Try to understand the difference between normal array and array of objects in Java*/


import java.io.*;

class DemoAoO {
	public static void main(String[] args) throws IOException {
		int age = 1;
		String name = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Student obj[] = new Student[3];
		for(int i = 0; i < 3; i++) {
			System.out.println("Enter the name of Student " + (i + 1));
			name = br.readLine();
			System.out.println("Enter the age of Student  " + (i + 1));
			age = Integer.parseInt(br.readLine());
			obj[i] = new Student(name, age);
			System.out.println("");
		}
		System.out.println("*******Student Details***************");
		for(int i = 0; i < 3; i++) obj[i].showOutput();
		System.out.println("*************************************\n");
	}
}

class Student {
	static int id = 1;
	int age;
	String name;
	Student (String nam, int old) {
		id = id++;
		name = nam;
		age = old;
	}
	public void showOutput() {
		System.out.println("ID:"+ id + "  " + "Name:"+ name +"  "+ "Age:"+ age);
	}
}

