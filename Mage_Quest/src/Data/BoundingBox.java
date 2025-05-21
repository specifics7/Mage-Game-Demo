package Data;


public class BoundingBox {
	
	private spriteInfo spriteData;
	private int x1, x2, y1, y2;
	
	// Constructor
	public BoundingBox(int x1, int x2, int y1, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	public BoundingBox(spriteInfo newSprite){	
		spriteData = newSprite;
		x1 = spriteData.getCoords().getX();
		x2 = spriteData.getCoords().getX() + 128;
		y1 = spriteData.getCoords().getY();
		y2 = spriteData.getCoords().getY() + 128;
	}
	
	public BoundingBox(spriteInfo newSprite, int adjustX1, int adjustX2, int adjustY1, int adjustY2){	
		spriteData = newSprite;
		x1 = spriteData.getCoords().getX() + adjustX1;
		x2 = spriteData.getCoords().getX() + adjustX2;
		y1 = spriteData.getCoords().getY() + adjustY1;
		y2 = spriteData.getCoords().getY() + adjustY2;
	}
	// Getter
	public int getX1(){
		return x1;
	}
	
	public int getX2(){
		return x2;
	}
	
	public int getY1(){
		return y1;
	}
	
	public int getY2(){
		return y2;
	}
	// Setter
	public void setX1(int newX1){
		this.x1 = newX1;
	}
	
	public void setX2(int newX2){
		this.x2 = newX2;
	}
	
	public void setY1(int newY1){
		this.y1 = newY1;
	}
	
	public void setY2(int newY2){
		this.y2 = newY2;
	}
	
	public static boolean isCollide(BoundingBox box1, BoundingBox box2) {
		if (box1.getX1() > box2.getX2()) {
			return false;
		}
		else if (box1.getX2() < box2.getX1()) {
			return false;
		}
		else if (box1.getY1() > box2.getY2()) {
			return false;
		}
		else if (box1.getY2() < box2.getY1()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String toString(){
		return "x1 = " + x1 + " x2 = " + x2 + " y1 = " + y1 + " y2 = " + y2;
	}
}