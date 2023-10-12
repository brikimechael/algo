package org.example.basic;

interface Custom{
     int a = 15;
}
public class Increment {
    final int a = 10;
    public void show(int a){
        a+=1;
        System.out.println(++a);
    }
    public static void main(String... a ){
        Increment increment = new Increment();
        increment.show(5);

    }
}
