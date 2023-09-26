
import java.util.Objects;

import processing.core.PApplet; 

public class Bomb implements IFalling{

Posn loc;

    public Bomb(Posn loc) {
        this.loc = loc;
    }



    /** display on the PApplet canvas */

    public PApplet draw(PApplet c) {
    	
        c.noStroke();  // no outline
        c.fill(0, 0, 0); // (R, G, B) = "red"
        c.circle(this.loc.getX(), this.loc.getY(), 10);
        return c; 
    }
    
/** get loc */
    
    public Posn getLoc() {
    	return this.loc;
    }




	

}
