package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SpaceMain {

	public static void main(String[] args) {
		// TODO add in the swingUtilities was of starting graphics
		new SpaceMain();
	}
	
	// Graphics related
	int panW = 900;
	int panH = 900;
	DrawingPanel panel;
	
	// Game objects
	SpaceShip player = new SpaceShip();
	
	SpaceMain() {
		panel = new DrawingPanel();
		
		JFrame window = new JFrame("Best Space Game");
		window.add(panel);
		window.pack();
		window.setVisible(true);
		//timer.start();
	}
	
	class DrawingPanel extends JPanel {
		DrawingPanel() {
			this.setBackground(Color.BLACK);
			this.setPreferredSize(new Dimension(panW, panH));
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(player.clr);
			g.fillRect(player.x, player.y, player.width, player.height);
		}
	}

}