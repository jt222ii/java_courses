package jt222ii_assign1.Deck;

/**
 * Created by jonastornfors on 2016-09-01.
 */
public class Card {
    private Colors color;
    private Values value;

    public enum Colors
    {
        Clubs,
        Diamonds,
        Hearts,
        Spades
    }
    public enum Values
    {
        Ace,
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine,
        Ten,
        Jack,
        Queen,
        King
    }
    public Card(Colors col, Values val)
    {
        color = col;
        value = val;
    }
    public Colors getColor()
    {
        return color;
    }
    public Values getValue()
    {
        return value;
    }
}
