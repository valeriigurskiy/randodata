package com.randodata.number.doubles;

import com.randodata.Storage;
import com.randodata.number.Range;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public final class DoublesStorage implements Storage {

    private final Random random = new Random();

    private final List<Double> doubles = new ArrayList<>();

    private DoublesStorage() {

    }

    @Override
    public void init() {

    }

    public static DoublesStorage create() {
        return new DoublesStorage();
    }

    public List<Double> generate(int limit, Range range, boolean shuffle) {
        int from = range.fromAsInt();
        int to = range.toAsInt();
        Random random = new Random();

        List<Double> doubles = random.doubles(limit, from, to)
                .boxed()
                .collect(Collectors.toList());

        if (!shuffle) {
            Collections.sort(doubles);
        }

        return doubles;
    }

    public List<String> generateAsString(int limit, Range range, boolean shuffle) {
        List<Double> doubles = generate(limit, range, shuffle);

        return doubles.stream()
                .map(String::valueOf)
                .toList();
    }

    public void add(double number) {
        this.doubles.add(number);
    }

    public void add(double... numbers) {
        for (double number : numbers) {
            add(number);
        }
    }
}
