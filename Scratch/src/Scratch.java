public class Scratch {
    public static void main(String[] args) {
        AnotherSampleClass asc = new AnotherSampleClass();
        Scratch sc = new Scratch();
        sc.foo();
        sc = asc;
        sc.foo();
        asc.foo();

// TODO code application logic here
    }

    public void foo(){
        System.out.println("bar");
    }
}
class AnotherSampleClass extends Scratch {
    public void foo(){
        System.out.println("baz");
    }
}
