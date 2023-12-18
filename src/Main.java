import MysqlDB.DataRetriever;

public class Main{
    public static void main(String[] args) {
        String query = "SELECT * FROM student;";
        DataRetriever.retrieveData(query);
    }
}