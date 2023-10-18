
import java.util.Random;

import processing.core.PApplet; 

public class Nothing implements IFalling{

    public Nothing () {
        
        
    }

    /** display on the PApplet canvas */
    public PApplet draw(PApplet c) {
        return c;
    }
    
    /** get type*/
    public char getType() {
    	return 'N';
    }


    @Override
    public Posn getLoc() {
        return new Posn(0,0);
    }
    
    /** makes the IFalling fall by one space */
    public IFalling fall() {
    	return this;
    }
    
    /**randomly decides whether to start another IFalling*/
    public IFalling drop() {
    	Random rand= new Random();
    	Random rand2 =new Random();
		if (rand2.nextDouble()>.995) {
		if (this.fruitOrBomb()) {
			return new Fruit (new Posn(rand.nextInt(400) , 0));
		} else {
			return new Bomb (new Posn(rand.nextInt(400) , 0));
		}
		} else {
			return this;
		}
    }
    
    /**returns 1 if IFalling is a Fruit and 0 otherwise*/
  	public int newScore(Basket b) {
  		return 0;
  	}
  	
	/**returns 1 if IFalling is a Bomb and 0 otherwise*/
  	public int newLives(Basket b) {
  		return 0;
  	}
    
  //randomly decides whether the new IFalling is a Fruit or Bomb
  		public boolean fruitOrBomb() {
  			Random rand=new Random();
  			return rand.nextDouble()> .3;
  		}

	
}