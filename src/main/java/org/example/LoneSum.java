package org.example;

import java.util.HashMap;
import java.util.Map;

public class LoneSum {

    public static void main(String[] args) {
        int sum = 0;
        Integer[] arr = {3,2,3,3,5,2};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<arr.length ; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> val: map.entrySet()){
            if(val.getValue()%2!=0){
                sum = sum + val.getKey();
            }
        }
        System.out.println(sum);
    }
}
