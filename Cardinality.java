package marsrover;

public abstract class Cardinality {
	public Point coordinates;
	public Character facing; 
 
	public abstract void forward();

	public abstract	void backwards();

	public abstract Cardinality rotateRight();

	public abstract Cardinality rotateLeft();
	 
	public abstract Character facing();
	 
}