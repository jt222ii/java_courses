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
        for (Card.Colors color: Card.Colors.values())//for each suit/color in the enum Colors
        {
            for (Card.Values value: Card.Values.values())//add a card from each value: ace, 2, 3 etc
            {
                deck.add(new Card(color, value));
            }
        }
    }
    public void Shuffle()//shuffles the deck
    {
        if (deckSize() == 52) {
            Collections.shuffle(deck);
        }
        else
            System.err.println("Can only shuffle a complete deck!");
    }

    public int deckSize()//returns the size of the deck
    {
        return deck.size();
    }
    public Card handOutNextCard()//hands out the next card and removes it from the deck
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
