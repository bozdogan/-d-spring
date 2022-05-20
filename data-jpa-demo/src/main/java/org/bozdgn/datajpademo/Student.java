package org.bozdgn.datajpademo;

import javax.persistence.*;

@Entity(name = "Student")
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1)  // NOTE(bora): Default is 1
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence")
    @Column(name = "id", updatable = false)
    long id;
    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    String firstName;
    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    String lastName;
    @Column(name = "email", nullable = false)
    String email;
    @Column(name = "age", nullable = false)
    int age;

    public Student(long id, String firstName, String lastName, String email, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
