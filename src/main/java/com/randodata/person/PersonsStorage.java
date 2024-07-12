package com.randodata.person;

import com.randodata.Storage;
import com.randodata.utils.GeneralUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.randodata.utils.GeneralUtils.generateInRange;
import static com.randodata.utils.GeneralUtils.nullCheck;

public final class PersonsStorage implements Storage {

    private final List<String> names = new ArrayList<>();

    private final List<String> lastnames = new ArrayList<>();

    private final List<String> secondNames = new ArrayList<>();

    private PersonsStorage() {

    }

    public static PersonsStorage create() {
        return new PersonsStorage();
    }

    @Override
    public void init() {
        names.add("James");
        lastnames.add("Jamennson");
        secondNames.add("IIvd");
    }

    public PersonsStorage includeDefaults() {
        init();
        return this;
    }

    public PersonsStorage addNames(List<String> names) {
        addNames(names.toArray(String[]::new));

        return this;
    }

    public PersonsStorage addNames(String... names) {
        nullCheck(names);

        for (String name : names) {
            nullCheck(name);
        }

        this.names.addAll(List.of(names));

        return this;
    }

    public PersonsStorage addLastnames(List<String> lastnames) {
        addLastnames(lastnames.toArray(String[]::new));

        return this;
    }

    public PersonsStorage addLastnames(String... lastnames) {
        nullCheck(lastnames);

        for (String name : lastnames) {
            nullCheck(name);
        }

        this.lastnames.addAll(List.of(lastnames));

        return this;
    }

    public PersonsStorage addSecondNames(List<String> secondNames) {
        addSecondNames(secondNames.toArray(String[]::new));

        return this;
    }

    public PersonsStorage addSecondNames(String... secondNames) {
        nullCheck(secondNames);

        for (String secondName : secondNames) {
            nullCheck(secondName);
        }

        this.secondNames.addAll(List.of(secondNames));

        return this;
    }

    List<Person> generatePersons(int limit) {
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < limit; i++) {
            Person person = new Person(generateName(), generateLastname(), generateSecondName());
            persons.add(person);
        }

        return persons;
    }
    
    List<String> generatePersonsAsString(int limit) {
        List<Person> persons = generatePersons(limit);
        
        return persons.stream()
            .map(String::valueOf)
            .collect(Collectors.toList());
    }

    private String generateName() {
        int randomIndex = generateInRange(names.size());
        return names.get(randomIndex);
    }

    private String generateLastname() {
        int randomIndex = generateInRange(lastnames.size());
        return lastnames.get(randomIndex);
    }

    private String generateSecondName() {
        int randomIndex = generateInRange(secondNames.size());
        return secondNames.get(randomIndex);
    }
}