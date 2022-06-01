package de.fhws.programming_exercises.lesson_20.src.exercise_3;

import java.util.*;

public class Multimap{
    Map<String, List<String>> dictionary = new TreeMap<>();

    public void put(String key, String[] translations){
        List<String> list;
        if (dictionary.containsKey(key)){
            list = dictionary.get(key);
        }else{
            list = new ArrayList<>();
        }
        Collections.addAll(list, translations);
        dictionary.put(key, list);
    }

    public List<String> get(String key){
        return dictionary.getOrDefault(key, Collections.emptyList());
    }
}
