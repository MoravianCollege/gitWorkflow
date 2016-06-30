//This class plays one game of set
public class Game {
  private Table t;
  private Deck d;

  //This constructor plays a game of set using a standard deck
  public Game() {
    t = new Table();
    d = new Deck();

    // There are always 81 cards in a new Deck, so this can't fail
    for (int i = 0; i < 12; i++)
      t.add(d.getNext());
  }

  //This constructor plays a game of set using a specific deck
  public Game(String filename) {
    t = new Table();
    d = new Deck(filename);

    // There might not be 12 cards
    while (d.hasNext() && t.numCards() < 12)
      t.add(d.getNext());
  }

  public int numSets() {
    return t.numSets();
  }

  public int numCards() {
    return t.numCards();
  }

  public boolean isGameOver() {
    if (d.hasNext())
      return false;

    // if we get here, there are no more cards in the deck
    // the game continues until there are no sets on the table
    return t.numSets() == 0;
  }

  /** Removes a set from the table
   * iterates over the table until it finds a set
   * once set is found it is removed and the loop is broken
   */
  private void removeSetFromTable() {
    loop:
    for (int x = 0; x < t.numCards() - 2; x++) {
      for (int y = x + 1; y < t.numCards() - 1; y++) {
        for (int z = y + 1; z < t.numCards(); z++) {
          if (Card.isSet(t.getCard(x), t.getCard(y), t.getCard(z))) {
            t.removeSet(t.getCard(x), t.getCard(y), t.getCard(z));
            break loop;
          }
        }
      }
    }
  }

  /** Add cards to the table
   * one at a time until there are no cards left in the deck
   * or it has added 3 cards
   */
  private void addCardsToTable() {
    int i = 0;
    while (d.hasNext() && i < 3) {
      t.add(d.getNext());
      i += 1;
    }
  }

  public void playRound() {
    if (t.numSets() == 0 && d.hasNext()) {
      this.addCardsToTable();
    }
    else if (t.numSets() > 0 && t.numCards() == 12) {
      this.removeSetFromTable();
      if (d.hasNext())
        this.addCardsToTable();
    }
    else if (t.numSets() > 0 && t.numCards() > 12) {
      this.removeSetFromTable();
    }
    else if (t.numSets() > 0 && !d.hasNext()) {
      this.removeSetFromTable();
    }
  }
}