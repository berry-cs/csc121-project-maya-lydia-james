import processing.core.PApplet;

public interface IFalling {
	
	
	
	/** display on the PApplet canvas */

    public PApplet draw(PApplet c);
    
    /** get loc */
    
    public Posn getLoc();

}


