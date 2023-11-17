package org.example.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String... args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Strawberry");
        // correct way
/*        Iterator<String> fruitIterator = fruits.iterator();
        while (fruitIterator.hasNext()) {
            String fruit = fruitIterator.next();
            System.out.println(fruit);
            if ("Apple".equals(fruit)) {
                fruitIterator.remove();
            }
        }*/
// ConcurrentModificationException
/*            for (String fruit : fruits) {
                System.out.println(fruit);
                if ("Apple".equals(fruit)) {
                    fruits.remove(fruit);
                }
            }*/

            for (int i = 0; i < fruits.size(); i++) {
                System.out.println(fruits.size()+" "+fruits.get(i));

                if ("Apple".equals(fruits.get(i))) {
                    fruits.remove(i);
                }
            }
        }

}
