package galaga_package;

import java.awt.Color;
import java.awt.Graphics;


public class Bullet implements Drawable, Movable, Collidable {

	private int posX, posY, height, width, speed;

	public Bullet(int x, int y, int h, int w, int s) {
		this.posX = x;
		this.posY = y;
		this.height = h;
		this.width = w;
		this.speed = s;
	}

	public int getY() {
		return posY;
	}

	public int getX() {
		return posX;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(posX, posY, height, width);
	}

	@Override
	public void move(String direction) {
		switch (direction) {

		case "UP":
			if (posY > -15) {
				posY -= speed;
			}
			break;
		}
	}

	@Override
	public void onCollision() {
		speed = 0;
	}

}
