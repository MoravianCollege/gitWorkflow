
public class Table
{
  private TableNode head;
  
  public Table()
  {
    head = null;
  }

  /**
   * Adds card to table linked list
   * @param card
   */
  public void add(Card card)
  {
    TableNode newNode = new TableNode(card);
    newNode.setNext(head);
    
    head = newNode;
  }

  /**
   * Removes set from table linked list
   * @param Card to be removed
   * @param Card to be removed
   * @param Card to be removed
   */
  public void removeSet(Card c1, Card c2, Card c3)
  {
    if(!contains(c1) || !contains(c2) || !contains(c3))
      return;
    if(!c1.isSet(c2, c3))
      return;
    
    TableNode prev = findPrev(c1);
    remove(prev);
    
    prev = findPrev(c2);
    remove(prev);
    
    prev = findPrev(c3);
    remove(prev);
  }

  /**
   * Returns whether or not a card is in the table linked list
   * @param Card that will be compared with table
   * @return
   */
  private boolean contains(Card c)
  {
    TableNode curr = head;
    
    while(curr != null)
    {
      if(curr.getCard().equals(c))
        return true;
      
      curr = curr.getNext();
    }
    
    return false;
  }

  /**
   * Returns Card before parameter
   * @param Card at current location
   * @return
   */
  private TableNode findPrev(Card c)
  {
    TableNode curr = head;
    TableNode prev = null;
    
    while(!(curr.getCard().equals(c)))
    {
      prev = curr;
      curr = curr.getNext();
    }
    
    return prev;
  }

  /**
   * Removes Card after prev
   * @param previous Card from one to be removed
   */
  private void remove(TableNode prev)
  {
    // check for a head remove
    if(prev == null)
    {
      head = head.getNext();
      return;
    }
    
    TableNode toRemove = prev.getNext();
    
    prev.setNext(toRemove.getNext());
  }
  
  public int numCards()
  {
    TableNode temp = head;
    int count = 0;
    
    while(temp != null)
    {
      count++;
      temp = temp.getNext();
    }
    
    return count;
  }

  /**
   * Returns card at index
   * @param index
   * @return card at index
   */
  public Card getCard(int index)
  {
    if(index >= numCards())
      return null;
    
    TableNode temp = head;
    for(int i = 0; i < index; i++)
      temp = temp.getNext();
    
    return temp.getCard();
  }
  
  public int numSets()
  {
    TableNode n1 = head;
    int count = 0;
    
    while(n1 != null && n1.getNext() != null)
    {
      TableNode n2 = n1.getNext();
      
      while(n2 != null && n2.getNext() != null)
      {
        TableNode n3 = n2.getNext();
        
        while(n3 != null)
        {
          Card c1 = n1.getCard();
          Card c2 = n2.getCard();
          Card c3 = n3.getCard();
          
          if(c1.isSet(c2, c3))
            count++;
          
          n3 = n3.getNext();
        }
        
        n2 = n2.getNext();
      }
      
      n1 = n1.getNext();
    }
    
    return count;
  }
        
      
}