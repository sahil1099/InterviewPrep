package org.example;

import java.util.*;
import java.util.stream.Stream;

public class FirstNonRepeatingCharInString {
    public static void main(String[] args) {
        /*String s = "aabbccdee";
        Set<Character> set = new HashSet<>();
        char[] charArray = s.toLowerCase().toCharArray();
        set.add(charArray[0]);
        char nonRepeat = charArray[0];
        boolean flag = false;
        for(int i=1; i< charArray.length; i++){
            if(nonRepeat=charArray[i]){

            }
            if(flag){
                flag = false;
                nonRepeat = charArray[i];
            }
            if(!set.add(charArray[i])){
                flag = true;
            }
        }*/
        String s = "aabbccdee";
        Map<Character, Integer> freqMap = new LinkedHashMap<>();

        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }
        }
        System.out.println("no non repeating char");

        Character c1 = s.chars().mapToObj(c -> (char) c)
                .filter(c -> s.indexOf(c) == s.lastIndexOf(c))
                .findFirst()
                .orElse(null);

        System.out.println(c1);

        /*Character c1 = s.chars().mapToObj(c -> (char) c)
                .filter(c -> s.indexOf(c) == s.lastIndexOf(c))
                .findFirst()
                .orElse(null);

        System.out.println(c1);*/

    }
}
