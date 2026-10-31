import java.util.ArrayList;
import java.util.Scanner;

class Student{
    String name;
    String school;
    int studentId;
    int age;
    int RollNo;

    Student(String name, String school, int age, int RollNo, int studentId){
        this.name = name;
        this.school = school;
        this.studentId = studentId;
        this.age = age;
        this.RollNo = RollNo;
    }

}

class StudentManagement {

    StudentManagement(){
        students.add(new Student("Hari","VVA",12,23,104));
        students.add(new Student("Gopal","Bahundangi",49,2,105));

    }

    Scanner sc = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();
    boolean running = true;

    public void menu(){

        while (running=true){

        System.out.println("1.View Students");
        System.out.println("2.Add Students");
        System.out.println("3.Search Student");
        System.out.println("4.Delette Student");
        System.out.println("5.Exit");


        int userInput = sc.nextInt();

        switch (userInput){
            case 1:
                viewStudents();
                break;

            case 2:
                addStudent();
                break;
            case 3:
                searchStudent();
                break;
            case 4:
                deleteStudent();
                break;
            case 5:
                running = false;
                System.out.println("Thankyou for using the service");

        }

    }
    }


    public void viewStudents(){
        for (Student s : students){
            System.out.println("Name: " + s.name + ", " + "School: " + s.school + ","+ "Age: " + s.age + "," + "Roll No: " + s.RollNo + "," + "Student Id: " + s.studentId);


        }

    }

    public void deleteStudent(){

        System.out.println("Enter the id to delete");
        int deleteId = sc.nextInt();
        for(Student s : students){
            if (deleteId == s.studentId){
                System.out.println("Successfully Removed: " + s);
                students.remove(s);

        }
    }

    }
    public void searchStudent(){


        System.out.println("Enter the id to search");
        int searchId = sc.nextInt();
        for (Student s : students){
            if (searchId == s.studentId){
                System.out.println(s);
            }
        }

    }


    public void addStudent(){
        sc.nextLine();
        System.out.println("Enter the student name: ");
        String addName = sc.nextLine();
        System.out.println("Enter Your School name");
        String addSchool = sc.nextLine();
        System.out.println("Enter your age");
        int addAge = sc.nextInt();
        System.out.println("Enter your ROllNO");
        int addRollNo = sc.nextInt();
        System.out.println("Enter Your Student Id");
        int AddStudentId = sc.nextInt();

        students.add(new Student(addName,addSchool,addAge,addRollNo,AddStudentId));


    }
}


public class Main{
        static void main(String[] args) {

            StudentManagement sm = new StudentManagement();
            sm.menu();
        }
}