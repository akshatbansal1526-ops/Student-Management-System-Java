import java.util.ArrayList;
import java.util.Scanner;
// student class store information abbout a student
class Student{ 
    // student attributes
    private int rollNo;
    private String name;
    private int age;
    private String course;

    // constructor to initialize student data
    public Student(int rollNo, String name, int age, String course){
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // returns student's roll no.
    public int getRollNo(){
        return rollNo;
    }

    // returns student's name
    public String getName(){
        return name;
    }

    // returns student's age
    public  int getAge(){
        return age;
    }

    // returns student's course 
    public String getCourse(){
        return course;
    }

    // updates student's name
    public void setName(String name){
        this.name = name;
    }

    // updates student's age
    public void setAge(int age){
        this.age  = age;
    }

    // updates student's course
    public void setCourse(String course){
        this.course = course;
    }

    // displays all students details
    public void displayStudent(){
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }
}

// manage all student records
class StudentManagement{

    // list to store multiple student objects
    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        // adds student to a list
        students.add(student);
        System.out.println("student added succesfully");
    }

    public void displayStudents(){
        for ( int i = 0; i<students.size(); i++){
            students.get(i).displayStudent();
            System.out.println();
        }
    }

    // searches student by roll no
    public void searchStudent(int rollNo){
        for ( int i = 0; i<students.size(); i++){
            if ( students.get(i).getRollNo() == rollNo){
                System.out.println("student found ");
                students.get(i).displayStudent();
                return;
            } 
        }
        System.out.println("student not found!");
    }

    // delte student by roll no. 
    public void deleteStudent(int rollNo){
        for (int i = 0; i<students.size(); i++){
            if ( students.get(i).getRollNo() == rollNo){
                students.remove(i);
                System.out.println("student deleted succesfully");
                return;
            }
        }
        System.out.println("student not found");
    }

    // updating the student details using roll number
    public void updateStudent(int rollNo , String newname, int newage, String newcourse){
        for ( int i = 0; i<students.size(); i++){
            if ( students.get(i).getRollNo() == rollNo){
                students.get(i).setName(newname);
                students.get(i).setAge(newage);
                students.get(i).setCourse(newcourse);
                System.out.println("student updated succesfully");
                return;
            }
        }
        System.out.println("student not found");
    }

}
public class StudentManagementSystem {

    public static void main(String args[]){ 
        
        // creating studentmanagement object
        StudentManagement sm = new StudentManagement();

        // taking input from user
        Scanner sc = new Scanner(System.in);
        while (true){
        System.out.println();
        System.out.println("===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add student");
        System.out.println("2. Display student");
        System.out.println("3. search student");
        System.out.println("4. update student");
        System.out.println("5. delete student");
        System.out.println("6. exit");

        System.out.println("Enter your choice: ");

        int choice = sc.nextInt();
    
        System.out.println(" your selected option: " + choice);

        switch(choice){
            case 1:
                System.out.println("Enter roll no: ");
                int rollNo = sc.nextInt();

                sc.nextLine();

                System.out.println("Enter name: ");
                String name = sc.nextLine();

                System.out.println("Enter age: ");
                int age = sc.nextInt();

                sc.nextLine();

                System.out.println("enter course: ");
                String course = sc.nextLine();

                Student s = new Student(rollNo, name, age, course);
                sm.addStudent(s);

            break;

            case 2:
                sm.displayStudents();
            break;

            case 3:
                System.out.println("Enter roll no. to search");
                int searchRollNo = sc.nextInt();
                sm.searchStudent(searchRollNo);
                
            break;

            case 4:
                System.out.println("Enter roll no. to update");
                int updateRollno = sc.nextInt();

                sc.nextLine();
                
                System.out.println("Enter new name: ");
                String newname = sc.nextLine();

                System.out.println("Enter new age: ");
                int newage = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter new course");
                String newcourse = sc.nextLine();

                sm.updateStudent(updateRollno, newname, newage, newcourse);

            break;

            case 5:
                System.out.println("Enter roll no. to delete");
                int deleteRollNo = sc.nextInt();
                sm.deleteStudent(deleteRollNo);
            break;

            case 6:
                System.out.println("Exiting program...");
                sc.close();
                return;

            default:
                System.out.println("Invalid choice");
        }

        }

    }
}
