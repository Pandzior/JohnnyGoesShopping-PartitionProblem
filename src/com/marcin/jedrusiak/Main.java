package com.marcin.jedrusiak;

import com.marcin.jedrusiak.model.Number;
import com.marcin.jedrusiak.utils.FastReader;

import java.util.ArrayList;
import java.util.List;

/*
    https://en.wikipedia.org/wiki/Partition_problem
*/
public class Main {

    public static void main(String[] args) {
        FastReader reader = new FastReader();

        int numbers = reader.nextInt();
        List<Number> numbersList = new ArrayList<>(numbers);

        for (int i = 0; i < numbers; i++) {
            long number = reader.nextLong();
            numbersList.add(new Number(number, i));
        }

        KarmarkarKarp.partition(numbersList);
    }
}
