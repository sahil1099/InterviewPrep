package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastFailSafe {

    public static void main(String[] args) {
        // Fail Safe
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(1,2,3,4));
        Iterator<Integer> it = list.iterator();

        while(it.hasNext()){
            Integer i = it.next();
            if(i==2){
                list.remove(i);
                System.out.println("value removed");
            }
        }

        //fail fast
        List<Integer> list2 = Arrays.asList(1,2,3,4);
        Iterator<Integer> it2 = list2.iterator();

        while(it2.hasNext()){
            Integer i = it2.next();
            if(i==2){
                list2.remove(i);
                System.out.println("value removed");
            }
        }
    }
}
