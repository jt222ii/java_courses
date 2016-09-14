package jt222ii_assign2.Exercise2;

/**
 * Created by jonastornfors on 2016-09-14.
 */
public class FerryMain {
    public static void main(String[] args)
    {
        FerrySys ferry = new FerrySys();
        ferry.embark(new Car(4));
        ferry.embark(new Car(4));
        ferry.embark(new Car(4));
        ferry.embark(new Car(4));
        ferry.embark(new Car(4));

        ferry.embark(new Bicycle());
        ferry.embark(new Bicycle());

        ferry.embark(new Lorry(2));
        ferry.embark(new Bus(18));

        System.out.println(ferry.toString());
    }
}
