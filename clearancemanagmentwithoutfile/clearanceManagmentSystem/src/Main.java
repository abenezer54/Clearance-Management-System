import StudentManagmentSystem.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import EmailConfiguration.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

        StudentManagementSystem.Student student1 = studentManagementSystem.new Student("2024", "Abigail");
        studentManagementSystem.addStudent(student1);

        StudentManagementSystem.Student student2 = studentManagementSystem.new Student("2023", "Goldilocks");
        studentManagementSystem.addStudent(student2);

        StudentManagementSystem.Student student3 = studentManagementSystem.new Student("2021", "Abem");
        studentManagementSystem.addStudent(student3);

// Rest of the code...
        while (!exit) {
            System.out.println(" ___________________________________");
            System.out.println("|                                   |");
            System.out.println("|     Clearance Management System   |");
            System.out.println("|___________________________________|");
            System.out.println("|                                   |");
            System.out.println("| Sign in as:                       |");
            System.out.println("| 1. A Student                      |");
            System.out.println("| 2. A Librarian                    |");
            System.out.println("| 3. A Registrar                    |");
            System.out.println("| 4. A department head              |");
            System.out.println("| 5. A students affair staff        |");
            System.out.println("| 6. A sports and clubs staff       |");
            System.out.println("| 7. A college admin                |");
            System.out.println("| 8. A dining office staff          |");
            System.out.println("| 9. A dormitory proctor            |");
            System.out.println("| 10.To exit program               |");
            System.out.println("|___________________________________|");
            System.out.print("Enter your choice: ");
//            if (scanner.hasNextLine()) {
//            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();


            if (!inputCheck(choice) || Integer.parseInt(choice) > 10) {
                System.out.println("Your choice is not valid! Please choose again.");
                continue;
            }

            switch (Integer.parseInt(choice)) {
                case 1:
                    initiateStudent(scanner, studentManagementSystem);
                    break;
                case 2:
                    initiateLibrarian(scanner, studentManagementSystem);
                    break;
                case 3:
                    initiateRegistrar(scanner, studentManagementSystem);
                    break;
                case 4:
                    initiateDepartmentHead(scanner, studentManagementSystem);
                    break;
                case 5:
                    initiateStudentsAffair(scanner, studentManagementSystem);
                    break;
                case 6:
                    initiateSportsAndClubs(scanner, studentManagementSystem);
                    break;
                case 7:
                    initiateCollegeAdmin(scanner, studentManagementSystem);
                    break;
                case 8:
                    initiateDining(scanner, studentManagementSystem);
                    break;
                case 9:
                    initiateDormitory(scanner, studentManagementSystem);
                    break;
                case 10:
                    exit = true;
                    System.out.println("You have chosen to exit the program!");
                    break;
                default:
                    System.out.println("Your choice is invalid!");
                    break;
            }
        }
//        }

        System.out.println("Exiting the program...");
        scanner.close();
    }

    private static boolean inputCheck(String choice) {
        try {
            int num = Integer.parseInt(choice);
            return num >= 1 && num <= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void initiateStudent(Scanner scanner, StudentManagementSystem studentManagementSystem) {
        System.out.println("Initiating student functionality...");

        boolean requestingClearance = true;
        String name;
        while (requestingClearance) {
            System.out.println("\n----- Student Menu -----");
            System.out.println("1. Request Clearance");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case "1":
                    System.out.println("Enter your name or id ");
                    name = scanner.nextLine();
                    requestClearance(name, studentManagementSystem);
                    break;
                case "2":
                    requestingClearance = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }


    }

    public static void requestClearance(String name, StudentManagementSystem studentManagementSystem) {
        List<StudentManagementSystem.Student> studentList = studentManagementSystem.getAllStudents();
        List<String> notClearedOffices = new ArrayList<>();

        for (StudentManagementSystem.Student student : studentList) {
            if (student.getName().equals(name) || student.getId().equals(name)) {

                if (!student.isLibrary()) {
                    notClearedOffices.add("Library");
                }
                if (!student.isDepartmentHead()) {
                    notClearedOffices.add("Department Head");
                }
                if (!student.isStudentsAffair()) {
                    notClearedOffices.add("Students Affairs");
                }
                if (!student.isSportsAndClubs()) {
                    notClearedOffices.add("Sports and Clubs");
                }
                if (!student.isCollegeAdmin()) {
                    notClearedOffices.add("College Administration");
                }
                if (!student.isDining()) {
                    notClearedOffices.add("Dining");
                }
                if (!student.isDormitory()) {
                    notClearedOffices.add("Dormitory");
                }
            }
        }

        if (notClearedOffices.isEmpty()) {
            System.out.println("Congratulations! You have clearance for all offices.");
        } else {
            System.out.println("Clearance Status:");
            System.out.println("List of offices where you are not Cleared");
            for (String office : notClearedOffices) {
                System.out.println(office);
            }
        }
    }

    private static <Student> Student findStudentById(String studentId, StudentManagementSystem studentManagementSystem) {
//        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();
        List<StudentManagementSystem.Student> studentList = studentManagementSystem.getAllStudents();
        for (StudentManagementSystem.Student student : studentList) {
            if (student.getId() == studentId) {
                return (Student) student;
            }
        }
        return null;
    }

    private static void initiateLibrarian(Scanner scanner, StudentManagementSystem studentManagementSystem) {
        System.out.println("Initiating librarian functionality...");

        List<StudentManagementSystem.Student> studentList = studentManagementSystem.getAllStudents();
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.print("Enter the name or ID of the student: ");
            String input = scanner.nextLine();
            for (StudentManagementSystem.Student student : studentList) {
                if (student.getId().equals(input) || student.getName().equals(input)) {
                    System.out.print("Set library status for " + student.getName() + " (true/false): ");
                    boolean libraryStatus = scanner.nextBoolean();
                    scanner.nextLine();
                    student.setLibrary(libraryStatus);
                    return;
                }
            }
            System.out.println("Student not found.");
        }
    }

    private static void initiateRegistrar(Scanner scanner, StudentManagementSystem studentManagementSystem) {

        System.out.println("Initiating registrar functionality...");
//        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("----- Registrar Menu -----");
            System.out.println("1. View all students");
            System.out.println("2. Add a student");
            System.out.println("3. Delete a student");
            System.out.println("4. Edit a student's details");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            String choice2 = scanner.nextLine();

            switch (choice2) {
                case "1":
                    viewAllStudents(studentManagementSystem);
                    break;
                case "2":
                    addStudent(scanner, studentManagementSystem);
                    break;
                case "3":
                    deleteStudent(scanner, studentManagementSystem);
                    break;
                case "4":
                    editStudentDetails(scanner, studentManagementSystem);
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    private static void viewAllStudents(StudentManagementSystem studentManagementSystem) {
        List<StudentManagementSystem.Student> studentList = studentManagementSystem.getAllStudents();
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("----- All Students -----");
            for (StudentManagementSystem.Student student : studentList) {
                System.out.println("ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Clearance Status:");
                System.out.println("Library: " + (student.isLibrary() ? "Cleared" : "Not Cleared"));
                System.out.println("Department Head: " + (student.isDepartmentHead() ? "Cleared" : "Not Cleared"));
                System.out.println("Students Affairs: " + (student.isStudentsAffair() ? "Cleared" : "Not Cleared"));
                System.out.println("Sports and Clubs: " + (student.isSportsAndClubs() ? "Cleared" : "Not Cleared"));
                System.out.println("College Admin: " + (student.isCollegeAdmin() ? "Cleared" : "Not Cleared"));
                System.out.println("Dining: " + (student.isDining() ? "Cleared" : "Not Cleared"));
                System.out.println("Dormitory: " + (student.isDormitory() ? "Cleared" : "Not Cleared"));
                System.out.println("-----");
            }
        }
    }

    private static void addStudent(Scanner scanner, StudentManagementSystem studentManagementSystem) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student year: ");
        String year = scanner.nextLine();

        StudentManagementSystem.Student newStudent = new StudentManagementSystem().new Student(year, name);
        studentManagementSystem.addStudent(newStudent);

        System.out.println("Student added successfully.");
    }

    private static void deleteStudent(Scanner scanner, StudentManagementSystem studentManagementSystem) {
//        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();
        System.out.print("Enter student ID to delete: ");
        String studentId = scanner.nextLine();
        scanner.nextLine();

        studentManagementSystem.removeStudent(studentId);

        System.out.println("Student deleted successfully.");
        scanner.close();
    }

    private static void editStudentDetails(Scanner scanner, StudentManagementSystem studentManagementSystem) {

        System.out.print("Enter student ID to edit details: ");
        String studentId = scanner.nextLine();
        scanner.nextLine();

        StudentManagementSystem.Student student = findStudentById(studentId, studentManagementSystem);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("----- Edit Student Details -----");
        System.out.println("1. Edit student name");
        System.out.println("2. Edit student year");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter new student name: ");
                String newName = scanner.nextLine();
                student.setName(newName);
                System.out.println("Student name updated successfully.");
                break;
            case 2:
                System.out.print("Enter new student year: ");
                String newyear = scanner.nextLine();
//               student.setyear(newyear);
                System.out.println("Student year updated successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        scanner.close();
    }


    private static void initiateDepartmentHead(Scanner scanner, StudentManagementSystem studentManagementSystem) {
        System.out.println("Initiating department head functionality...");

        List<StudentManagementSystem.Student> studentList = studentManagementSystem.getAllStudents();
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.print("Enter the name or ID of the student: ");
            String input = scanner.nextLine();
            for (StudentManagementSystem.Student student : studentList) {
                if (student.getId().equals(input) || student.getName().equals(input)) {
                    System.out.print("Set department head status for " + student.getName() + " (true/false): ");
                    boolean departmentHeadStatus = scanner.nextBoolean();
                    scanner.nextLine();
                    student.setDepartmentHead(departmentHeadStatus);
                    return;
                }
            }
            System.out.println("Student not found.");
        }
    }

// Implement similar methods for other offices

    private static void initiateStudentsAffair(Scanner scanner, StudentManagementSystem studentManagementSystem) {
        System.out.println("Initiating students affair staff functionality...");

        List<StudentManagementSystem.Student> studentList = studentManagementSystem.getAllStudents();
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.print("Enter the name or ID of the student: ");
            String input = scanner.nextLine();
            for (StudentManagementSystem.Student student : studentList) {
                if (student.getId().equals(input) || student.getName().equals(input)) {
                    System.out.print("Set students affair staff status for " + student.getName() + " (true/false): ");
                    boolean studentsAffairStatus = scanner.nextBoolean();
                    scanner.nextLine();
                    student.setStudentsAffair(studentsAffairStatus);
                    return;
                }
            }
            System.out.println("Student not found.");
        }
    }

// Implement similar methods for other offices

    private static void initiateSportsAndClubs(Scanner scanner, StudentManagementSystem studentManagementSystem) {
        System.out.println("Initiating sports and clubs staff functionality...");

        List<StudentManagementSystem.Student> studentList = studentManagementSystem.getAllStudents();
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.print("Enter the name or ID of the student: ");
            String input = scanner.nextLine();
            for (StudentManagementSystem.Student student : studentList) {
                if (student.getId().equals(input) || student.getName().equals(input)) {
                    System.out.print("Set sports and clubs staff status for " + student.getName() + " (true/false): ");
                    boolean sportsAndClubsStatus = scanner.nextBoolean();
                    scanner.nextLine();
                    student.setSportsAndClubs(sportsAndClubsStatus);
                    return;
                }
            }
            System.out.println("Student not found.");
        }
    }

// Implement similar methods for other offices

    private static void initiateCollegeAdmin(Scanner scanner, StudentManagementSystem studentManagementSystem) {
        System.out.println("Initiating college admin functionality...");

        List<StudentManagementSystem.Student> studentList = studentManagementSystem.getAllStudents();
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.print("Enter the name or ID of the student: ");
            String input = scanner.nextLine();
            for (StudentManagementSystem.Student student : studentList) {
                if (student.getId().equals(input) || student.getName().equals(input)) {
                    System.out.print("Set college admin status for " + student.getName() + " (true/false): ");
                    boolean collegeAdminStatus = scanner.nextBoolean();
                    scanner.nextLine();
                    student.setCollegeAdmin(collegeAdminStatus);
                    return;
                }
            }
            System.out.println("Student not found.");
        }
    }

// Implement similar methods for other offices

    private static void initiateDining(Scanner scanner, StudentManagementSystem studentManagementSystem) {
        System.out.println("Initiating dining office staff functionality...");

        List<StudentManagementSystem.Student> studentList = studentManagementSystem.getAllStudents();
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.print("Enter the name or ID of the student: ");
            String input = scanner.nextLine();
            for (StudentManagementSystem.Student student : studentList) {
                if (student.getId().equals(input) || student.getName().equals(input)) {
                    System.out.print("Set dining office staff status for " + student.getName() + " (true/false): ");
                    boolean diningStatus = scanner.nextBoolean();
                    scanner.nextLine();
                    student.setDining(diningStatus);
                    return;
                }
            }
            System.out.println("Student not found.");
        }
    }

    private static void initiateDormitory(Scanner scanner, StudentManagementSystem studentManagementSystem) {
        System.out.println("Initiating dormitory proctor functionality...");

        List<StudentManagementSystem.Student> studentList = studentManagementSystem.getAllStudents();
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.print("Enter the name or ID of the student: ");
            String input = scanner.nextLine();
            for (StudentManagementSystem.Student student : studentList) {
                if (student.getId().equals(input) || student.getName().equals(input)) {
                    System.out.print("Set dormitory proctor status for " + student.getName() + " (true/false): ");
                    boolean dormitoryProctorStatus = scanner.nextBoolean();
                    scanner.nextLine();
                    student.setDormitory(dormitoryProctorStatus);
                    return;
                }
            }
            System.out.println("Student not found.");
        }
    }
}

