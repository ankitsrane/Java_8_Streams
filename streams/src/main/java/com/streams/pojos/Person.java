package com.streams.pojos;

public class Person {
    private String name;
    private int age;
    private Address address;
    private Gender gender;

    public enum Gender {
        MALE,
        FEMALE
    }

    public Person() {
    }

    public Person(String name, int age, Gender gender, Address address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
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
