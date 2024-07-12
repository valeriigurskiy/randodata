package com.randodata;

import java.util.List;

import static com.randodata.utils.GeneralUtils.isListEmpty;

public interface ResultWrapper<K> {
    List<K> all();

    default K first() {
        List<K> values = all();
        isListEmpty(values);
        return values.getFirst();
    }

    default K last() {
        List<K> values = all();
        isListEmpty(values);
        return values.getLast();
    }

    default K random() {
        List<K> values = all();
        isListEmpty(values);
        return values.stream().findAny().get();
    }
}
