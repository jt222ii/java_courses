package jt222ii_assign1.Deck;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by jonastornfors on 2016-09-01.
 */
public class Deck {

    int cardsRemaining = 52;
    ArrayList<Card> deck = new ArrayList<>();
    public Deck()
    {
        for (Card.Colors color: Card.Colors.values())
        {
            for (Card.Values value: Card.Values.values())
            {
                deck.add(new Card(color, value));
            }
        }
    }

    public static void main (String args[]) throws Exception
    {

    }

}
