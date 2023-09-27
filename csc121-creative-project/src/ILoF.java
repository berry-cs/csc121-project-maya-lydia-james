import java.util.Random;

import processing.core.PApplet;

public interface ILoF {
	/** display on the PApplet canvas */
	public PApplet draw(PApplet c);

	// creates a new list of falling things based on location of basket
	public ILoF updates(Basket b);

	//returns the new score after the whole list has been resolved
	public int newScore(Basket b);


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

	// creates a new list of falling things based on location of basket
	public ILoF updates(Basket b) {
		return this;
		/*
    	Random rand = new Random();
    	if(this.first.getLoc().inRange(b.loc, 30, 10)) {
    		return new ConsLoF (new Fruit(new Posn(rand.nextInt(400) , 0)), this.rest.updates(b));
    		return new ConsLoF (new Bomb(new Posn(rand.nextInt(400) , 0)), this.rest.updates(b));

    	}
    	else if (this.first.getLoc().getY() < 400) {
            return new ConsLoF(new Fruit(new Posn(this.first.getLoc().getX(), this.first.getLoc().getY()+1)), this.rest.updates(b));
            return new ConsLoF(new Fruit(new Posn(this.first.getLoc().getX(), this.first.getLoc().getY()+0.5)), this.rest.updates(b));
        } else {
            return new ConsLoF (new Fruit(new Posn(rand.nextInt(400) , 0)), this.rest.updates(b));
            return new ConsLoF (new Bomb(new Posn(rand.nextInt(400) , 0)), this.rest.updates(b));
        }
		 */
	}

	//returns the new score after the whole list has been resolved
	public int newScore(Basket b) {
		return 0;
		/*
    	if(this.first.getLoc().inRange(b.loc, 30, 10)) {
    		return 1+ this.rest.newScore(b);
    	}
    	else {
    		return this.rest.newScore(b);
    	}
		 */
	}


	//returns the new lives after the whole list has been resolved
	public int newLife(Basket b) {
		return 0; 
		/*
		if(this.first.Bomb.getLoc().inRange(b.loc, 30, 10)) {
			return (5- this.rest.newScore(b)) && (1- this.rest.newLife(b));
		}
		else {
			return this.rest.newScore(b);
		}
		*/
	}
}
