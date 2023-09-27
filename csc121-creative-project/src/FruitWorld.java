import processing.core.PApplet;

import processing.event.KeyEvent;

import java.util.Random;





/**
 * Represents a game where the player is supposed to control a basket to catch fruit
 * by using the Right and Left arrow keys. 
 */
public class FruitWorld {
Basket b;
ILoF falling;
int score;
int lives;
    

FruitWorld(Basket b, ILoF falling, int score, int lives) {
	this.b = b;
	this.falling = falling;
	this.score = score;
    this.lives = lives;
}



/** produce an image of the state of this animation on given canvas */
public PApplet draw(PApplet c) {
	c.background(255);
	c.text("" + score, 20, 20);
    c.text("" + lives, 380, 20);
    this.b.draw(c);
    this.falling.draw(c);
    return c;
}
    
   

    /**
     * Produces an updated world where the fruit moves
     * down a little bit, if it hasn't hit the bottom
     * of the screen yet. If is has hit the bottom of 
     * the screen, a new fruit appears at the top of 
     * the screen in a random location. 
     */


// add bomb instance to update method

    public FruitWorld update() {
    	return new FruitWorld(this.b, this.falling.updates(b), this.score +this.falling.newScore(b), this.lives); //+this.falling.newLives(b));
    }
    
/** moves the basket in response to Keys*/

   // add bomb instance to keyPressed method
    
public FruitWorld keyPressed(KeyEvent kev) {
   if (kev.getKeyCode() == PApplet.LEFT) {
        return new FruitWorld(new Basket(this.b.loc.translate(new Posn(-10, 0))), this.falling, this.score, this.lives);
    } else if (kev.getKeyCode() == PApplet.RIGHT) {
        return new FruitWorld(new Basket (this.b.loc.translate(new Posn(10, 0))), this.falling, this.score, this.lives);
    } else {
        return this;
    }
}
}