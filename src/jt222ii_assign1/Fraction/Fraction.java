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
    public int getNumerator()//returns the numerator
    {
        return num;
    }
    public int getDenominator()//returns the denominator
    {
        return denom;
    }
    public boolean isNegative()//returns true if the fraction is negative
    {
        return (double)num/(double)denom < 0;
    }
    public Fraction add(Fraction frac2)//adds fraction 1 with fraction 2
    {
        return new Fraction((frac2.getDenominator()*num)+(frac2.getNumerator()*denom), denom*frac2.getDenominator());
    }
    public Fraction subtract(Fraction frac2)//subtracts fraction 2 from fraction 1
    {
        return new Fraction(frac2.getDenominator()*num-frac2.getNumerator()*denom, denom*frac2.getDenominator());
    }
    public Fraction multiply(Fraction frac2)//Multiplies the two fractions
    {
        return new Fraction(frac2.getNumerator()*num, denom*frac2.getDenominator());
    }
    public Fraction divide(Fraction frac2)//divides the two fractions using the multiply function as (1/2)/(2/3) is the same as (1/2)*(3/2)
    {
        return multiply(new Fraction(frac2.getDenominator(), frac2.getNumerator())); // multiplies using a new fraction with the denominator and numerator swapped
    }
    public boolean isEqualTo(Fraction frac2)//returns true if the two fractions is equal
    {
        return (double)num/denom == (double)frac2.getNumerator()/frac2.getDenominator();
    }
    public String toString()
    {
        return num+"/"+denom;
    }//returns the fraction as a string


    //simplifies the fraction
    public void simplify()//I have used help from https://answers.yahoo.com/question/index?qid=20101104212230AAqKxYa
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
