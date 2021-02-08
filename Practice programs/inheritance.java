/* The program is a menu driven program which implements inheritance concept, use extends, this
and super, It also use String class method. Gives three choices; to enter details, display based on one
criteria and exit. Execute this and trey to understand the concept of inheritance; later implement it in
your domain*/
import java.util.*;
class Person{
String name;
int age,height;
void read(){
//scanner object
Scanner sc= new Scanner(System.in);
System.out.print("Enter Name : ");
this.name= sc.nextLine();
System.out.print("Enter Age : ");
this.age= sc.nextInt();
System.out.print("Enter height(in cms) :");
this.height= sc.nextInt();
}
void display(){
System.out.println("Name - \t\t"+this.name);
System.out.println("Age - \t\t"+this.age);
System.out.println("Height - \t"+this.height+" cms");
}
public static void clearScreen() {
System.out.print( "\033[H\033[2J" ); //H\033[\033[2J // need not use this method; just tried for clear screen
System.out.flush();
}

public static void main(String[] args){
int flag = 0;
GraduateStudent[] stud = new GraduateStudent[10];
Scanner sc = new Scanner(System.in);
System.out.print("No of students to be entered : ");
int num = sc.nextInt();
clearScreen();
System.out.println("Entering Records for "+num+" students.");
for (int i = 0; i < num; i++){
System.out.println("\n\t\tSTUDENT "+(i+1));
stud[i] = new GraduateStudent();
stud[i].read();
}
do{
clearScreen();
System.out.println("-----------STUDENT RECORDS-----------");
System.out.println("1.\t Display Records");
System.out.println("2.\t View Students taller than 150cm in MCA");
System.out.println("3.\t Exit");
System.out.print("\t Choice : ");
int choice = sc.nextInt();

switch(choice)
{
case 1:
clearScreen();
for (int i = 0; i < num; i++){
System.out.println("\n\t\tSTUDENT "+(i+1));
stud[i].display();
}
System.out.print("\nEnter to continue...........");
sc.nextLine(); // serves as getch()
String str = sc.nextLine();
break;
case 2:
clearScreen();
int flag1 = 0;
System.out.println("Students taller than 150cm in MCA : ");
for (int i = 0; i < num; i++){
if (stud[i].height > 150 && (stud[i].programName.equals("MCA") ||

stud[i].programName.equals("mca")) ){

flag1 = 1;
System.out.println(stud[i].name);
}
}
if (flag1 == 0){
System.out.println("<none>");
}
System.out.print("\nEnter to continue...........");
sc.nextLine(); // serves as getch()
str = sc.nextLine();
break;
case 3:
flag = 1;
System.out.println("Thank You!");
break;
default:
System.out.println("Incorrect Choice!");
System.out.print("Enter to try again...........");
sc.nextLine(); // serves as getch()
str = sc.nextLine();
}
}while(flag != 1);
}
}
class Student extends Person{
int studentId;
String institutionName,phoneNumber;
void read(){

super.read();
Random rand = new Random();
this.studentId = 204700 + rand.nextInt(100);
Scanner sc= new Scanner(System.in);
System.out.print("Enter Institute Name : ");
this.institutionName= sc.nextLine();
System.out.print("Enter Phone Number :");
this.phoneNumber= sc.nextLine();
}
void display(){
super.display();
System.out.println("Student ID - \t"+this.studentId);
System.out.println("Institute - \t"+this.institutionName);
System.out.println("Phone Number - \t"+this.phoneNumber);
}
}
class GraduateStudent extends Student{
String programName,classTeacherName;
int noOfSubjects;
void read(){
super.read();
Scanner sc= new Scanner(System.in);
System.out.print("Enter Program Name : ");
this.programName= sc.nextLine();
System.out.print("Enter Class Teacher Name :");
this.classTeacherName= sc.nextLine();
System.out.print("Enter Number of Subjects : ");
this.noOfSubjects = sc.nextInt();
}
void display(){
super.display();
System.out.println("Program - \t"+this.programName);
System.out.println("Class Teacher - "+this.classTeacherName);
System.out.println("No. of Subjects - "+this.noOfSubjects);
}
}