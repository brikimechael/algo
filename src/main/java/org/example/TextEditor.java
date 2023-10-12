package org.example;

public class TextEditor {
    static class Char { // line 1
        char c;
        public Char(char c) {
            this.c = c;
        }
        public void print() {
            System.out.print(c);
        }
    }

    public static void main(String[] args) {
        Char bla = new Char('B') { // line 2
            public void kill() {
                System.out.print("[");
                super.print();  // line 3
                System.out.print("]");
            }
            public void print(){
                kill();
            }
        };

        typeText(new Char('A'));
        typeText(new Char('B') { // line 2
            public void kill() {
                System.out.print("[");
                super.print();  // line 3
                System.out.print("]");
            }
        });
    }
    private static void typeText(Char c) {
        c.print();
    }
}
