package org.example.basic;

public class Enum {

static {
    a= new int[]{4,5};
}
    static final int[] a ;
    enum A{
        B,C,D;
    }

    public static void main(String... args){
        int a = 5;
        A b = A.B;
        A c = A.C;
        System.out.println(b.compareTo(c));

    }
}
