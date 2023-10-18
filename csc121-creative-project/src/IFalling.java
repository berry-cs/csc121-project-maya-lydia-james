import processing.core.PApplet;

public interface IFalling {
	
	
	
	/** display on the PApplet canvas */

    public PApplet draw(PApplet c);
    
    /** get loc */
    
    public Posn getLoc();
    
    /** get type*/
    public char getType();
    
    /** makes the IFalling fall by one space */
    public IFalling fall();
    
  
    /**randomly decides whether to start another IFalling*/
    public IFalling drop();
    
  /**returns 1 if IFalling is a Fruit and 0 otherwise*/
  	public int newScore(Basket b);
  	
  	 /**returns 1 if IFalling is a Bomb and 0 otherwise*/
  	public int newLives(Basket b);
}


