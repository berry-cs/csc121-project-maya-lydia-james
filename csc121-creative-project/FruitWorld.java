import processing.core.PApplet;

import processing.event.MouseEvent;

import java.util.Random;





/**
 * Represents an interactive application where a drop of
 * water falls down from the top of the window. If the 
 * user clicks the mouse, the drop is moved over to the
 * location of the click;
 */
public class FruitWorld {
    // the position of the drop
    double x;
    double y;

    public FruitWorld(double x, double y) {
        this.x = x;
        this.y = y; 
    }
    
    /**
     * Renders a picture of the drop on the window
     */
    public PApplet draw(PApplet c) {
        c.background(255);
        c.text("Hello!", 20, 20);
        c.fill(0, 0, 255);
        c.circle((int)this.x, (int)this.y, 15);
        return c;
    }

    /**
     * Produces an updated world where the drop moves
     * down a little bit, if it hasn't hit the bottom
     * of the screen yet.
     */
    public FruitWorld update() {
    	Random rand = new Random();
        if (this.y < 400) {
            return new FruitWorld(this.x, this.y + .5);
        } else {
            return new FruitWorld (rand.nextInt(400) , 0);
        }
    }
    
    /**
     * Produces an updated world with the position of the
     * drop updated to the location of the mouse press.
     */
    public FruitWorld mousePressed(MouseEvent mev) {
        return new FruitWorld(mev.getX(), mev.getY());
    }
    
    /**
     * Produces a string rendering of the position of the
     * drop
     */
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
