package InterfacceFunzionali;

import java.util.function.Consumer;

public class Example {
    public static void main(String[] args) {

    Consumer<Integer> c = (x)->{
        System.out.println(c);
        c +=2 ;

    };
    c.accept (4);

}
