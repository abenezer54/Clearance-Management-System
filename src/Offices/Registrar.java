package Offices;

import MysqlDB.DataUpdater;
import People.Student;

public class Registrar extends Office{
    public void addStudent(Student student){
        String query = "INSERT INTO student\n" +
                "VALUES (" +" '" + student.getStudentId() + "' ," +" '" + student.getFirstName() + "', '" + student.getMiddleName() + "', '" + student.getLastName() + "' );";
        DataUpdater.updateData(query);
    }

}
