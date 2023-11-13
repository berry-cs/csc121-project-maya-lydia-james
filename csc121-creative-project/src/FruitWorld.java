import processing.core.PApplet;

import processing.event.KeyEvent;







/**
 * Represents a game where the player is supposed to control a basket to catch fruit
 * by using the Right and Left arrow keys. Each fruit the player catches adds 1 point to their score.
 * If the player catches a bomb, however, they lose a life. 
 * Once all three lives are lost the score resets to 0 and the game restarts. 
 */
public class FruitWorld {
private Basket b;
private FallingThings falling;
private int score;
private int lives;


    

FruitWorld(Basket b, FallingThings falling, int score, int lives) {
	this.b = b;
	this.falling = falling;
	this.score = score;
    this.lives = lives;
}



/** produces the image of the game. 
 * The background is white unless a collision happens in which case it briefly turns to turquoise. 
 * The fruits are represented by small red circles while the bombs are represented by black circles. 
 * The basket is represented by a red rectangle. 
 * The score is shown in the top left corner while the lives left is in the top right corner. */
public PApplet draw(PApplet c) {
	int i=0;
	while (i<3) {
		if (this.falling.inRange(b.getLoc(), Basket.basketWidth, Basket.basketHeight)){
			c.background(0,150,125);
	} else {c.background(255);}
		i=i+1;
	}
	c.text("" + score, FruitApp.textMargin, FruitApp.textMargin);
    c.text("" + lives, FruitApp.screenWidth-FruitApp.textMargin, FruitApp.textMargin);
    this.falling.draw(c);
    c.imageMode(c.CENTER);
    c.image(c.loadImage("basket2.jpg"), this.b.getLoc().getX(), this.b.getLoc().getY(), 
    		Basket.basketWidth, Basket.basketHeight);
    return c;
}
    
   

    /**
     * Produces an updated world where the FallingThings that have either been caught or have fallen past the basket are
     * removed. The game then randomly decides whether to drop new bombs or Fruit and moves the FallingTHings already 
     * on the screen down the screen. This method also updates the score and the lives left. If there are ever no lives
     * left, this method restarts the game.  
     */

    public FruitWorld update() {
    	if (this.lives <= 0) {
    		ScoreArray highscores = new ScoreArray();
    		            highscores.loadScore();
    				if (highscores.maybeScore(this.score)<6) {
    					String name = javax.swing.JOptionPane.showInputDialog("Please enter your name:");
    					highscores.addScore(this.score, highscores.maybeScore(this.score), name);
    				}
    				highscores.saveScore();
    			return new FruitWorld(new Basket(new Posn(FruitApp.midScreen, FruitApp.screenHeight-FruitApp.basketMargin)),
    				new FallingThings(), 0, 3);
    	} else {
    		int newScore = this.falling.newScore(b);
    		int newLives= this.falling.newLife(b);
    	return 	new FruitWorld(this.b, this.falling.cleanUp(b).drop(), this.score + newScore, 
    	                   this.lives- newLives);
    	}
    }
    
/** moves the basket in response to Left and Right arrow Keys*/

   
public FruitWorld keyPressed(KeyEvent kev) {
   if (kev.getKeyCode() == PApplet.LEFT) {
        return new FruitWorld(new Basket(this.b.getLoc().translate(new Posn(-10, 0))), this.falling, this.score, this.lives);
    } else if (kev.getKeyCode() == PApplet.RIGHT) {
        return new FruitWorld(new Basket (this.b.getLoc().translate(new Posn(10, 0))), this.falling, this.score, this.lives);
    } else {
        return this;
    }
}
}