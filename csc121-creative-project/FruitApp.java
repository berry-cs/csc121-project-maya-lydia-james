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
    
    public void setup() {
        w = new FruitWorld(new Posn(200, 0), new Posn(200, 400));
    }
    
    public void draw() {
        w = w.update();
        w.draw(this);
    }
    
    
    public void keyPressed(KeyEvent kev) {
        // w = w.keyPressed(kev);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "FruitApp" }, new FruitApp());
    }
}
