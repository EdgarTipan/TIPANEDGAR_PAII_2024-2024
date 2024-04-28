package galaga_package;

import javax.swing.JFrame;

public class Panel extends JFrame {

	private static final long serialVersionUID = 1L;

	public void window() {
		setTitle("Galaga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(270, 100);
		setSize(800, 600);

		GamePanel my = new GamePanel();
		add(my);

		setVisible(true);
	}

}
