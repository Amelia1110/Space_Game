package game;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class SpaceShip extends Rectangle{
	//Note: x,y,width,height (all ints) come from Rectangle
	
	double xx, yy;  //double versions of x,y for precise moving
	double vx = 5.2;
	double vy = 6.3;
	Color clr = Color.GREEN;  //TODO: make the enemy one a different colour
	BufferedImage img;
	
	SpaceShip(){
		width = 50;
		height = 30;
		
		try {
			img = ImageIO.read(new File("krakenSM.png"));
			width = img.getWidth();
			height = img.getHeight();
		} catch (IOException e) {
			System.out.println("Warning: gitkrakenSM.png failed to load");
		}		
		
		xx = SpaceMain.panW/2 - width/2;
		yy = SpaceMain.panH - 90;
		
		x = (int) xx;
		y = (int) yy;
		
		
	}
	
	void move (int key) {
		switch (key) {
		case 'W':		
			yy -=vy; break;
		case 'S':
			yy +=vy; break;
		case 'A':
			xx -=vx; break;
		case 'D':
			xx +=vx; break;
		}
		// wrap around on the screen
		if (xx < 0 - width) xx = SpaceMain.panW;
		if (yy < 0 - height) yy = SpaceMain.panH;
		if (xx > SpaceMain.panW) xx = 0;
		if (yy > SpaceMain.panH) yy = 0;
		
		//update final positions
		x = (int)xx;
		y = (int)yy;
	}

	//Laser must be returned so that it can be added to the arraylist
	Laser shoot() {	
		//laser constructor gets the (x,y) where it should start
		Laser z = new Laser(this.x + this.width/2, this.y + 10);
		return z;
	}
	
}