package People;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String birthOfDate;
    Person(String firstName, String middleName, String lastName, int age, String birthOfDate){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.birthOfDate = birthOfDate;

    }
    Person(){
        this.firstName = null;
        this.middleName = null;
        this.lastName = null;
        this.age = 0;
        this.birthOfDate = null;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(String birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
