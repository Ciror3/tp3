package marsrover;

public class ForwardCommand extends Commands {
	public ForwardCommand(MarsRover rover) {
		super(rover);
	}
  
	public void execute() {
		this.rover.facing.forward();
	}

}
