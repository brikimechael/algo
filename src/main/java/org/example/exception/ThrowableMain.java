package org.example.exception;

import java.sql.SQLException;
import java.util.EnumMap;

public class ThrowableMain {

    boolean test;
    static void a(){

    }
    void b(){
        a();
    }
    public void bla() throws SQLException {
        throw new SQLException();
    }
    public void test() throws Error{
        if(true) throw new AssertionError();
        System.out.println("hola");
    }

    public static void main(String... args){

       try {
           args = null;
           args[0]="zz";
       }catch (Exception np){
           System.out.println("nullPointer");
       }

        ThrowableMain throwableMain = new ThrowableMain();
       //throwableMain.bla();
        throwableMain.test();
        System.out.println("main");
    }
}
