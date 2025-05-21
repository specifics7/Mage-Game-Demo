/* This will handle the "Hot Key" system. */

package Main;

import logic.Control;
import timer.stopWatchX;
import Data.BoundingBox;

public class KeyProcessor{
	// Static Fields
	private static char last = ' ';			// For debouncing purposes
	private static stopWatchX sw = new stopWatchX(250);
	
	private static stopWatchX timer = new stopWatchX(50);
	private static int frame;
	
	// Static Method(s)
	public static void processKey(char key){
		if(key == ' ')				return;
		// Debounce routine below...
		if(key == last)
			if(sw.isTimeUp() == false)			return;
		last = key;
		sw.resetWatch();
		
		/* TODO: You can modify values below here! */
		switch(key){
		case '%':								// ESC key
			System.exit(0);
			break;
			
		case 'w':
			Main.trigger = "";
			if (timer.isTimeUp()) {
				Main.preCoord.setCoords(Main.mageSprite.getCoords().getX(), Main.mageSprite.getCoords().getY());
				Main.mageSprite.getCoords().adjustY(-25);
				Main.mageSprite.setTag("mU" + frame); 
				frame++;
				if (frame > 4){
					frame = 0;
				}
			}
			timer.resetWatch();
			break;
			
		case 's':
			Main.trigger = "";
			if (timer.isTimeUp()) {
				Main.preCoord.setCoords(Main.mageSprite.getCoords().getX(), Main.mageSprite.getCoords().getY());
				Main.mageSprite.getCoords().adjustY(25);
				Main.mageSprite.setTag("mD" + frame); 
				frame++;
				if (frame > 4){
					frame = 0;
				}
			}
			timer.resetWatch();
			break;
			
		case 'a':
			Main.trigger = "";
			if (timer.isTimeUp()) {
				Main.preCoord.setCoords(Main.mageSprite.getCoords().getX(), Main.mageSprite.getCoords().getY());
				Main.mageSprite.getCoords().adjustX(-25);
				Main.mageSprite.setTag("mL" + frame); 
				frame++;
				if (frame > 4){
					frame = 0;
				}
			}
			timer.resetWatch();
			break;
			
		case 'd':
			Main.trigger = "";
			if (timer.isTimeUp()) {
				Main.preCoord.setCoords(Main.mageSprite.getCoords().getX(), Main.mageSprite.getCoords().getY());
				Main.mageSprite.getCoords().adjustX(25);
				Main.mageSprite.setTag("mR" + frame); 
				frame++;
				if (frame > 4){
					frame = 0;
				}
			}
			timer.resetWatch();
			break;
			
		case '$':
			if (BoundingBox.isCollide(Main.mageBox, Main.textSign)) {
				Main.trigger = "I am Ted the talking sign, howdy!";
			}
			if (BoundingBox.isCollide(Main.mageBox, Main.textBarrel)) {
				Main.trigger = "You found some old cheese inside the barrel....";
			}
			break;
		
		case 'm':
			// For mouse coordinates
			Control.isMouseCoordsDisplayed = !Control.isMouseCoordsDisplayed;
			break;
		}
	}
}