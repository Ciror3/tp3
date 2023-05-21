package marsrover;

public class East extends Cardinality {
	public East(Point coordinates) {
		this.coordinates = coordinates;
		this.facing = 'E';
	} 

	public void forward() {
		coordinates.addOneToX();
	}
 
	public void backwards() {
		coordinates.substractOneToX();
	}

	public Cardinality rotateRight() {
		return new South(coordinates);
	}
 
	public Cardinality rotateLeft() {
		return new North(coordinates);
	}

	public Character facing() {
		return 'E';
	}
	
}
