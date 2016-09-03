package jt222ii_assign1.Deck;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jonastornfors on 2016-09-01.
 */
public class Deck {

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
    public void Shuffle()
    {
        if (deckSize() == 52) {
            Collections.shuffle(deck);
        }
        else
            System.err.println("Can only shuffle a complete deck!");
    }

    public int deckSize()
    {
        return deck.size();
    }
    public Card handOutNextCard()
    {
        if(deckSize()>0)
        {
            Card cardToHandOut = deck.get(0);
            deck.remove(0);
            return cardToHandOut;
        }
        return null;
    }
}
