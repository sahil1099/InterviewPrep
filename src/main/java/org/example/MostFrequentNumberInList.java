package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MostFrequentNumberInList {


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,4,5,3,2,5,7,8,9,5,7);

        List<Integer> collect = list.stream()
                // Count frequency of each number
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet().stream()
                // Sort by frequency (value) descending, then by number ascending (optional tie-breaker)
                .sorted((e1, e2) -> {
                    int freqCompare = Long.compare(e2.getValue(), e1.getValue());
                    return freqCompare != 0 ? freqCompare : Integer.compare(e1.getKey(), e2.getKey());
                })
                // Take top 3
                .limit(3)
                // Extract just the numbers
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(collect);

    }
    }

