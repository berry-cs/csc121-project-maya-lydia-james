import java.util.Objects;

import processing.core.*;

import processing.core.PApplet; 


public class Basket {

Posn loc;
    
    public Basket(Posn loc) {
        this.loc = loc;
    }

    /** display on the PApplet canvas */
    public PApplet draw(PApplet c) {
        c.noStroke();  // no outline
        c.fill(255, 0, 0); // (R, G, B) = "red"
        c.rect(this.loc.getX(), this.loc.getY(), 30, 10);
        return c;
    }
}