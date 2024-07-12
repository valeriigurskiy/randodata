package com.randodata.number.integer;

import com.randodata.ResultWrapper;
import com.randodata.Service;
import com.randodata.Storage;
import com.randodata.number.Range;

public final class Ints implements Service<Ints, Integer> {
    private int limit = 1;

    private boolean shuffle = false;

    private Range range = Range.of(0, Integer.MAX_VALUE);

    private IntsStorage storage = IntsStorage.create();

    private Ints() {

    }

    public static Ints create() {
        return new Ints();
    }

    @Override
    public Ints limit(int limit) {
        this.limit = limit;
        return this;
    }

    @Override
    public Ints customStorage(Storage storage) {
        this.storage = (IntsStorage) storage;
        return this;
    }

    public Ints range(int fromInclusive, int toExclusive) {
        this.range = Range.of(fromInclusive, toExclusive);
        return this;
    }

    public Ints shuffle() {
        this.shuffle = true;
        return this;
    }

    @Override
    public ResultWrapper<Integer> wrapper() {
        return () -> storage.generate(limit, range, shuffle);
    }

    @Override
    public ResultWrapper<String> string() {
        return () -> storage.generateAsString(limit, range, shuffle);
    }
}
