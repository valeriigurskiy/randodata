package com.randodata.number.integer;

import com.randodata.Storage;
import com.randodata.number.Range;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class IntsStorage implements Storage {

    private List<Integer> ints = new ArrayList<>();

    private IntsStorage() {

    }

    @Override
    public void init() {

    }

    public static IntsStorage create() {
        return new IntsStorage();
    }

    public List<Integer> generate(int limit, Range range, boolean shuffle) {
        int from = range.fromAsInt();
        int to = range.toAsInt();
        Random random = new Random();

        List<Integer> ints = random.ints(limit, from, to)
                .boxed()
                .collect(Collectors.toList());

        if (!shuffle) {
            Collections.sort(ints);
        }

        return ints;
    }

    public List<String> generateAsString(int limit, Range range, boolean shuffle) {
        List<Integer> ints = generate(limit, range, shuffle);

        return ints.stream()
                .map(String::valueOf)
                .toList();
    }

    public void add(int number) {
        this.ints.add(number);
    }

    public void add(int... numbers) {
        for (int number : numbers) {
            add(number);
        }
    }
}
