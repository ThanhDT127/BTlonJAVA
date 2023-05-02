package Main;


import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Panel.GamePanel;

public class View extends JFrame {
	private GamePanel panel;
	public View() {
		ImageIcon imageIcon = new ImageIcon("image/tiles/icon.jpg");
		panel = new GamePanel();
		this.setIconImage(imageIcon.getImage());
		this.setTitle("MINI FARM");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(panel);
		this.pack(); 
		this.setLocationRelativeTo(null);
		panel.setupGame();
		panel.startThread();
		this.setVisible(true);
	}
}
