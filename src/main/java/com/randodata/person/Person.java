package com.randodata.person;

public class Person {

    private String name;

    private String surname;

    private String secondName;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, String secondName) {
        this.name = name;
        this.surname = surname;
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);

        if (surname != null) {
            stringBuilder.append(" ");
            stringBuilder.append(surname);
        }

        if (secondName != null) {
            stringBuilder.append(" ");
            stringBuilder.append(secondName);
        }

        return stringBuilder.toString();
    }
}
