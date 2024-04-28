package galaga_package;

import java.awt.Graphics;

public class Container {
	
	public void draw(Drawable d, Graphics g) {
		d.draw(g);		
	}
	
	public void move(Movable m,String direction) {
        m.move(direction);
    }
	
	public void shoot(Shootable s) {
		s.shoot();
	}
	
	public void collide(Collidable c) {
		c.onCollision();
	}

}
