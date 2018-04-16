package com.marcin.jedrusiak;

import com.marcin.jedrusiak.model.Number;
import com.marcin.jedrusiak.utils.Hand;

import java.util.*;
/*
    http://www.cs.cmu.edu/afs/cs/academic/class/15451-s10/www/recitations/rec0318.txt
    https://pdfs.semanticscholar.org/07ad/87309131f01b113d82bee144bc5e88fb10af.pdf
*/
public class KarmarkarKarp {

    private KarmarkarKarp() {
    }

    public static void partition(List<Number> baseArr) {
        Queue<Number> heap = new PriorityQueue<>(baseArr.size(), new Comparator<Number>() {
            @Override
            public int compare(Number aLong, Number t1) {
                return Long.compare(t1.getValue(), aLong.getValue());
            }
        });

        List<List<Integer>> edges = new ArrayList<>(baseArr.size());

        for (int i = 0; i < baseArr.size(); i++) {
            edges.add(i, new ArrayList<>());
        }

        for (Number value : baseArr) {
            heap.add(value);
        }

        int firstIndex = -1;

        while (heap.size() > 1) {
            Number num1 = heap.poll();

            Number num2 = heap.poll();

            if (firstIndex == -1) {
                firstIndex = num2.getIndex();
            }

            long diff = num1.getValue() - num2.getValue();

            edges.get(num1.getIndex()).add(num2.getIndex());
            edges.get(num2.getIndex()).add(num1.getIndex());

            Number number = new Number(diff, num1.getIndex());

            heap.add(number);
        }

        colorGraph(edges, firstIndex);
    }

    private static void colorGraph(List<List<Integer>> graph, int firstIndex) {
        Hand[] partsWithColor = new Hand[graph.size()];
        Arrays.fill(partsWithColor, Hand.NONE);

        Queue<Integer> queue = new PriorityQueue<>();

        partsWithColor[firstIndex] = Hand.LEFT;

        queue.add(firstIndex);

        while (!queue.isEmpty()) {
            Integer index = queue.poll();

            for (Integer n : graph.get(index)) {
                if (partsWithColor[n] == Hand.NONE) {
                    partsWithColor[n] = partsWithColor[index] == Hand.LEFT ? Hand.RIGHT : Hand.LEFT;
                    queue.add(n);
                }
            }
        }

        printSet(partsWithColor);
    }

    private static void printSet(Hand[] parts) {
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == Hand.LEFT) {
                System.out.println(i + 1);
            }
        }
    }
}
