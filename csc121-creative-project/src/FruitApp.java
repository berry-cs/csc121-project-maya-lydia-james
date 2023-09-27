import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class FruitApp extends PApplet {
    FruitWorld w;
    
    public void settings() {
        this.size(400, 400);
    }
    
    // added bomb to 0,0 to stay there until implemented ??
    public void setup() {
        w = new FruitWorld(new Basket(new Posn(200, 350)), new ConsLoF(new Fruit(new Posn(200, 0)), new MTLoF()), 0, 0);
    }
    
    public void draw() {
        w = w.update();
        w.draw(this);
    }
    
    
    public void keyPressed(KeyEvent kev) {
        w = w.keyPressed(kev);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "FruitApp" }, new FruitApp());
    }
}