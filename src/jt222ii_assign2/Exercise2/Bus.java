package jt222ii_assign2.Exercise2;

/**
 * Created by jonastornfors on 2016-09-14.
 */
public class Bus extends Vehicle
{
    private int maxPassengers = 20;
    public Bus(int amountOfPassengers)
    {
        if(amountOfPassengers > maxPassengers)
        {
            //kasta skit
        }
        setCostPerPassenger(10);
        setSpace(4);
        setBaseCost(200);
        setPassengers(amountOfPassengers);
    }
}
