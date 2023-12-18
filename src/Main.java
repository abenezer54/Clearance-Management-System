import MysqlDB.DataRetriever;
import Offices.Registrar;
import People.Student;

public class Main{
    public static void main(String[] args) {
//      These objects are instantiated for testing purposes
        String query = "SELECT * FROM student;";
        DataRetriever.retrieveData(query);
        Registrar registrar = new Registrar();
        Student student = new Student("Solomon", "Abate", "Sitotaw", 20, "10/29/2002","ets0123");
        registrar.addStudent(student);
    }
}