
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
        c.circle(random(0, width), this.loc.getY(), 20);
        return c;
    }
}
}
