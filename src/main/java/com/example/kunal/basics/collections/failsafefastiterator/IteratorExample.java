package com.example.kunal.basics.collections.failsafefastiterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IteratorExample {

    public static void main(String[] args) {

        List<String> list = List.of("kunal", "john", "doe");
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()){
            String str = itr.next();
            System.out.println(str);
            if (str.equals("kunal")){itr.remove();}
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);
        Iterator<Map.Entry<Integer, Integer>> mapItr = map.entrySet().iterator();
        while (mapItr.hasNext()){
            Map.Entry<Integer, Integer> entry = mapItr.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
            if (entry.getKey() == 2){mapItr.remove();}
        }
    }
}
