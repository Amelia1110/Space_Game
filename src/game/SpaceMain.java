package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SpaceMain implements ActionListener {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SpaceMain();
			}
		});
	}
	
	//graphics related
	static int panW = 900;
	static int panH = 600;	
	DrawingPanel panel;
	
	//game objects
	SpaceShip player = new SpaceShip();
	Timer mainTimer = new Timer(10, this);
	BetterKeyListener bKeyL = new BetterKeyListener(); 
	
	SpaceMain(){
		panel = new DrawingPanel();
		
		JFrame window = new JFrame("Best Space Game");
		window.add(panel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		mainTimer.start();
	}
	
	class DrawingPanel extends JPanel {
		
		DrawingPanel(){
			this.setBackground(Color.BLACK);
			this.setPreferredSize(new Dimension(panW, panH));
			this.addKeyListener(bKeyL);
			this.setFocusable(true); //needed for Jpanel & keys
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if (player.img != null) {
				g.drawImage(player.img,player.x, player.y, null);
			} else {
				g.setColor(player.clr);
				g.fillRect(player.x,  player.y,  player.width, player.height);
			}
		}

		
	} //end of DrawingPanel class
	
	
	/*** for mainTimer ***/
	@Override
	public void actionPerformed(ActionEvent e) {
		//move ship (assuming that a key has been pressed)
		
		if (bKeyL.isKeyDown('A') || bKeyL.isKeyDown(37)) player.move('A');
		if (bKeyL.isKeyDown('W') || bKeyL.isKeyDown(38)) player.move('W');
		if (bKeyL.isKeyDown('D') || bKeyL.isKeyDown(39)) player.move('D');
		if (bKeyL.isKeyDown('S') || bKeyL.isKeyDown(40)) player.move('S');
		
		
		panel.repaint();
	}
}