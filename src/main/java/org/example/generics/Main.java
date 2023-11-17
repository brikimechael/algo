package org.example.generics;

import org.example.oo.Constructor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

    class Dragon {
    }

    class Unicorn {
    }

    class A {
        void print(){
            System.out.println("A");
        }
    }

    class B extends  A {
        @Override
        void print() {
            System.out.println("B");
        }
    }
interface Flyer { void fly(); }
class HangGlider implements Flyer { public void fly() {} }
class Goose implements Flyer { public void fly() {} }
class Shape { /* ... */ }
class Circle extends Shape { /* ... */ }
class Rectangle extends Shape { /* ... */ }
    public class Main {
        private void anyFlyer(List<Flyer> flyer) {}
        private void groupOfFlyers(List<? extends Flyer> flyer) {}

        private <T> void changePosition(T[] arr,int x,int y){
            if(x<arr.length&&y<arr.length) {
                T tmp = arr[x];
                arr[x]=arr[y];
                arr[y]=tmp;
            }
        }


        public static void main(String[] args) {

Object aa = "there";
            System.out.println(aa.toString());
List <B> o = new ArrayList<>();
            Main m = new Main();
            B an = new B();
            o.add(an);
            List<? extends A> a = o;
            a.get(0).print();
            List<Flyer> test = new ArrayList<>();
            HangGlider hangGlider = new HangGlider();
            Goose goose = new Goose();
            test.add(hangGlider);
            test.add(goose);
            m.anyFlyer(test);
            m.groupOfFlyers(test);

            List<? super IOException> exceptions = new ArrayList<>();
           //  exceptions.add(new Exception()); // DOES NOT COMPILE
             exceptions.add(new FileNotFoundException());
            List unicorns = new ArrayList();
            unicorns.add(new Unicorn());
            //printDragons(unicorns);
        }

        private static void printDragons(List<Dragon> dragons) {
            for (Dragon dragon : dragons) { // ClassCastException
                System.out.println(dragon);
            }
        }
    }