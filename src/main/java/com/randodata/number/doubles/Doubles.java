package com.randodata.number.doubles;

import com.randodata.ResultWrapper;
import com.randodata.Service;
import com.randodata.Storage;
import com.randodata.number.Range;

public final class Doubles implements Service<Doubles, Double> {
    private int limit = 1;

    private boolean shuffle = false;

    private Range range = Range.of(0, Double.MAX_VALUE);

    private DoublesStorage storage = DoublesStorage.create();

    private Doubles() {

    }

    public static Doubles create() {
        return new Doubles();
    }

    @Override
    public Doubles limit(int limit) {
        this.limit = limit;
        return this;
    }

    @Override
    public Doubles customStorage(Storage storage) {
        this.storage = (DoublesStorage) storage;
        return this;
    }

    public Doubles range(int fromInclusive, int toExclusive) {
        this.range = Range.of(fromInclusive, toExclusive);
        return this;
    }

    public Doubles shuffle() {
        this.shuffle = true;
        return this;
    }

    @Override
    public ResultWrapper<Double> wrapper() {
        return () -> storage.generate(limit, range, shuffle);
    }

    @Override
    public ResultWrapper<String> string() {
        return () -> storage.generateAsString(limit, range, shuffle);
    }
}
