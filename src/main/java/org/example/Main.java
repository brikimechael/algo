package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;



public class Main {


    public static Integer calculateTotalExperience(Stream<Person> stream) {
        return stream.reduce(Integer.valueOf(0),
                (sum, p) -> sum + p.experience, // line n1
                (v1, v2) -> v1 * v2);     // line n2
    }

    public static void main(String[] args) {

        Person p1 = new Person("P1", 3);
        Person p2 = new Person("P2", 3);
        Person p3 = new Person("P3", 4);
        Person p4 = new Person("P4", 5);
        List<Person> list = List.of(p1, p2, p3, p4);
        Integer totalAge = calculateTotalExperience(list.stream());

        System.out.println(totalAge);



    }
}