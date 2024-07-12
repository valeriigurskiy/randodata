package com.randodata.utils;

import com.randodata.Utils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GeneralUtils implements Utils {

    private static final Random random = new Random();

    public static void isListEmpty(List<?> list) {
        if (list.isEmpty()) {
            throw new UnsupportedOperationException("Can't get element from empty list");
        }
    }

    public static void isLimitValid(int limit) {
        if (limit < 1) {
            throw new UnsupportedOperationException("Limit can't be less than 1");
        }
    }

    public static void nullCheck(Object object) {
        if (object == null) {
            throw new UnsupportedOperationException("Can't be null");
        }
    }

    public static int generateInRange(int to) {
        return generateInRange(0, to);
    }

    public static int generateInRange(int fromInclusive, int toInclusive) {
        return random.nextInt(fromInclusive, toInclusive);
    }

    public static List<String> toStringMapper(List<Object> list) {
        return list.stream()
            .map(Object::toString)
            .collect(Collectors.toList());
    }
}
