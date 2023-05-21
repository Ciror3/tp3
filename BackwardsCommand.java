package marsrover;

public class BackwardsCommand extends Commands { 

    public BackwardsCommand(MarsRover rover) {
		super(rover);
	} 

	public void execute() {
        this.rover.facing.backwards();
    }
}
