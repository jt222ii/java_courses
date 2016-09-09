package jt222ii_assign1.Deck;

/**
 * Created by jonastornfors on 2016-09-01.
 */
public class PlayCardsMain {
    public static void main (String args[])
    {
        Deck deck = new Deck();
        deck.Shuffle();

        for (int i = 0; i < 4; i++)//prints out some of the decks cards
        {
            Card card = deck.handOutNextCard();
            System.out.println(card.getValue()+" of "+card.getColor());
            System.out.println("Cards remaining: "+deck.deckSize());
        }
    }
}
