package com.streams.pojos;

public class Person {
    private String name;
    private int age;
    private Address address;
    private Gender gender;
    private long salary;
    private long uniqueId;

    public long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(long uniqueId) {
        this.uniqueId = uniqueId;
    }



    public enum Gender {
        MALE,
        FEMALE
    }


    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }


    public Person() {
    }

    public Person(long uniqueId, String name, int age, Gender gender, Address address, long salary) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.salary = salary;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
