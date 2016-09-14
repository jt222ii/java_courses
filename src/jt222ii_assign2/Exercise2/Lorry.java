package jt222ii_assign2.Exercise2;

/**
 * Created by jonastornfors on 2016-09-14.
 */
public class Lorry extends Vehicle
{
    private int maxPassengers = 2;
    public Lorry(int amountOfPassengers)
    {
        if(amountOfPassengers > maxPassengers)
        {
            throw new IndexOutOfBoundsException("Can't add more than two passengers to a lorry!");
        }
        setCostPerPassenger(15);
        setSpace(8);
        setBaseCost(300);
        setPassengers(amountOfPassengers);
    }
}
