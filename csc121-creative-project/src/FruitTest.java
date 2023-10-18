import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FruitTest {

	Posn a = new Posn(0, 0);
	Posn b = new Posn (100, 100);
	Posn c = new Posn (150, 200);
	Posn d = new Posn (200, 200);
	Posn e = new Posn (300, 400);
	IFalling fruit = new Fruit(e);


	
	@Test
	public void testFallingUpdate() {
        ILoF list = new ConsLoF(new Fruit(new Posn(200, 0)), new ConsLoF(new Bomb(new Posn(124, 78)), new MTLoF()));
        Basket b = new Basket(new Posn(200, 350));
        
        assertEquals(new ConsLoF(new Fruit(new Posn(200, 1)), new ConsLoF(new Bomb(new Posn(124, 79)), new MTLoF()))     ,  
        			list.updates(b));
	}
	

	@Test
	public void testFallingUpdateBelowBasket() {
        ILoF list = new ConsLoF(new Fruit(new Posn(100, 361)), new ConsLoF(new Bomb(new Posn(124, 78)), new MTLoF()));
        Basket b = new Basket(new Posn(200, 350));
        
        assertEquals(new ConsLoF(new Bomb(new Posn(124, 79)), new MTLoF())    ,  
        			list.updates(b));
	}

	
	
	@Test 
	public void testPosn() {
		
		assertEquals(0, a.getX());
		assertEquals(100, b.getX());
		assertEquals(150, c.getX());
		assertEquals(200, d.getX());
		assertEquals(300, e.getX());
		
		assertEquals(0, a.getY());
		assertEquals(100, b.getY());
		assertEquals(200, c.getY());
		assertEquals(200, d.getY());
		assertEquals(400, e.getY());
		
		// drawLineTo ??
		
		assertEquals(0, a.distanceTo(a));
		assertEquals(141.4213562373095, a.distanceTo(b));
		assertEquals(250, a.distanceTo(c));
		assertEquals(282.842712474619, a.distanceTo(d));
		assertEquals(0, b.distanceTo(b));
		assertEquals(141.4213562373095, b.distanceTo(a));
		assertEquals(111.80339887498948, b.distanceTo(c));
		assertEquals(141.4213562373095, b.distanceTo(d));
		assertEquals(0, c.distanceTo(c));
		assertEquals(250, c.distanceTo(a)); 
		assertEquals(111.80339887498948, c.distanceTo(b));
		assertEquals(50, c.distanceTo(d));
		assertEquals(0, d.distanceTo(d));
		assertEquals(282.842712474619, d.distanceTo(a));
		assertEquals(141.4213562373095, d.distanceTo(b));
		assertEquals(50, d.distanceTo(c));
		
		assertEquals(new Posn(0, 0), a.scale(0));
		assertEquals(new Posn(0, 0), a.scale(1));
		assertEquals(new Posn(0, 0), a.scale(5));
		assertEquals(new Posn(0, 0), a.scale(10));
		assertEquals(new Posn(0, 0), b.scale(0));
		assertEquals(new Posn(100, 100), b.scale(1));
		assertEquals(new Posn(500, 500), b.scale(5));
		assertEquals(new Posn(1000, 1000), b.scale(10));
		assertEquals(new Posn(0, 0), c.scale(0));
		assertEquals(new Posn(150, 200), c.scale(1));
		assertEquals(new Posn(750, 1000), c.scale(5));
		assertEquals(new Posn(1500, 2000), c.scale(10));
		assertEquals(new Posn(0, 0), d.scale(0));
		assertEquals(new Posn(200, 200), d.scale(1));
		assertEquals(new Posn(1000, 1000), d.scale(5));
		assertEquals(new Posn(2000, 2000), d.scale(10));
		assertEquals(new Posn(0, 0), e.scale(0));
		assertEquals(new Posn(300, 400), e.scale(1));
		assertEquals(new Posn(1500, 2000), e.scale(5));
		assertEquals(new Posn(3000, 4000), e.scale(10));
		
		assertEquals(new Posn(10, 20), a.translate(new Posn(10,20))); 
		assertEquals(new Posn(100, 100), a.translate(b));
		assertEquals(new Posn(50, 70), b.translate(new Posn(-50, -30)));
		assertEquals(new Posn(250, 300), b.translate(c)); 
		assertEquals(new Posn(230, 520), c.translate(new Posn(80, 320)));
		assertEquals(new Posn(350, 400), c.translate(d));
		assertEquals(new Posn(201, 202), d.translate(new Posn(1,2))); 
		assertEquals(new Posn(500, 600), d.translate(e)); 
		assertEquals(new Posn(297, 391), e.translate(new Posn(-3, -9))); 
		assertEquals(new Posn(300, 400), e.translate(a));
		
		assertEquals(new Posn(0, 0), a.diff(a));
		assertEquals(new Posn(100, 100), a.diff(b));
		assertEquals(new Posn(-100, -100), b.diff(a));
		assertEquals(new Posn(50, 100), b.diff(c));
		assertEquals(new Posn(50, 0), c.diff(d));
		assertEquals(new Posn(-50, 0), d.diff(c));
		assertEquals(new Posn(-300, -400), e.diff(a));
		assertEquals(new Posn(0, 0), e.diff(e));

	}
	
FallingThings ft = new FallingThings();
    
    @Test
    void testFruit() {
        IFalling[] array = ft.getThings();
        assertEquals(new Fruit(new Posn(200, 0)), array[0]);
        
        ft.fall();
        array = ft.getThings();  // get updated array
        assertEquals(new Fruit(new Posn(200, 1)), array[0]);
        
        ft.belowBasket();
        array = ft.getThings();  // get updated array
        assertEquals(new Fruit(new Posn(200, 1)), array[0]);
        
    }
	
	
	
	@Test 
	public void testBomb() {
		
		
	}
	
	@Test
	public void testBasket() {
				
		
	}
	
	@Test 
	public void testFruitWorld() {
	
		
	}
	
	
	
	
	

}
