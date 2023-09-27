import java.util.Objects; 

import processing.core.*;


public class Fruit implements IFalling{
	Posn loc;
	char type;


	public Fruit(Posn loc) {
		this.loc = loc;
		this.type = 'f';
		
	}	

	/** display on the PApplet canvas */
	public PApplet draw(PApplet c) {
		c.noStroke();  // no outline
		c.fill(255, 0, 0); // (R, G, B) = "red"
		c.circle(this.loc.getX(), this.loc.getY(), 10);
		return c; 
	}

	/** get loc */

	public Posn getLoc() {
		return this.loc;
	}
	
	/** get type*/
    public char getType() {
    	return this.type;
    }

	@Override
	public int hashCode() {
		return Objects.hash(loc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fruit other = (Fruit) obj;
		return Objects.equals(loc, other.loc);
	}

	@Override
	public String toString() {
		return "Fruit [loc=" + loc + "]";
	}



}