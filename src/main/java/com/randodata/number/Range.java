package com.randodata.number;

public final class Range {
    private final double from;

    private final double to;

    private Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public static Range of(double from, double to) {
        if (from > to) {
            throw new UnsupportedOperationException("Param from can't be greater than to");
        }
        return new Range(from, to);
    }

    public double from() {
        return from;
    }

    public double to() {
        return to;
    }

    public int fromAsInt() {
        if (from < Integer.MIN_VALUE) {
            throw new UnsupportedOperationException("Can't be casted to int because value less than MIN_VALUE");
        }
        return (int) from;
    }

    public int toAsInt() {
        if (to > Integer.MAX_VALUE) {
            throw new UnsupportedOperationException("Can't be casted to int because value greater than MAX_VALUE");
        }
        return (int) to;
    }
}
