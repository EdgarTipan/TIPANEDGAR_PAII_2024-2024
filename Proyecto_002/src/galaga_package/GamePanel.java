package galaga_package;

import static java.awt.Font.PLAIN;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Player player;
	private List<Enemy> enemyHorde;
	private Container cont;
	private User user;
	private int playerInitPosX = 390;
	private int playerInitPosY = 500;
	private int userMaxHealth = 100;
	private Timer timer;
	private boolean gameActive;
	private boolean gameOver = false;

	public GamePanel() {

		setBackground(Color.BLACK);
		setFocusable(true);

		cont = new Container();
		player = new Player(playerInitPosX, playerInitPosY, 30, 30);
		user = new User(0, userMaxHealth);
		enemyHorde = Enemy.createHorde(10, 50, 50, 60); 
		event(player);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (gameOver) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("ARIAL BLACK", Font.PLAIN, 62));
			g.drawString("GAME OVER", (int) (getWidth() / 4.2f), getHeight() / 2);
		} else {
			for (Enemy enemy : enemyHorde) {
				cont.draw(enemy, g);

				Rectangle enemyRect = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());

				for (Bullet bullet : player.getBullets()) {
					cont.draw(bullet, g);
					Rectangle bulletRect = new Rectangle(bullet.getX(), bullet.getY(), bullet.getWidth(),
							bullet.getHeight());

					if (bulletRect.intersects(enemyRect)) {
						cont.collide(enemy);
						user.setScore(user.getScore() + 10);
						// user.setHealth(user.getHealth() - 10);
					}
				}

			}

			int yLinea = (int) (getHeight() * 0.66);
			g.setColor(Color.RED.brighter());
			g.drawLine(0, yLinea, getWidth(), yLinea);

			g.setColor(Color.RED.brighter());
			g.setFont(new Font("ARIAL BLACK", PLAIN, 25));
			String textScore = "SCORE";
			g.drawString(textScore, 680, 30);

			g.setColor(Color.WHITE);
			g.setFont(new Font("ARIAL BLACK", PLAIN, 30));
			String score = String.valueOf(user.getScore());
			g.drawString(score, 710, 65);

			g.setColor(Color.RED.brighter());
			g.setFont(new Font("ARIAL BLACK", PLAIN, 23));
			g.drawString("HEALTH", 670, 100);

			g.setColor(Color.CYAN.darker());
			g.drawRect(675, 113, 100, 20);

			g.setColor(Color.CYAN.brighter());
			g.fillRect(677, 115, ((user.getHealth() * 96) / userMaxHealth), 16);

			if (player.getY() > yLinea) {
				cont.draw(player, g);
			} else {
				gameOver = true;
			}
		}
	}

	public void event(Player player) {
		this.player = player;
		this.gameActive = true;

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (!gameActive) {
					return;
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.move("LEFT");
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.move("RIGHT");
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					player.move("UP");
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					player.move("DOWN");
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					player.shoot();
				}
				if (gameOver && e.getKeyCode() == KeyEvent.VK_R) {
					restartGame();
				}

				repaint();

			}
		});
		timer = new Timer(1000 / 60, e -> {
			player.updateBullets();
			moveEnemies();
			repaint();
		});
		timer.start();
	}

	private void moveEnemies() {
		for (Enemy enemy : enemyHorde) {
			enemy.move("DOWN");
		}
	}

	private void restartGame() {
		gameOver = false;
		player.reset(playerInitPosX, playerInitPosY);
		user.setScore(0);
		repaint();
	}

}
