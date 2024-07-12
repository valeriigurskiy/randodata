package com.randodata.person;

import com.randodata.ResultWrapper;
import com.randodata.Service;
import com.randodata.Storage;

import static com.randodata.utils.GeneralUtils.*;

public final class Persons implements Service<Persons, Person> {

    private int limit = 1;

    private PersonsStorage storage = PersonsStorage.create().includeDefaults();

    private Persons() {

    }

    public static Persons create() {
        return new Persons();
    }

    @Override
    public Persons customStorage(Storage storage) {
        nullCheck(storage);
        this.storage = (PersonsStorage) storage;
        return this;
    }

    @Override
    public Persons limit(int limit) {
        isLimitValid(limit);
        this.limit = limit;
        return this;
    }

    @Override
    public ResultWrapper<Person> wrapper() {
        return () -> storage.generatePersons(limit);
    }

    @Override
    public ResultWrapper<String> string() {
        return () -> storage.generatePersonsAsString(limit);
    }
}