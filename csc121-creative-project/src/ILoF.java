import java.util.Objects;
import java.util.Random;

import processing.core.PApplet;

public interface ILoF {
	/** display on the PApplet canvas */
	public PApplet draw(PApplet c);

	// creates a new list of falling things based on location of basket
	public ILoF updates(Basket b);

	//returns the new score after the whole list has been resolved
	public int newScore(Basket b);
	
	//makes everything on the list fall by one space
			public ILoF fall();
			
    // removes anything from the list that is below the basket 
			public ILoF belowBasket();
	
	//removes anything from the list that has collided with the basket
			public ILoF collided(Basket b);
	

}

class MTLoF implements ILoF {

	public MTLoF() {}

	/** display on the PApplet canvas */

	public PApplet draw(PApplet c) {
		return c;
	}
	// creates a new list of falling things based on location of basket
	public ILoF updates(Basket b) {
		return new MTLoF();
	}

	//returns the new score after the whole list has been resolved
	public int newScore(Basket b) {
		return 0;
	}
	
	//makes everything on the list fall by one space
			public ILoF fall() {
				return this;
			}
			// removes anything from the list that is below the basket 
						public ILoF belowBasket() {
							return this;
						}
						
        //removes anything from the list that has collided with the basket
			public ILoF collided(Basket b) {
				return this;
			}
	


	// auto-generated methods

	@Override
	public boolean equals(Object other) {
		return other instanceof MTLoF;
	}

	@Override
	public int hashCode() {
		return MTLoF.class.hashCode();
	}
}

class ConsLoF implements ILoF{
	IFalling first;
	ILoF rest;

	public ConsLoF(IFalling first, ILoF rest) {
		this.first = first;
		this.rest = rest;
	}
	/** display on the PApplet canvas */

	public PApplet draw(PApplet c) {
		first.draw(c);
		rest.draw(c);
		return c;
	}
	
	//makes everything on the list fall by one space
		public ILoF fall() {
			if (this.first.getType()=='f') {
				return new ConsLoF(new Fruit(new Posn(this.first.getLoc().getX(), this.first.getLoc().getY()+1)), this.rest.fall());
			} else {
				return new ConsLoF(new Bomb(new Posn(this.first.getLoc().getX(), this.first.getLoc().getY()+1)), this.rest.fall());	
			}
		}
     // removes anything from the list that is below the basket 
		public ILoF belowBasket() {
			if (this.first.getLoc().getY() < 350) {
				return this.rest.belowBasket();
			} else {
				return new ConsLoF(this.first, this.rest.belowBasket());
			}
		}	
		
		
		//removes anything from the list that has collided with the basket
		public ILoF collided(Basket b) {
			if(this.first.getLoc().inRange(b.loc, 30, 10)) {
				return this.rest.collided(b);
			} else {
				return new ConsLoF (this.first, this.rest.collided(b));
			}
		}
		
		

	
	/* 
	 * TODO:
	 *    1. make everything in the list fall a little at a time
	 *    2. after anything in the list gets below the basket, remove it from the list
	 *    3. detect collisions with the basket, remove from the list also
	 */
	
	// creates a new list of falling things based on location of basket
	public ILoF updates(Basket b) {
		
    	Random rand = new Random();
    if (this.first.getType()== 'f') {
    	if(this.first.getLoc().inRange(b.loc, 30, 10)) {
    		return new ConsLoF (new Fruit (new Posn(rand.nextInt(400) , 0)), this.rest.updates(b));

    	}
    	else if (this.first.getLoc().getY() < 350) {
            return new ConsLoF(new Fruit(new Posn(this.first.getLoc().getX(), this.first.getLoc().getY()+1)), this.rest.updates(b));
        } else {
            return new ConsLoF (new Fruit(new Posn(rand.nextInt(400) , 0)), this.rest.updates(b));
        }
    } else {
    	if(this.first.getLoc().inRange(b.loc, 30, 10)) {
    		return new ConsLoF (new Bomb (new Posn(rand.nextInt(400) , 0)), this.rest.updates(b));

    	}
    	else if (this.first.getLoc().getY() < 350) {
            return new ConsLoF(new Bomb(new Posn(this.first.getLoc().getX(), this.first.getLoc().getY()+1)), this.rest.updates(b));
        } else {
            return new ConsLoF (new Bomb(new Posn(rand.nextInt(400) , 0)), this.rest.updates(b));
        }
    	
    }
    	} 
		 
 

	//returns the new score after the whole list has been resolved
	public int newScore(Basket b) {
		if (this.first.getType()=='f') {
    	if(this.first.getLoc().inRange(b.loc, 30, 10)) {
    		return 1+ this.rest.newScore(b);
    	}
    	else {
    		return this.rest.newScore(b);
    	}
		} else 
		{ return 0;
	
		}
	}


	//returns the new lives after the whole list has been resolved
	//public int newLife(Basket b) {
		/*if (this.first.getType()=='b') {
		if(this.first.getLoc().inRange(b.loc, 30, 10)) {
			return 1+ this.rest.newLife(b);
		}
		else {
			return this.rest.newLife(b);
		}
		} else {
			return 0;
		}
		
	}*/

	@Override
	public int hashCode() {
		return Objects.hash(first, rest);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsLoF other = (ConsLoF) obj;
		return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
	}
	@Override
	public String toString() {
		return "ConsLoF [first=" + first + ", rest=" + rest + "]";
	}
}