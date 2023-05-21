package marsrover;

public abstract class Commands {
	public MarsRover rover;
	public Commands( MarsRover rover) {
		this.rover = rover;
	}
	 
	public abstract void execute();	
}
 