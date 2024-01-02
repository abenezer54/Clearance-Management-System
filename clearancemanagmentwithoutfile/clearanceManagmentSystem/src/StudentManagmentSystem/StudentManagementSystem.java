package StudentManagmentSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class StudentManagementSystem {
    private List<Student> students;
    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                students.remove(student);
                break;
            }
        }
    }

    public List<Student> getAllStudents() {
        return students;
    }
    public class Student {
        private static int idCounter = 1;
        private String id;
        private String year;
        private String name;
        private boolean library = true;
        private boolean departmentHead = true;
        private boolean studentsAffair= true;
        private boolean sportsAndClubs = true;
        private boolean collegeAdmin= true;
        private boolean dining= true;
        private boolean dormitory = true;

        private Map<Integer, Boolean> officeClearance;

        public Student(String year, String name) {
            this.id = Integer.toString(idCounter++);
            this.year = year;
            this.name = name;
            this.officeClearance = new HashMap<>();
        }

        // Getters and setters for the attributes

        public String getId() {
            return id;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public void setYear(String name) {
            this.name = name;
        }

        public String getYear() {
            return name;
        }

        public boolean isLibrary() {
            return library;
        }

        public void setLibrary(boolean library) {
            this.library = library;
        }
        public boolean isDepartmentHead() {
            return departmentHead;
        }

        public void setDepartmentHead(boolean departmentHead) {
            this.departmentHead = departmentHead;
        }

        public boolean isStudentsAffair() {
            return studentsAffair;
        }

        public void setStudentsAffair(boolean studentsAffair) {
            this.studentsAffair = studentsAffair;
        }

        public boolean isSportsAndClubs() {
            return sportsAndClubs;
        }

        public void setSportsAndClubs(boolean sportsAndClubs) {
            this.sportsAndClubs = sportsAndClubs;
        }

        public boolean isCollegeAdmin() {
            return collegeAdmin;
        }

        public void setCollegeAdmin(boolean collegeAdmin) {
            this.collegeAdmin = collegeAdmin;
        }

        public boolean isDining() {
            return dining;
        }

        public void setDining(boolean dining) {
            this.dining = dining;
        }

        public boolean isDormitory() {
            return dormitory;
        }

        public void setDormitory(boolean dormitory) {
            this.dormitory = dormitory;
        }

        // Office clearance methods

        public void setClearance(int officeNumber, boolean clearance) {
            officeClearance.put(officeNumber, clearance);
        }

        public boolean hasClearance(int officeNumber) {
            return officeClearance.getOrDefault(officeNumber, false);
        }

        // Other methods for student management

        public void menu() {
            // Implement the menu functionality for the student
        }

        public boolean isEligible() {
            // Implement the logic for checking the eligibility of the student
            return false; // Placeholder value
        }

        public void mapIt() {
            // Implement the mapping functionality
        }
    }
}



