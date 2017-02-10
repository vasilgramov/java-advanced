package ProcessingStudentData;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String facultyNumber;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private int group;
    private List<Integer> grades;
    private String phone;

    public Student(String facultyNumber,
                   String firstName,
                   String lastName,
                   String email,
                   int age,
                   int group,
                   List<Integer> grades,
                   String phone) {
        this.setFacultyNumber(facultyNumber);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
        this.setAge(age);
        this.setGroup(group);
        this.setGrades(grades);
        this.setPhone(phone);
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public int getGroup() {
        return group;
    }

    private void setGroup(int group) {
        this.group = group;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    private void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public String getPhone() {
        return phone;
    }

    private void setPhone(String phone) {
        this.phone = phone;
    }
}
