package Main;

import java.awt.Color;
import logic.Control;
import java.util.ArrayList;
import Data.Vector2D;
import Data.spriteInfo;
import Data.BoundingBox;

public class Main{
	// Fields (Static) below...
	public static Color c = new Color(128, 0, 32);
	public static String trigger = "";
	
	public static Vector2D curVec = new Vector2D(950, 500);
	public static Vector2D preVec = new Vector2D(0, 0);
	
	public static spriteInfo mageSprite = new spriteInfo(curVec, "mD" + 0);
	public static spriteInfo preCoord = new spriteInfo (preVec, mageSprite.getTag());
	public static spriteInfo background = new spriteInfo(new Vector2D(0, 0), "background");
	
	public static ArrayList<spriteInfo> spriteList = new ArrayList<>();
	public static ArrayList<BoundingBox> boxList = new ArrayList<>();
	// Corners boxes
	public static BoundingBox top = new BoundingBox(0, 1920, 0, 50);
	public static BoundingBox bottom = new BoundingBox(0, 1920, 1040, 1080);
	public static BoundingBox left = new BoundingBox(0, 25, 0, 1080);
	public static BoundingBox right = new BoundingBox(1900, 1920, 0, 1080);
	// Items boxes
	public static BoundingBox signBox = new BoundingBox(1620, 1655, 190, 280);
	public static BoundingBox textSign = new BoundingBox(1600, 1660, 185, 300);

	public static BoundingBox barrelBox = new BoundingBox(955, 1000, 725, 790);
	public static BoundingBox textBarrel = new BoundingBox(930, 1040, 700, 910);
	// Character box
	public static BoundingBox mageBox;
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	/* This is your access to things BEFORE the game loop starts */
	public static void start(){
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite or drawString)
		spriteList.add(background);
		spriteList.add(mageSprite);
		
		boxList.add(top);
		boxList.add(bottom);
		boxList.add(left);
		boxList.add(right);
		boxList.add(signBox);
		boxList.add(barrelBox);
	}
	
	/* This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))*/
	public static void update(Control ctrl) {
		
		mageBox = new BoundingBox(mageSprite, 20, 108, 108, 120); 
		
		for (int i = 0; i < boxList.size(); i++) {
			if (BoundingBox.isCollide(mageBox, boxList.get(i))) {
				boundStop();
			}
		}
		
		for (int i = 0; i < spriteList.size(); i++)	{
			ctrl.addSpriteToFrontBuffer(spriteList.get(i).getCoords().getX(), spriteList.get(i).getCoords().getY(), spriteList.get(i).getTag());
		}
		
		ctrl.drawString(mageSprite.getCoords().getX(), mageSprite.getCoords().getY(), trigger, c);
	}
	
	
	public static void boundStop() {
		if ((mageSprite.getCoords().getX() - preCoord.getCoords().getX()) != 0){
			if ((mageSprite.getCoords().getX() - preCoord.getCoords().getX()) > 0) {		
				mageSprite.getCoords().adjustX(-25);				
			}
			if ((mageSprite.getCoords().getX() - preCoord.getCoords().getX()) < 0) {
				mageSprite.getCoords().adjustX(25);
			}
		}
		
		if ((mageSprite.getCoords().getY() - preCoord.getCoords().getY()) != 0) {
			if ((mageSprite.getCoords().getY() - preCoord.getCoords().getY()) > 0) {
				mageSprite.getCoords().adjustY(-25);
			}
			if ((mageSprite.getCoords().getY() - preCoord.getCoords().getY()) < 0) {
				mageSprite.getCoords().adjustY(25);
			}
		}
	}
}
