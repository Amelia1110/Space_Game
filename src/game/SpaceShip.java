package game;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class SpaceShip extends Rectangle {
	// Note: x, y, width, height (all ints) come from Rectangle

	double xx, yy; //double versions of x, y for precise moving
	double vx = 3.5;
	double vy = 3.5;
	Color clr = Color.GREEN; // TODO: make the enemy one a different colour
	BufferedImage img;
	
	SpaceShip() {
		try {
			img = ImageIO.read(new File("krakenSM.png"));
			width = img.getWidth();
			height = img.getHeight();
		} catch (IOException e) {
			System.out.println("Warning: gitkrakenSM.png failed to load");
		}		
		
		xx = 200.0;
		yy = 700.0;
		
		x = (int) xx;
		y = (int) yy;
		width = 50;
		height = 30;
	}
	
	void move (int key) {
		switch (key) {
		case 'W':
		case 38:
			yy -=vy; break;
		case 'S':
		case 40:
			yy +=vy; break;
		case 'A':
		case 37: // left arrow
			xx -=vx; break;
		case 'D':
		case 39:
			xx +=vx; break;
		}
		
		x = (int)xx;
		y = (int)yy;
	}
}