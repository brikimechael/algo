package org.example.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Test{


    public static void main(String... args){

        // Collectors.groupingBy
        List<Student> list = new ArrayList<>();
        list.add(new Student("Davis", SUBJECT.MATH, 35.0));
        list.add(new Student("Davis", SUBJECT.SCIENCE, 12.9));
        list.add(new Student("Davis", SUBJECT.GEOGRAPHY, 37.0));
        list.add(new Student("Sascha", SUBJECT.ENGLISH, 85.0));
        list.add(new Student("Sascha", SUBJECT.MATH, 80.0));
        list.add(new Student("Sascha", SUBJECT.SCIENCE, 12.0));
        list.add(new Student("Sascha", SUBJECT.LITERATURE, 50.0));
        list.add(new Student("Robert", SUBJECT.LITERATURE, 12.0));

        Map<String, Double> result = list.stream().collect(Collectors.groupingBy(s->s.getName(), ()->new TreeMap<>(),Collectors.summingDouble(s->s.getNote())));
        System.out.println(result);

        //
    }
}
