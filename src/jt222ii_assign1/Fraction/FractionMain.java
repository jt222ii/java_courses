package jt222ii_assign1.Fraction;

/**
 * Created by jonastornfors on 2016-09-01.
 */
public class FractionMain {
    public static void main (String args[])
    {
        //get numerator and dominator
        System.out.println("getNumerator and getDominator. Result should be num = 3, dem = 4;");
        Fraction frac = new Fraction(3,4);
        System.out.println("num = "+frac.getNumerator()+" dem = "+frac.getDenominator());

        //isNegative
        System.out.println("isNegative");
        System.out.println("-1/3 should return true: " + new Fraction(-1, 3).isNegative()+" -- 1/3 should return false: "+new Fraction(1,3).isNegative());

        //add subtract multiply divide
        System.out.println("add, subtract multiply and divide");
        System.out.println("3/9 + 1/3 should be 2/3:");
        System.out.println(new Fraction(3,9).add(new Fraction(1,3)).toString());
        System.out.println("6/9 - 1/3 should be 1/3:");
        System.out.println(new Fraction(6,9).subtract(new Fraction(1,3)).toString());
        System.out.println("(3/4) * (1/3) should be 1/4:");
        System.out.println(new Fraction(3,4).multiply(new Fraction(1,3)).toString());
        System.out.println("(3/4) / (4/5) should be 15/16:");
        System.out.println(new Fraction(3,4).divide(new Fraction(4,5)).toString());

        //isEqualTo
        System.out.println("isEqualTo");
        System.out.println("3/4 should be equal to 6/8 should return true: ");
        System.out.println(new Fraction(3,4).isEqualTo(new Fraction(6,8)));
        System.out.println("3/4 should not be equal to 7/8 should return false: ");
        System.out.println(new Fraction(3,4).isEqualTo(new Fraction(7,8)));



    }
}
