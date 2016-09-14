package jt222ii_assign2.Exercise2;

/**
 * Created by jonastornfors on 2016-09-14.
 */
public class Vehicle
{
    private double space;
    private Passenger[] passengers;
    private int costPerPassenger;
    private int baseCost;

    public void setSpace(double spaceSize)
    {
        space = spaceSize;
    }

    public void setCostPerPassenger(int cost)
    {
        costPerPassenger = cost;
    }

    public void setPassengers(int count)
    {
        passengers = new Passenger[count];
        for (int i = 0; i < passengers.length; i++)
        {
            passengers[i] = new Passenger(costPerPassenger);
        }
    }

    public void setBaseCost(int cost)
    {
        baseCost = cost;
    }

    public int getBaseCost()
    {
        return baseCost;
    }

    public int getCostPerPassenger()
    {
        return costPerPassenger;
    }

    public double getSpace()
    {
        return space;
    }

    public int getPassengerCount()
    {
        return passengers.length;
    }

    public Passenger[] getPassengers()
    {
        return passengers;
    }

}
