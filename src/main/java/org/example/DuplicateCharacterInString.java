package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateCharacterInString {

    public static void main(String[] args) {
        String s = "ssaabiicc";
        Set<Character> set = new HashSet<>();
        Map<Character, Long> collect = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(collect);

        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char c:charArray){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }
        System.out.println(map);

    }
}
