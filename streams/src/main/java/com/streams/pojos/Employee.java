package com.streams.pojos;

import java.util.Collections;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private Designation designation;
    private long salary;
    private List<Employee> colleague;

    public Employee(int id,
            String name,
            Designation designation,
            long salary,
            List<Employee> colleague) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.colleague = colleague;
    }

    public enum Designation {
        MANAGER,
        DEVELOPER,
        TESTER,
        SCRUMMASTER,
        TEAMLEAD
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public List<Employee> getColleague() {
        if (colleague == null) return Collections.emptyList();
        return colleague;
    }

    public void setColleague(List<Employee> colleague) {
        this.colleague = colleague;
    }


}
