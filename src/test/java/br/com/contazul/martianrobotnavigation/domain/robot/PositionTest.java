package br.com.contazul.martianrobotnavigation.domain.robot;

import br.com.contazul.martianrobotnavigation.domain.exceptions.DomainException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Position tests")
class PositionTest {

    @Test
    @DisplayName("Given a position with X, Y and direction, should create a position object")
    void shouldCreatePosition() {
        var expectedX = 1;
        var expectedY = 2;
        var expectedDirection = Direction.NORTH;

        var position = Position.with(1, 2, Direction.NORTH);

        assertEquals(expectedX, position.getX());
        assertEquals(expectedY, position.getY());
        assertEquals(expectedDirection, position.getDirection());
    }

    @Test
    @DisplayName("Given an north direction, when rotate right, the direction should be east")
    void shouldRotateRightNorth() {
        var expectedX = 1;
        var expectedY = 2;
        var expectedDirection = Direction.EAST;

        var position = Position.with(1, 2, Direction.NORTH);

        position.rotateRight();

        assertEquals(expectedX, position.getX());
        assertEquals(expectedY, position.getY());
        assertEquals(expectedDirection, position.getDirection());
    }

    @Test
    @DisplayName("Given a south direction, when rotate right, the direction should be west")
    void shouldRotateRightSouth() {
        var expectedX = 1;
        var expectedY = 2;
        var expectedDirection = Direction.WEST;

        var position = Position.with(1, 2, Direction.SOUTH);

        position.rotateRight();

        assertEquals(expectedX, position.getX());
        assertEquals(expectedY, position.getY());
        assertEquals(expectedDirection, position.getDirection());
    }

    @Test
    @DisplayName("Given an east direction, when rotate right, the direction should be south")
    void shouldRotateRightEast() {
        var expectedX = 1;
        var expectedY = 2;
        var expectedDirection = Direction.SOUTH;

        var position = Position.with(1, 2, Direction.EAST);

        position.rotateRight();

        assertEquals(expectedX, position.getX());
        assertEquals(expectedY, position.getY());
        assertEquals(expectedDirection, position.getDirection());
    }

    @Test
    @DisplayName("Given a west direction, when rotate right, the direction should be north")
    void shouldRotateRightWest() {
        var expectedX = 1;
        var expectedY = 2;
        var expectedDirection = Direction.NORTH;

        var position = Position.with(1, 2, Direction.WEST);

        position.rotateRight();

        assertEquals(expectedX, position.getX());
        assertEquals(expectedY, position.getY());
        assertEquals(expectedDirection, position.getDirection());
    }

    @Test
    @DisplayName("Given a position with direction North, when rotate left, the direction should be West")
    void shouldRotateLeftNorth() {
        var expectedX = 1;
        var expectedY = 2;
        var expectedDirection = Direction.WEST;

        var position = Position.with(1, 2, Direction.NORTH);

        position.rotateLeft();

        assertEquals(expectedX, position.getX());
        assertEquals(expectedY, position.getY());
        assertEquals(expectedDirection, position.getDirection());
    }

    @Test
    @DisplayName("Given a position with direction South, when rotate left, the direction should be East")
    void shouldRotateLeftSouth() {
        var expectedX = 1;
        var expectedY = 2;
        var expectedDirection = Direction.EAST;

        var position = Position.with(1, 2, Direction.SOUTH);

        position.rotateLeft();

        assertEquals(expectedX, position.getX());
        assertEquals(expectedY, position.getY());
        assertEquals(expectedDirection, position.getDirection());
    }

    @Test
    @DisplayName("Given a position with direction East, when rotate left, the direction should be North")
    void shouldRotateLeftEast() {
        var expectedX = 1;
        var expectedY = 2;
        var expectedDirection = Direction.NORTH;

        var position = Position.with(1, 2, Direction.EAST);

        position.rotateLeft();

        assertEquals(expectedX, position.getX());
        assertEquals(expectedY, position.getY());
        assertEquals(expectedDirection, position.getDirection());
    }

    @Test
    @DisplayName("Given a position with direction West, when rotate left, the direction should be South")
    void shouldRotateLeftWest() {
        var expectedX = 1;
        var expectedY = 2;
        var expectedDirection = Direction.SOUTH;

        var position = Position.with(1, 2, Direction.WEST);

        position.rotateLeft();

        assertEquals(expectedX, position.getX());
        assertEquals(expectedY, position.getY());
        assertEquals(expectedDirection, position.getDirection());
    }

    @Test
    @DisplayName("Given a position with direction north, when move forward, the position Y should be incremented by 1")
    void shouldMoveNorth() {
        var expectedX = 3;
        var expectedY = 5;
        var expectedDirection = Direction.NORTH;

        var position = Position.with(3, 4, Direction.NORTH);

        position.moveForward();

        assertEquals(expectedX, position.getX());
        assertEquals(expectedY, position.getY());
        assertEquals(expectedDirection, position.getDirection());
    }

    @Test
    @DisplayName("Given a position with direction East, when move forward, the position X should be incremented by 1")
    void shouldMoveEast() {
        var expectedX = 5;
        var expectedY = 3;
        var expectedDirection = Direction.EAST;

        var position = Position.with(4, 3, Direction.EAST);

        position.moveForward();

        assertEquals(expectedX, position.getX());
        assertEquals(expectedY, position.getY());
        assertEquals(expectedDirection, position.getDirection());
    }

    @Test
    @DisplayName("Given a position with direction South, when move forward, the position Y should be decremented by 1")
    void shouldMoveSouth() {
        var expectedX = 5;
        var expectedY = 2;
        var expectedDirection = Direction.SOUTH;

        var position = Position.with(5, 3, Direction.SOUTH);

        position.moveForward();

        assertEquals(expectedX, position.getX());
        assertEquals(expectedY, position.getY());
        assertEquals(expectedDirection, position.getDirection());
    }

    @Test
    @DisplayName("Given a position with direction West, when move forward, the position X should be decremented by 1")
    void shouldMoveWest() {
        var expectedX = 2;
        var expectedY = 5;
        var expectedDirection = Direction.WEST;

        var position = Position.with(3, 5, Direction.WEST);

        position.moveForward();

        assertEquals(expectedX, position.getX());
        assertEquals(expectedY, position.getY());
        assertEquals(expectedDirection, position.getDirection());
    }

    @Test
    @DisplayName("An exception should be thrown when the robot tries to leave the exploration area in the North direction")
    void shouldThrowExceptionWhenMoveNorth() {
        var expectedMessageError = "The robot cannot leave the exploration area";

        var position = Position.with(1, 5, Direction.NORTH);
        var actualException = assertThrows(DomainException.class, position::moveForward);

        assertEquals(expectedMessageError, actualException.getMessage());
    }

    @Test
    @DisplayName("An exception should be thrown when the robot tries to leave the exploration area in the East direction")
    void shouldThrowExceptionWhenMoveEast() {
        var expectedMessageError = "The robot cannot leave the exploration area";

        var position = Position.with(5, 5, Direction.EAST);
        var actualException = assertThrows(DomainException.class, position::moveForward);

        assertEquals(expectedMessageError, actualException.getMessage());
    }

    @Test
    @DisplayName("An exception should be thrown when the robot tries to leave the exploration area in the South direction")
    void shouldThrowExceptionWhenMoveSouth() {
        var expectedMessageError = "The robot cannot leave the exploration area";

        var position = Position.with(1, 0, Direction.SOUTH);
        var actualException = assertThrows(DomainException.class, position::moveForward);

        assertEquals(expectedMessageError, actualException.getMessage());
    }

    @Test
    @DisplayName("An exception should be thrown when the robot tries to leave the exploration area in the West direction")
    void shouldThrowExceptionWhenMoveWest() {
        var expectedMessageError = "The robot cannot leave the exploration area";

        var position = Position.with(0, 2, Direction.WEST);
        var actualException = assertThrows(DomainException.class, position::moveForward);

        assertEquals(expectedMessageError, actualException.getMessage());
    }

    @Test
    @DisplayName("An exception should be thrown when the position is created with X null")
    void shouldThrowExceptionWhenPositionIsCreatedWithNullX() {
        var expectedMessageError = "Positon X is required";

        var actualException = assertThrows(DomainException.class, () -> Position.with(null, 2, Direction.NORTH));

        assertEquals(expectedMessageError, actualException.getMessage());
    }

    @Test
    @DisplayName("An exception should be thrown when the position is created with Y null")
    void shouldThrowExceptionWhenPositionIsCreatedWithNullY() {
        var expectedMessageError = "Positon Y is required";

        var actualException = assertThrows(DomainException.class, () -> Position.with(1, null, Direction.NORTH));

        assertEquals(expectedMessageError, actualException.getMessage());
    }

    @Test
    @DisplayName("An exception should be thrown when the position is created with direction null")
    void shouldThrowExceptionWhenPositionIsCreatedWithNullDirection() {
        var expectedMessageError = "Direction is required";

        var actualException = assertThrows(DomainException.class, () -> Position.with(1, 2, null));

        assertEquals(expectedMessageError, actualException.getMessage());
    }

    @Test
    @DisplayName("An exception should be thrown when the position is created with X less than zero")
    void shouldThrowExceptionWhenXIsLessThanZero() {
        var expectedMessageError = "The robot cannot leave the exploration area";

        var actualException = assertThrows(DomainException.class, () -> Position.with(-1, 2, Direction.NORTH));

        assertEquals(expectedMessageError, actualException.getMessage());
    }

    @Test
    @DisplayName("An exception should be thrown when the position is created with Y less than zero")
    void shouldThrowExceptionWhenYIsLessThanZero() {
        var expectedMessageError = "The robot cannot leave the exploration area";

        var actualException = assertThrows(DomainException.class, () -> Position.with(1, -2, Direction.NORTH));

        assertEquals(expectedMessageError, actualException.getMessage());
    }

}
