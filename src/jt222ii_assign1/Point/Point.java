package jt222ii_assign1.Point;

/**
 * Created by jonastornfors on 2016-08-31.
 */
public class Point {

    int x=0, y=0;

    public Point()
    {

    }

    public Point(int paramX, int paramY)
    {
        x = paramX;
        y = paramY;
    }

    public static void main (String args[])
    {
        Point p1 = new Point();
        Point p2 = new Point(3,4);

        System.out.println(p1.toString());   // ==> (0,0)
        System.out.println(p2.toString());   // ==> (3,4)

        if (p1.isEqualTo(p2))              // False!
            System.out.println("The two points are equal");

        double dist = p1.distanceTo(p2);
        System.out.println("Point Distance: "+dist);

        p2.move(5,-2);         // ==> (8,2)
        p1.moveToXY(8,2);      // ==> (8,2)

        if (p1.isEqualTo(p2))              // True!
            System.out.println("The two points are equal");
    }

    public String toString()
    {
        return "("+x+","+y+")";
    }

    public boolean isEqualTo(Point p2)
    {
        return x == p2.x && y == p2.y;
    }

    public double distanceTo(Point p2)
    {
        return Math.sqrt(Math.pow((x-p2.x), 2) + Math.pow((y-p2.y),2));
    }

    public void move(int paramX, int paramY)
    {
        x += paramX;
        y += paramY;
    }

    public void moveToXY(int paramX, int paramY)
    {
        x = paramX;
        y = paramY;
    }
}
