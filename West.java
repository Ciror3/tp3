package marsrover;

public class West extends Cardinality {
	public West(Point coordinates) {
		this.coordinates = coordinates;
		this.facing = 'O';
	} 

	public void forward() {
        coordinates.substractOneToX();
    }

    public void backwards() { 
        coordinates.addOneToX();
    }
  
	public Cardinality rotateRight() {
		return new North(coordinates);
	}

	public Cardinality rotateLeft() {
		return new South(coordinates);
	}
	
	public Character facing() {
        return 'O';  
    }
}
