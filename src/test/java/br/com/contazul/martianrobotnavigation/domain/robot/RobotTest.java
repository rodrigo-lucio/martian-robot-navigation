package br.com.contazul.martianrobotnavigation.domain.robot;

import br.com.contazul.martianrobotnavigation.domain.exceptions.DomainException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Robot tests")
class RobotTest {


    @ParameterizedTest
    @EnumSource(Direction.class)
    @DisplayName("Givan valid parameters, should create a robot successfully in all directions")
    void shouldCreateRobot(Direction direction) {
        var expectedPosition = Position.with(1, 2, direction);

        var robot = Robot.newRobot(expectedPosition);

        assertNotNull(robot.getId());
        assertEquals(expectedPosition.getX(), robot.getPosition().getX());
        assertEquals(expectedPosition.getY(), robot.getPosition().getY());
        assertEquals(direction, robot.getPosition().getDirection());
    }

    @Test
    @DisplayName("Given valid parameters, should create a robot successfully")
    void shouldCreateRobot() {
        var position = Position.with(5, 4, Direction.NORTH);
        var robot = Robot.newRobot(position);

        assertNotNull(robot.getId());
        assertEquals(position.getX(), robot.getPosition().getX());
        assertEquals(position.getY(), robot.getPosition().getY());
        assertEquals(position.getDirection(), robot.getPosition().getDirection());
    }

    @Test
    @DisplayName("Given a null position, should throw a DomainException")
    void shouldThrowDomainExceptionWhenPositionIsNull() {
        var expectedExceptionMessage = "Robot require a starting position";

        var exception = assertThrows(DomainException.class, () -> Robot.newRobot(null));

        assertEquals(expectedExceptionMessage, exception.getMessage());
    }

}
