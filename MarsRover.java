package marsrover;

import java.util.Map;
import java.util.Optional;
import java.util.HashMap; 

public class MarsRover{
	public String invalidCommand = "Comando Invalido";
	public Point coordinates; 
    public Cardinality facing; 
    public Map<Character, Commands> commands = new HashMap<Character, Commands>();
    public MarsRover(Point initialCoordinates, Cardinality facing) {
    	commands.put('f', new ForwardCommand(this)); 
        commands.put('b', new BackwardsCommand(this)); 
        commands.put('r', new RotateRightCommand(this));
        commands.put('l', new RotateLeftCommand(this));  
        this.coordinates = initialCoordinates;
        this.facing = facing;  
    }
    
    public void move(String movement) {  
    	movement.chars() 
        .mapToObj(c -> (char) c) 
        .map(commands::get)
        .map(Optional::ofNullable)
        .map(command -> command.orElseThrow(() -> new RuntimeException(invalidCommand)))
        .forEach(Commands::execute);
    }   
      
    //Accessors  
    
    public void setFacing(Cardinality newFacing) {
        this.facing = newFacing;
    }
}