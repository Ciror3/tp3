package marsrover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MarsRoverTest {
	Character East;
	Character North;
	Character South; 
	Character West;
	Point initialPosition; 
	 
	@BeforeEach public void setUp() {
		initialPosition = new Point(1, 1);
		East = new East(initialPosition).facing();
		North = new North(initialPosition).facing();
		South = new South(initialPosition).facing();
		West = new West(initialPosition).facing();
	}
	 
	@Test
	public void test00CheckIfRoverIsInInitialPosotionAndItsFacingNorth() {
		MarsRover rover = initializeARoverPointingToTheNorth();

		assertEquals(initialPosition, coordinatesOfTheRover(rover));
		assertEquals('N', rover.facing.facing());
	}

	@Test
	public void test01CheckIfRoverDoesNothingIfReceivesAEmptyCommand() {
		MarsRover rover = initializeARoverPointingToTheNorth();
		rover.move("");

		assertEquals(initialPosition, coordinatesOfTheRover(rover));

	}

	@Test
	public void test02MoveForwardInNorth() {
		MarsRover rover = initializeARoverPointingToTheNorth();
		Point expectedPosition = new Point(1, 2);
		rover.move("f");
		assertEquals(expectedPosition.y, coordinatesOfTheRoverInTheYAxis(rover));
	}

	@Test 
	public void test03MoveBackwardInNorth() {
		MarsRover rover = initializeARoverPointingToTheNorth();
		Point expectedPosition = new Point(1, 0);
		rover.move("b");
		assertEquals(expectedPosition.y, coordinatesOfTheRoverInTheYAxis(rover));

	}

	@Test
	public void test04RotateRightInNorth() {
		MarsRover rover = initializeARoverPointingToTheNorth();
		rover.move("r");
		assertEquals(East, rover.facing.facing());
	}

	@Test
	public void test05RotateLeftInNorth() {
		MarsRover rover = initializeARoverPointingToTheNorth();
		rover.move("l");
		assertEquals(West, rover.facing.facing());
	}

	@Test
	public void test06MoveForwardInSouth() {
		MarsRover rover = initializeARoverPointingToTheSouth();
		rover.move("f");
		Point expectedPosition = new Point(1, 0);
		assertEquals(expectedPosition.y, coordinatesOfTheRoverInTheYAxis(rover));
	}
 
	@Test 
	public void test07MoveBackwardInSouth() {
		MarsRover rover = initializeARoverPointingToTheSouth();
		rover.move("b");
		Point expectedPosition = new Point(1, 2);
		assertEquals(expectedPosition.y, coordinatesOfTheRoverInTheYAxis(rover));
	}

	@Test
	public void test08RotateRightInSouth() {
		MarsRover rover = initializeARoverPointingToTheSouth();
		rover.move("r");
		assertEquals(West, rover.facing.facing());
	}

	@Test 
	public void test09RotateLeftInSouth() {
		MarsRover rover = initializeARoverPointingToTheSouth();
		rover.move("l"); 
		assertEquals(East, rover.facing.facing());
	}
 
	@Test
	public void test10MoveForwardInEast() {
		MarsRover rover = initializeARoverPointingToTheEast();
		rover.move("f");
		Point expectedPosition = new Point(2, 1);
		assertEquals(expectedPosition.x, coordinatesOfYheRoverInTheXAxis(rover));
	}

	@Test
	public void test11MoveBackwardInEast() {
		MarsRover rover = initializeARoverPointingToTheEast();
		rover.move("b");
		Point expectedPosition = new Point(0, 1);
		assertEquals(expectedPosition.x, coordinatesOfYheRoverInTheXAxis(rover));
	}

	@Test
	public void test12RotateRightInEast() {
		MarsRover rover = initializeARoverPointingToTheEast();
		rover.move("r");
		assertEquals(South, rover.facing.facing());
	}

	@Test
	public void test13RotateLeftInEast() {
		MarsRover rover = initializeARoverPointingToTheEast();
		rover.move("l");
		assertEquals(North, rover.facing.facing());
	}

	@Test
	public void test14MoveForwardInWest() {
		MarsRover rover = initializeARoverPointingToTheWest();
		rover.move("f");
		Point expectedPosition = new Point(0, 1);
		assertEquals(expectedPosition.x, coordinatesOfYheRoverInTheXAxis(rover));
	}

	@Test
	public void test15MoveBackwardInWest() {
		MarsRover rover = initializeARoverPointingToTheWest();
		rover.move("b");
		Point expectedPosition = new Point(2, 1);
		assertEquals(expectedPosition.x, coordinatesOfYheRoverInTheXAxis(rover));
	}

	@Test
	public void test16RotateRightInWest() {
		MarsRover rover = initializeARoverPointingToTheWest();
		rover.move("r");
		assertEquals(North, rover.facing.facing());
	}

	@Test
	public void test17RotateLeftInWest() {
		MarsRover rover = initializeARoverPointingToTheWest();
		rover.move("l");
		assertEquals(South, rover.facing.facing());
	}
	
	@Test  
	public void test18MoveUntilReceivingAnInvalidCommandThenFail() {
		MarsRover rover = initializeARoverPointingToTheNorth();
	    
	    Exception e = assertThrows(RuntimeException.class, () -> rover.move("frfvfff"));
	    String expectedErrorMessage = Optional.ofNullable(e.getMessage()).orElse(rover.invalidCommand);
	    assertEquals(rover.invalidCommand, expectedErrorMessage);
	     
	    Point expectedPosition = new Point(2, 2);
	    assertEquals(expectedPosition.y, coordinatesOfTheRoverInTheYAxis(rover));
	    assertEquals(East, rover.facing.facing());
	} 
	
	@Test
	public void test19CombineMovementAndRotationStartingInTheNorth() {
		MarsRover rover = initializeARoverPointingToTheNorth();
		rover.move("ffrbrrfffrb");
		Point expectedPosition = new Point(-3, 2);
		assertEquals(expectedPosition.x, coordinatesOfYheRoverInTheXAxis(rover));
		assertEquals(expectedPosition.y, coordinatesOfTheRoverInTheYAxis(rover));
		assertEquals(North, rover.facing.facing());
	} 
	
	@Test
	public void test20CombineMovementAndRotationStartingInTheEast() {
		MarsRover rover = initializeARoverPointingToTheEast();
		rover.move("ffrbrrfffrb");
		Point expectedPosition = new Point(2, 5);
		assertEquals(expectedPosition.x, coordinatesOfYheRoverInTheXAxis(rover));
		assertEquals(expectedPosition.y, coordinatesOfTheRoverInTheYAxis(rover));
		assertEquals(East, rover.facing.facing());
	} 
	
	@Test
	public void test21CombineMovementAndRotationStartingInTheSouth() {
		MarsRover rover = initializeARoverPointingToTheSouth();
		rover.move("ffrbrrfffrb");
		Point expectedPosition = new Point(5, 0);
		assertEquals(expectedPosition.x, coordinatesOfYheRoverInTheXAxis(rover));
		assertEquals(expectedPosition.y, coordinatesOfTheRoverInTheYAxis(rover));
		assertEquals(South, rover.facing.facing());
	}
	
	@Test
	public void test22CombineMovementAndRotationStartingInTheWest() {
		MarsRover rover = initializeARoverPointingToTheWest();
		rover.move("ffrbrrfffrb");
		Point expectedPosition = new Point(0, -3);
		assertEquals(expectedPosition.x, coordinatesOfYheRoverInTheXAxis(rover));
		assertEquals(expectedPosition.y, coordinatesOfTheRoverInTheYAxis(rover));
		assertEquals(West, rover.facing.facing());
	}
	
	private MarsRover initializeARoverPointingToTheNorth() {
		return new MarsRover(initialPosition, new North(initialPosition));
	}  
	  
	private MarsRover initializeARoverPointingToTheSouth() {
		return new MarsRover(initialPosition, new South(initialPosition));
	}

	private MarsRover initializeARoverPointingToTheEast() {
		return new MarsRover(initialPosition, new East(initialPosition));
	}
	 
	private MarsRover initializeARoverPointingToTheWest() {
		return new MarsRover(initialPosition, new West(initialPosition));
	}
	
	private Point coordinatesOfTheRover(MarsRover rover) {
		return rover.coordinates;
	}
	
	private int coordinatesOfYheRoverInTheXAxis(MarsRover rover) {
		return coordinatesOfTheRover(rover).x;
	} 
	
	private int coordinatesOfTheRoverInTheYAxis(MarsRover rover) {
		return coordinatesOfTheRover(rover).y;
	}
}