/**
 * @author Dr. Coleman
 */
public class Card
{
  private int quantity;
  private int color;
  private int shading;
  private int shape;

  /**
   * This constructor assigns a card a specific attribute for quantity, color,
   * shading, and shape.
   * @param theQuantity
   * @param theColor
   * @param theShading
   * @param theShape
     */
  public Card(int theQuantity, int theColor, int theShading, int theShape)
  {
    quantity = fixValue(theQuantity);
    color = fixValue(theColor);
    shading = fixValue(theShading);
    shape = fixValue(theShape);
  }

  /**
   * fixValue fixes a value for either quantity, color, shading, or shape that
   * is less than or equal to three
   * @param value
   * @return
     */
  private int fixValue(int value)
  {
    value = value % 3;
    
    if(value <= 0)
      value += 3;
    
    return value;
  }

  /**
   * Gets the quantity of a given card between 1-3
   * @return
     */
  public int getQuantity()
  {
    return quantity;
  }
  
  public int getColor()
  {
    return color;
  }
  
  public int getShading()
  {
    return shading;
  }
  
  public int getShape()
  {
    return shape;
  }

  /**
   * Sums integer representations of the quantity, color, shading, and shape
   * of three Card objects. This method returns true only if all 4 sums are
   * divisible by 3 (which tells us the three cards are a set).
   * @param c1 Card object to be tested.
   * @param c2 Card object to be tested.
   * @param c3 Card object to be tested.
   * @return Boolean: true if three cards are a set, false if not.
   */
  public static boolean isSet(Card c1, Card c2, Card c3)
  {
    int quantitySum = c1.getQuantity() + c2.getQuantity() + c3.getQuantity();
    int colorSum = c1.getColor() + c2.getColor() + c3.getColor();
    int shadingSum = c1.getShading() + c2.getShading() + c3.getShading();
    int shapeSum = c1.getShape() + c2.getShape() + c3.getShape();
    
    return quantitySum % 3 == 0 && colorSum % 3 == 0 &&
      shadingSum % 3 == 0 && shapeSum % 3 == 0;
  }
  
  public String toString()
  {
    char colorVal;
    char shadingVal;
    char shapeVal;
    
    if(color == 1)
      colorVal = 'R';
    else if(color == 2)
      colorVal = 'G';
    else
      colorVal = 'P';
    
    if(shading == 1)
      shadingVal = 'O';
    else if(shading == 2)
      shadingVal = 'T';
    else
      shadingVal = 'S';
    
    if(shape == 1)
      shapeVal = 'O';
    else if(shape == 2)
      shapeVal = 'D';
    else
      shapeVal = 'S';
    
    return "" + quantity + colorVal + shadingVal + shapeVal;
  }
  
  public boolean equals(Object obj)
  {
    Card that = (Card)obj;
    
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
}