import java.util.Objects; 

import processing.core.*;


public class Fruit implements IFalling {

Posn loc;
    
    public Fruit(Posn loc) {
        this.loc = loc;
    }

    /** display on the PApplet canvas */
    public PApplet draw(PApplet c) {
        c.noStroke();  // no outline
        c.fill(255, 0, 0); // (R, G, B) = "red"
        c.circle(this.loc.getX(), this.loc.getY(), 10);
        return c; 
    }
}