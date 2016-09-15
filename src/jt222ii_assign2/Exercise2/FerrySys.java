package jt222ii_assign2.Exercise2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jonastornfors on 2016-09-14.
 */
public class FerrySys implements Ferry
{
    private int maxPassengers = 200, maxSpace = 40;
    private double occupiedSpace = 0;
    private int moneyEarned = 0;


    private List<Passenger> passengers = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();

    public FerrySys() {}

    @Override
    public int countPassengers() {
        return passengers.size();
    }

    @Override
    public int countVehicleSpace() {
        return (int)occupiedSpace;
    }

    @Override
    public int countMoney() {
        return moneyEarned;
    }

    @Override
    public void embark(Vehicle v) {
        if(hasSpaceFor(v) && passengers.size() + v.getPassengerCount() <= maxPassengers )
        {
            for (Passenger p : v.getPassengers())
            {
                embark(p);
            }
            vehicles.add(v);
            moneyEarned += v.getBaseCost();
            occupiedSpace += v.getSpace();
        }
    }

    @Override
    public void embark(Passenger p) {
        if(hasRoomFor(p)) {
            passengers.add(p);
            moneyEarned += p.getCost();
        }
    }

    @Override
    public void disembark() {
        passengers.clear();
        vehicles.clear();
        occupiedSpace = 0;
    }

    @Override
    public boolean hasSpaceFor(Vehicle v) {

        return Math.ceil((int)occupiedSpace+v.getSpace()) <= maxSpace && !vehicles.contains(v);
    }

    @Override
    public boolean hasRoomFor(Passenger p) {
        return countPassengers() < maxPassengers && !passengers.contains(p);
    }

    @Override
    public Iterator<Vehicle> iterator() {
        return new ListIterator();
    }

    @Override
    public String toString()
    {
        String string = "Ferry!" +
                "\nVehicles: "+vehicles.size()+
                "\nPassengers: "+passengers.size()+"/"+maxPassengers+
                "\nSpace occupied(rounded down): "+countVehicleSpace()+"/"+maxSpace+
                "\nIncome: "+moneyEarned+"kr"+
                "\n___________________________________________\nVehicle Details:";
        ListIterator iterator = new ListIterator();
        while(iterator.hasNext()) {
            Vehicle v = iterator.next();
            string += "\nType: " + v.getClass().getSimpleName() + " | Passengers: " +
                        v.getPassengerCount() + " | Base cost: " + v.getBaseCost() + " Cost per passenger: " + v.getCostPerPassenger()+
                        " Total: "+(v.getBaseCost()+v.getCostPerPassenger()*v.getPassengerCount());
        }

        return string;
    }

    private class ListIterator implements Iterator<Vehicle>
    {
        private int count = 0;
        @Override
        public Vehicle next()
        {
            return vehicles.get(count++);
        }

        @Override
        public boolean hasNext()
        {
            return count < vehicles.size();
        }
    }
}
