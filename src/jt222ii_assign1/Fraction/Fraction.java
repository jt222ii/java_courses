package jt222ii_assign1.Fraction;

/**
 * Created by jonastornfors on 2016-09-01.
 */
public class Fraction {

    private int num, denom;
    public Fraction(int numerator, int denominator)
    {
        if(denominator == 0)
        {
            throw new IllegalArgumentException("Can not have a denominator that is 0!");
        }
        num = numerator;
        denom = denominator;
        simplify();
    }
    public int getNumerator()
    {
        return num;
    }
    public int getDenominator()
    {
        return denom;
    }
    public boolean isNegative()
    {
        return (double)num/(double)denom < 0;
    }
    public Fraction add(Fraction frac2)
    {
        return new Fraction((frac2.getDenominator()*num)+(frac2.getNumerator()*denom), denom*frac2.getDenominator());
    }
    public Fraction subtract(Fraction frac2)
    {
        return new Fraction(frac2.getDenominator()*num-frac2.getNumerator()*denom, denom*frac2.getDenominator());
    }
    public Fraction multiply(Fraction frac2)
    {
        return new Fraction(frac2.getNumerator()*num, denom*frac2.getDenominator());
    }
    public Fraction divide(Fraction frac2)
    {
        return multiply(new Fraction(frac2.getDenominator(), frac2.getNumerator()));
    }
    public boolean isEqualTo(Fraction frac2)
    {
        return (double)num/denom == (double)frac2.getNumerator()/frac2.getDenominator();
    }
    public String toString()
    {
        return num+"/"+denom;
    }
    public void simplify()
    {
        int numerator = num;
        int denominator = denom;

        while (denominator != 0) {
            int t = denominator;
            denominator = numerator % denominator;
            numerator = t;
        }
        int gcd = numerator;
        num /= gcd;
        denom /= gcd;

    }



}
