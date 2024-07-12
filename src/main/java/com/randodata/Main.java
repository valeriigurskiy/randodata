package com.randodata;

import com.randodata.number.doubles.Doubles;
import com.randodata.number.doubles.DoublesStorage;
import com.randodata.number.integer.Ints;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();


        List<Double> all = Doubles.create()
                .limit(20)
                .range(10, 20)
                .wrapper()
                .all();

        System.out.println(all);

        System.out.println(all.size());

        long endTime = System.currentTimeMillis();

        System.out.println();
        System.out.println("Execute time: " + (endTime - startTime));
    }
}