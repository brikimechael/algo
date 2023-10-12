package org.example.oo;


import org.example.oo.constructor.B;

public class PlantTree {
    public static class Plant{
        void show(){
            System.out.println("Plant");
        }
        String noun;
        String name ;
        int age;

        public Plant(){
            this("plant");
        }
        public Plant(String name){
            this.name = name;
        }
        String getName(){
            return name;
        }
    }
    public static class Tree extends Plant{
        String name="tree";
        void show(){
            System.out.println("Tree");
        }
        String getName(){
            return this.name;
        }

    }

    public static void main(String... args){
        Plant t = new Tree();
        System.out.println(t.getName());
        System.out.println(t.name);
        t.show();

    }


}
