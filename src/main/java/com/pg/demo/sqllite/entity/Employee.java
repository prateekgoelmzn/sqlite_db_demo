package com.pg.demo.sqllite.entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity(name = "Employee")
@Table(name = "tb_emp")
@DynamicUpdate
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int age;
    private String companyName;

    public Employee(String name, int age, String companyName) {
        this.name = name;
        this.age = age;
        this.companyName = companyName;
    }

    public Employee(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
