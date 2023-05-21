package marsrover;

public class North extends Cardinality {
	public North(Point coordinates) {
		this.coordinates = coordinates;
		this.facing = 'N';
	}
 
	public void forward() {
		coordinates.addOneToY();
	}

	public void backwards() {
		coordinates.substractOneToY();
	}

	public Cardinality rotateRight() {
		return new East(coordinates);
	}

	public Cardinality rotateLeft() {
		return new West(coordinates);
	}
	
	public Character facing() {
		return 'N';
	}
}
