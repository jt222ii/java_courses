package jt222ii_assign1.Deck;

/**
 * Created by jonastornfors on 2016-09-02.
 */
public class Play123Main {
    public static void main (String args[])
    {
        int wins = 0, plays = 10000;
        for (int i = 0; i < plays; i++)
        {
            if(play123())
            {
                wins++;
            }
        }
        System.out.println("chance to win is: "+(double)wins/plays*100+"%");

    }

    public static boolean play123()
    {
        int count = 0;
        Deck deck = new Deck();
        deck.Shuffle();
        for (int y = 0; y<52; y++)
        {
            Card card = deck.handOutNextCard();
            if (card.getValue().ordinal() == count)//if count is the same as the ordinal of enum you have lost
            {
                return false;
            }
            if(count == 2)// if count has reached 2 (0,1,2) count should start over
            {
                count = 0;
            }
            else//else keep counting
            {
                count++;
            }
        }
        return true;
    }
}
