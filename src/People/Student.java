package People;

public class Student extends Person{
    private final String studentId;
    Student(String firstName,String middleName, String lastName, int age, String birthOfDate, String studentId){
        super(firstName, middleName, lastName, age, birthOfDate);
        this.studentId = studentId;
    }
    public static void main(String[] args) {
        Student st = new Student("Abenezer", "Mulugeta", "Asres", 20, "10/29/2002","ets0056");
        System.out.println(st.getFirstName());
        System.out.println(st.studentId);
    }
}
