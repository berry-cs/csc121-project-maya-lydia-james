
import java.util.Objects;

import processing.core.PApplet; 

public class Bomb implements IFalling{

Posn loc;
char type;
    public Bomb(Posn loc) {
        this.loc = loc;
        this.type = 'b';
        
    }

    /** display on the PApplet canvas */
    public PApplet draw(PApplet c) {
        c.noStroke();  // no outline
        c.fill(0, 0, 0); // (R, G, B) = "red"
        c.circle(this.loc.getX(), this.loc.getY(), 20);
        return c;
    }
    
    /** get type*/
    public char getType() {
    	return this.type;
    }
    
    /** makes the IFalling fall by one space */
    public IFalling fall() {
    	return new Bomb(new Posn(this.getLoc().getX(), this.getLoc().getY()+1));
    }
    
    /**randomly decides whether to start another IFalling*/
    public IFalling drop() {
    	return this;
    }
    
    /**returns 1 if IFalling is a Fruit and 0 otherwise*/
  	public int newScore(Basket b) {
  		return 0;
  	}
  	
	/**returns 1 if IFalling is a Bomb and 0 otherwise*/
  	public int newLives(Basket b) {
  		return 1;
  	}


    @Override
    public Posn getLoc() {
        return this.loc;
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
		Bomb other = (Bomb) obj;
		return Objects.equals(loc, other.loc);
	}

	@Override
	public String toString() {
		return "Bomb [loc=" + loc + "]";
	}
}