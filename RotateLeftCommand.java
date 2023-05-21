package marsrover;

public class RotateLeftCommand extends Commands {
	public RotateLeftCommand(MarsRover rover) {
		super(rover);
	}
 
	public void execute() {
        rover.setFacing(rover.facing.rotateLeft());
    }
} 