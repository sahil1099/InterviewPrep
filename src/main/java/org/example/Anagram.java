package org.example;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static void main(String[] args) {

        String s = "secure";

        boolean isAnagram = isAnagram("secure", "rescue");
        System.out.println("is String anagram" + isAnagram);

        String ss = "apple";

        Character c1 = ss.chars().mapToObj(c -> (char) c).filter(c -> ss.indexOf(c) == ss.lastIndexOf(c)).findFirst().get();
        System.out.println(c1);
    }


    public static boolean isAnagram (String str1, String str2){
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) return false;

        char[] charArray = str1.toCharArray();
        char[] charArrs = str2.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        //str1.
        for(char c:charArray){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }

        for(char c:charArrs){
            if(map2.containsKey(c)){
                map2.put(c, map2.get(c)+1);
            }else{
                map2.put(c, 1);
            }
        }
        return map.equals(map2);
    }
}
