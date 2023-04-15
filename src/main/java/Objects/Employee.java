package Objects;

public class Employee {
    private int id;
    private String first_name;
    private String last_name;
    private String gender;
    private Integer age;

    public Employee(int id, String first_name, String last_name, String gender, Integer age) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Employee #" + id + ": " + first_name + " " + last_name + " " + gender + " " + age;
    }
}

