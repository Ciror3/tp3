package marsrover;

public class RotateRightCommand extends Commands{	 
	public RotateRightCommand(MarsRover rover) {
		super(rover);
	}

	public void execute() {
		rover.setFacing(rover.facing.rotateRight()); 
	}
	 
}
 