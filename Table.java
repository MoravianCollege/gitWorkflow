import java.util.LinkedList;

public class Table
{
  private LinkedList<Card> cards;


  public Table()
  {
    cards = new LinkedList<>();
  }

  /**
   * Adds card to table linked list
   * @param card
   */
  public void add(Card card)
  {
    cards.add(card);
  }

  /**
   * Removes set from table linked list
   * @param c1 first Card to be removed
   * @param c2 second Card to be removed
   * @param c3 third Card to be removed
   */
  public void removeSet(Card c1, Card c2, Card c3)
  {
    if(!contains(c1) || !contains(c2) || !contains(c3))
      return;
    if(!Card.isSet(c1, c2, c3))
      return;
    
    cards.remove(c1);
    cards.remove(c2);
    cards.remove(c3);
  }

  /**
   * Returns whether or not a card is in the table linked list
   * @param c the card that will be compared with table
   * @return 
   */
  private boolean contains(Card c)
  {
    return cards.contains(c);
  }
  
  public int numCards()
  {
    return cards.size();
  }

  /**
   * Returns card at index
   * @param index
   * @return card at index
   */
  public Card getCard(int index)
  {
    return cards.get(index);
  }
  
  public int numSets()
  {
    int count = 0;

    int n1 = 0;

    int lastIndex = cards.size() - 1;

    while(n1 < lastIndex && n1 + 1 < lastIndex)
    {
      int n2 = n1 + 1;
      
      while(n2 < lastIndex && n2 + 1 <= lastIndex)
      {
        int n3 = n2 + 1;
        
        while(n3 <= lastIndex)
        {
          Card c1 = cards.get(n1);
          Card c2 = cards.get(n2);
          Card c3 = cards.get(n3);
          
          if(Card.isSet(c1, c2, c3))
            count++;
          
          n3++;
        }
        
        n2++;
      }
      
      n1++;
    }
    
    return count;
  }
        
      
}