package org.example.gc;

class MyClass  {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("destroyed");
    }
}
class Main { //from   ww  w .  j  a  v a 2  s .  co  m
    private MyClass m = new MyClass ();
    public void m (MyClass pMyClass){
        pMyClass = null;
    }

    public void m2 (){
        m (this.m);
    }
    public static void main (String [] args){
        Main n = new Main ();
        n.m2 ();
        System.out.println(n.m==null);
        //System.gc();
    }
}