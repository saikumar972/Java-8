package dumps;

public class Lite {
    public static void main(String[] args) {
        Child c=new Child();
        int num = 10;  // Effectively final
        Runnable r = new Runnable() {
            public void run() {
                System.out.println(num);  // This works
            }
        };
        //num = 20;  // This would result in a compile-time error

    }
}
class Parent {
    static {
        System.out.println("Static block in Parent");
    }
}

class Child extends Parent {
    static {
        System.out.println("Static block in Child");
    }
}