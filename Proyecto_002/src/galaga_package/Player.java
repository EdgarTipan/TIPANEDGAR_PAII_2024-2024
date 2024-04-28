package galaga_package;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player implements Drawable, Shootable, Movable {

	private int posX, posY, height, width;
	private List<Bullet> bullets = new ArrayList<>();

	public Player(int x, int y, int h, int w) {
		this.posX = x;
		this.posY = y;
		this.height = h;
		this.width = w;
	}

	@Override
	public void draw(Graphics g) {
		int[] xPoints = { posX, posX + width, posX - width };
		int[] yPoints = { posY, posY + height, posY + height };
		g.setColor(Color.CYAN.brighter());
		g.fillPolygon(xPoints, yPoints, 3);
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
	public void shoot() {
		bullets.add(new Bullet(posX - 3, posY, height / 5, width / 2, 10));
	}

	public void updateBullets() {
		for (Bullet bullets : bullets) {
			bullets.move("UP");
		}
	}

	public List<Bullet> getBullets() {
		return bullets;
	}

	@Override
	public void move(String dir) {
		switch (dir) {
		case "UP":
			if (posY > 0) {
				posY -= 15;
			}
			break;

		case "DOWN":
			if (posY < 500) {
				posY += 15;
			}
			break;

		case "LEFT":
			if (posX > 50) {
				posX -= 15;
			}
			break;

		case "RIGHT":
			if (posX < 620) {
				posX += 15;
			}
			break;

		}
	}

	public void reset(int resX, int resY) {
		this.posX = resX;
		this.posY = resY;
	}

}
