

import java.util.Arrays;

import processing.core.PApplet;

/** Represents 24 hourly temperature readings */
public class FallingThings {
    private IFalling[] things;
    
    public FallingThings() {
        this.things = new IFalling[3];
        
        this.things[0]=new Fruit(new Posn(200, 0));
        this.things[1]= new Nothing();
        this.things[2]= new Nothing();
    }
//auto-generated methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(things);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FallingThings other = (FallingThings) obj;
		return Arrays.equals(things, other.things);
	}
	
	IFalling[] getThings() { 
        return this.things;
    }
	/** display on the PApplet canvas */

	public PApplet draw(PApplet c) {
		int i=0;
		while (i<3) {
			this.things[i].draw(c);
			i=i+1;
		}
		return c;
	}
	
	//makes everything on the list fall by one space
		public FallingThings fall() {
			int i=0;
			while (i<3) {
				this.things[i]=this.things[i].fall();
				i=i+1;
			}
			return this;
		}
		
     // removes anything from the list that is below the basket 
		public FallingThings belowBasket() {
			int i=0;
			while (i<3) {
				if(this.things[i].getLoc().getY() > 360) {
					this.things[i]= new Nothing();
				} 
				i=i+1;
			}
			return this;
			
		}	
		
		
		//removes anything from the list that has collided with the basket
		public FallingThings collided(Basket b) {
			int i=0;
			while (i<3) {
				if(this.things[i].getLoc().inRange(b.loc, 30, 10)) {
					this.things[i]= new Nothing();
				} 
				i=i+1;
			}
			return this;
			
		}	
		
		
		
			
		
		
		//randomly decides whether to start another IFalling
		public FallingThings drop(Basket b) {
			int i=0;
			while(i<3) {
				this.things[i]=this.things[i].drop();
				i=i+1;
			}
			return this.updates(b);
		}

	
	// creates a new list of falling things based on location of basket
	public FallingThings updates(Basket b) {
		return this.fall().belowBasket().collided(b);
		/*if (this.first.getType()== 'f') {
    	if(this.first.getLoc().inRange(b.loc, 30, 10)) {
    		return this.rest.updates(b);

    	}
    	else if (this.first.getLoc().getY() < 360) {
            return new ConsLoF(new Fruit(new Posn(this.first.getLoc().getX(), this.first.getLoc().getY()+1)), this.rest.updates(b));
        } else {
            return this.rest.updates(b);
        }
    } else {
    	if(this.first.getLoc().inRange(b.loc, 30, 10)) {
    		return this.rest.updates(b);

    	}
    	else if (this.first.getLoc().getY() < 360) {
            return new ConsLoF(new Bomb(new Posn(this.first.getLoc().getX(), this.first.getLoc().getY()+1)), this.rest.updates(b));
        } else {
            return this.rest.updates(b);
        }
    	
    }*/
    	} 
		 
 

	//returns the new score after the whole list has been resolved
	public int newScore(Basket b) {
		int i=0;
		int score =0;
		
		while(i<3) {
			score = score+this.things[i].newScore(b);
			i=i+1;
		}
		return score;
	}


	//returns the new lives after the whole list has been resolved
	public int newLife(Basket b) {
		int i=0;
		int lives =0;
		
		while(i<3) {
			lives = lives+this.things[i].newLives(b);
			i=i+1;
		}
		return lives;
	}


    }
    