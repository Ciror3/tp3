package marsrover;

public class South extends Cardinality {
	public South(Point coordinates) {
		this.coordinates = coordinates;
		this.facing = 'S';
	} 

	public void forward() {
		coordinates.substractOneToY();
	}

	public void backwards() {
		coordinates.addOneToY();
	}

	public Cardinality rotateRight() {
		return new West(coordinates);
	}

	public Cardinality rotateLeft() {
		return new East(coordinates);
	}
	
	public Character facing() {
		return 'S';
	}
}
