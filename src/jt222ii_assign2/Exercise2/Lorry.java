package jt222ii_assign2.Exercise2;

/**
 * Created by jonastornfors on 2016-09-14.
 */
public class Lorry extends Vehicle
{
    private int maxPassengers = 2;
    public Lorry(int amountOfPassengers)
    {
        if(amountOfPassengers > maxPassengers || amountOfPassengers < 1)
        {
            throw new IndexOutOfBoundsException("Unvalid amount of passengers in the lorry!");
        }
        setCostPerPassenger(15);
        setSpace(8);
        setBaseCost(300);
        setPassengers(amountOfPassengers);
    }
}
