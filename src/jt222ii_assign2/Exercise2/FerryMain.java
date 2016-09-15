package jt222ii_assign2.Exercise2;

/**
 * Created by jonastornfors on 2016-09-14.
 */
public class FerryMain {
    public static void main(String[] args)
    {
        FerrySys ferry = new FerrySys();
        System.out.println("Adding 5 cars with 4 passengers each");
        ferry.embark(new Car(4));
        ferry.embark(new Car(4));
        ferry.embark(new Car(4));
        ferry.embark(new Car(4));
        ferry.embark(new Car(4));


        System.out.println("Adding 2 bicycles(1 passenger each default)");
        ferry.embark(new Bicycle());
        ferry.embark(new Bicycle());

        System.out.println("Adding a lorry with 2 passengers");
        ferry.embark(new Lorry(2));

        System.out.println("Adding a bus with 18 passengers");
        ferry.embark(new Bus(18));


        System.out.println();
        System.out.println(ferry.toString());
        System.out.println();
        System.out.println("Disembarking ferry");
        ferry.disembark();
        System.out.println("Ferry should now be empty and profit stay the same:");
        System.out.println(ferry.toString());

        System.out.println();
        System.out.println("adding a bus with 12 passengers");
        //ferry.embark(new Bus(12));

        System.out.println("Embarking 20 cars with 3 passengers each");
        for (int i = 0; i < 20; i++)
        {
            ferry.embark(new Car(4));
        }
        System.out.println("Trying to add 100 bikes only 80 should fit");
        for (int i = 0; i < 200; i++)
        {
            ferry.embark(new Bicycle());
        }
        System.out.println("Embarking a lone person total passenger count should be 153");
        ferry.embark(new Passenger());

        System.out.println();
        System.out.println(ferry.toString());

    }
}
