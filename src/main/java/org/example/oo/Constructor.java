package org.example.oo;

public class Constructor {

    public class A {
        protected int a;
        public A(int a){
            this.a=a;
        }
    }
    public class B extends A{

        public B(int b){
            super(b);
           // a=b;
        }
    }
}
