import java.util.LinkedList;

public class Table
{
  /**
   *
   */
  private LinkedList<Card> cards;


  public Table()
  {
    cards = new LinkedList<>();
  }


  public void add(Card card)
  {
    cards.add(card);
  }
  
  public void removeSet(Card c1, Card c2, Card c3)
  {
    if(!contains(c1) || !contains(c2) || !contains(c3))
      return;
    if(!c1.isSet(c2, c3))
      return;
    
    cards.remove(c1);
    cards.remove(c2);
    cards.remove(c3);
  }
  
  private boolean contains(Card c)
  {
    return cards.contains(c);
  }
  
  public int numCards()
  {
    return cards.size();
  }
  
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
          
          if(c1.isSet(c2, c3))
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