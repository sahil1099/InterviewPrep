package org.example;

import java.util.Arrays;
import java.util.List;

public class ContigiousSubArray {

    public static void main(String[] args) {
        int sum = 45;

        Integer[] arr = {12,5,30,10,9,7,3,15,12};
        boolean found = false;
        //List<Integer> list = Arrays.asList(12,5,30,10,9,7,3,15,12);

        for(int i = 0; i<arr.length; i++){
            int currentSum = arr[i];
            for(int j = i+1; j<arr.length; j++){
                currentSum = currentSum + arr[j];
                if(currentSum<sum)
                    continue;
                else if(currentSum>sum)
                    break;
                else{
                    for(int k=i; k<=j; k++){
                        System.out.println(arr[k]);
                    }
                    found = true;
                    break;
                }
            }
        }
        if(!found){
            System.out.println("No sub array found");
        }

    }
}
