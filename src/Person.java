import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {

    private final String name;
    private List<String> phoneNumbers;

    private String gender;

    private int age;

    public Person(String name, List<String> phoneNumbers) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

    public Person(String name) {
        this.name = name;
        this.phoneNumbers = new ArrayList<>();
    }

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.phoneNumbers = new ArrayList<>();
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
