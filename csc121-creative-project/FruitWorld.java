import processing.core.PApplet;



import java.util.Random;





/**
 * Represents a game where the player is supposed to control a basket to catch fruit
 * by using the Right and Left arrow keys. 
 */
public class FruitWorld {
    Posn fruit;
     Posn basket;

    
    FruitWorld(Posn fruit, Posn basket) {
		this.fruit = fruit;
		this.basket = basket;
	}

	
    
    /**
     * Renders a picture of the fruit and basket
     */
    public PApplet draw(PApplet c) {
        c.background(255);
        c.text("0", 20, 20);
        c.fill(0, 0, 255);
        c.circle(this.fruit.getX(),this.fruit.getY(), 15);
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
        if (this.fruit.getY() < 400) {
            return new FruitWorld(new Posn(this.fruit.getX(), this.fruit.getY()+1), this.basket);
        } else {
            return new FruitWorld (new Posn(rand.nextInt(400) , 0), this.basket);
        }
    }
    }
    
   
    
    