import processing.core.PApplet;

import processing.event.KeyEvent;

import java.util.Random;





/**
 * Represents a game where the player is supposed to control a basket to catch fruit
 * by using the Right and Left arrow keys. 
 */
public class FruitWorld {
Fruit f;
Basket b;
    

FruitWorld(Fruit f, Basket b) {
	this.f = f;
	this.b = b;
}



/** produce an image of the state of this animation on given canvas */
public PApplet draw(PApplet c) {
	c.background(255);
    this.f.draw(c);
    this.b.draw(c);
    return c;
}
    
   

    /**
     * Produces an updated world where the fruit moves
     * down a little bit, if it hasn't hit the bottom
     * of the screen yet. If is has hit the bottom of 
     * the screen, a new fruit appears at the top of 
     * the screen in a random location. 
     */
    public FruitWorld update() {
    	Random rand = new Random();
        if (this.f.loc.getY() < 400) {
            return new FruitWorld(new Fruit(new Posn(this.f.loc.getX(), this.f.loc.getY()+1)), this.b);
        } else {
            return new FruitWorld (new Fruit(new Posn(rand.nextInt(400) , 0)), this.b);
        }
    }
    
/** moves the basket in response to Keys*/

public FruitWorld keyPressed(KeyEvent kev) {
   if (kev.getKeyCode() == PApplet.LEFT) {
        return new FruitWorld(this.f, new Basket(this.b.loc.translate(new Posn(-10, 0))));
    } else if (kev.getKeyCode() == PApplet.RIGHT) {
        return new FruitWorld(this.f, new Basket (this.b.loc.translate(new Posn(10, 0))));
    } else {
        return this;
    }
}
}