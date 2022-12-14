package game;

import java.awt.Color;
import java.awt.Rectangle;

class SpaceShip extends Rectangle {
	// Note: x, y, width, height (all ints) come from Rectangle

	double xx, yy; //double versions of x, y for precise moving
	double vx, vy;
	Color clr = Color.GREEN; // TODO: make the enemy one a different colour
	
	SpaceShip() {
		xx = 3.5;
		yy = 3.5;
		
		x = (int) xx;
		y = (int) yy;
		width = 50;
		height = 30;
	}
}