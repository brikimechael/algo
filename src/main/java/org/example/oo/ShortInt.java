package org.example.oo;

public class ShortInt {
    

    //void go(int x){System.out.println("int");}
    void go(Short x){
        System.out.println("short");
    }
    void go(Long x){
        System.out.println("long");
    }

    public static void main(String...args){
        ShortInt shortInt = new ShortInt();
        short x =5;
        shortInt.go(x);
    }
}
