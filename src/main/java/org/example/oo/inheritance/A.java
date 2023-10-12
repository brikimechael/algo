package org.example.oo.inheritance;

interface A { public void aMethod();}
interface B { public void bMethod();}
interface C extends A,B { public void cMethod();}
class D implements B{ public void bMethod() {
    System.out.println("D");
}}
class E extends D implements B{
    @Override
    public void bMethod() {
        System.out.println("E");
    }
    public static void main(String... args){
        D e = (D)(new E());
        e.bMethod();

    }
}