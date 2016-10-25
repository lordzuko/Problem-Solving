package BlueOptima;

/**
 * Created by hmaurya on 9/24/2016.
 */
import java.util.*;
class test {
    public static void main(String args[]) {

            Sub s = new Sub();
            s.func();

            ((Sub)s).func(1);

    }
}

class Base {
    public void func() {
        System.out.println("Base");
    }
}

class Sub extends Base {
    public void func() {
        System.out.println("Sub");
    }

    public void func(int i){
        System.out.println("Subi");
    }
}

