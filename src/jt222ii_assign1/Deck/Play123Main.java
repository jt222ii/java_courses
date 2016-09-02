package jt222ii_assign1.Deck;

/**
 * Created by jonastornfors on 2016-09-02.
 */
public class Play123Main {
    public static void main (String args[])
    {
        int wins = 0, losses = 0;
        for (int i = 0; i < 10000; i++)
        {
            if(play123())
            {
                wins++;
            }
            else
                losses++;
        }
        System.out.println("chance to win is: "+(double)wins/losses*100+"%");

    }

    public static boolean play123()
    {
        int count = 0;
        Deck deck = new Deck();
        deck.Shuffle();
        for (int y = 0; y<52; y++)
        {
            Card card = deck.handOutNextCard();
            if (card.getValue().ordinal() == count)
            {
                return false;
            }
            if(count == 2)
            {
                count = 0;
            }
            else
            {
                count++;
            }
        }
        return true;
    }
}
