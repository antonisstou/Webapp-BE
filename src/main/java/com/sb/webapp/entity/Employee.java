package com.sb.webapp.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Fetch;

import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "afm")
    private String afm;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "birthday")
    private Date birthDay;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;

    public Employee(){

    }

    public Employee(Long id, String afm, String firstName, String lastName, Date birthDay, Department department){
        this.id = id;
        this.afm = afm;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.department = department;
    }

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }

    public void setAfm(String afm){
        this.afm = afm;
    }
    public String getAfm(){
        return afm;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setBirthday(Date birthDay){
        this.birthDay = birthDay;
    }
    public Date getBirthday(){
        return birthDay;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }
}
