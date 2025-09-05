package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class StringReverse {

    public static void main(String[] args) {
        String s = "abcde";

        char[] charArray = s.toCharArray();
        StringBuilder reverse= new StringBuilder();
        for(int i=charArray.length-1; i>=0; i--){
            reverse.append(charArray[i]);
        }
        System.out.println(reverse);
    }
}
