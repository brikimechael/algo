package org.example.exception;

public class Parse {
    public static void parse(String str){
       String fa = "aa";
        try {
            float f = Float.parseFloat(str);
        }catch (NumberFormatException formatException){
           //f=0;

        }
    }
}
