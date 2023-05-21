package marsrover;

public class Point{
	public int x;
    public int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    } 
        
    public void addOneToX() {
        this.x = this.x + 1; 
    }
    
    public void addOneToY() {
    	this.y = this.y + 1; 
    }
    
    public void substractOneToX() {
        this.x = this.x - 1; 
    }
    
    public void substractOneToY() {
    	this.y = this.y - 1; 
    }
}