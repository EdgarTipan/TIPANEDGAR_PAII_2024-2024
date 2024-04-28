package galaga_package;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Enemy implements Drawable, Movable, Shootable, Collidable {

	private int posX, posY, height, width, speed;
	private List<Bullet> bullets = new ArrayList<>();

	public Enemy(int x, int y, int h, int w, int s) {
		this.posX = x;
		this.posY = y;
		this.height = h;
		this.width = w;
		this.speed = s;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GREEN.brighter());
		g.fillRect(posX, posY, width, height);
	}

	public int getX() {
		return posX;
	}

	public int getY() {
		return posY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public void move(String dir) {

		switch (dir) {
		case "DOWN":
			if (posY < 300) {
				posY += speed;
			}
			break;
		}
	}

	@Override
	public void shoot() {
		bullets.add(new Bullet(posX, posY, height, width, 15));
	}

	public void updateBullets() {
		for (Bullet bullets : bullets) {
			bullets.move("DOWN");
		}
	}

	public List<Bullet> getBullets() {
		return bullets;
	}

	@Override
	public void onCollision() {
		posY = -100;
		speed = 0;
	}

	public static List<Enemy> createHorde(int numEnemies, int startX, int startY, int spacing) {
		List<Enemy> horde = new ArrayList<>();
		for (int i = 0; i < numEnemies; i++) {
			int enemyX = startX + i * spacing;
			int enemyY = startY;
			Enemy enemy = new Enemy(enemyX, enemyY, 40, 40, 1);
			horde.add(enemy);
		}
		return horde;
	}

}
