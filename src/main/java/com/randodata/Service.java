package com.randodata;

public interface Service<T, K> {
    default ResultWrapper<K> wrapper() {
        throw new UnsupportedOperationException("Wrapper method not yet implemented");
    }

    default ResultWrapper<String> string() {
        throw new UnsupportedOperationException("String method not yet implemented");
    }

    T limit(int limit);

    T customStorage(Storage storage);
}
