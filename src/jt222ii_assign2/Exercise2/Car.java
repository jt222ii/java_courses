package jt222ii_assign2.Exercise2;

/**
 * Created by jonastornfors on 2016-09-14.
 */
public class Car extends Vehicle
{
    private int maxPassengers = 4;
    public Car(int amountOfPassengers)
    {
        if(amountOfPassengers > maxPassengers)
        {
            //kasta skit
        }
        setCostPerPassenger(15);
        setSpace(1);
        setBaseCost(100);
        setPassengers(amountOfPassengers);
    }
}
