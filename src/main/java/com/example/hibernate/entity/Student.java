package com.example.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
    public Student() {
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

    public Student( String firstName, String lastName, String groupName) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.groupName = groupName;
    }
@Column(name="email")
    private String groupName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", group='" + groupName + '\'' +
                '}';
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

    public String getGroup() {
        return groupName;
    }

    public void setGroup(String group) {
        this.groupName = group;
    }
}
