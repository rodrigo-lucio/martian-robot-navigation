package br.com.contazul.martianrobotnavigation.domain.robot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Command strategy factory tests")
class CommandStrategyFactoryTest {

    @Test
    @DisplayName("Given a command to rotate left, should execute the rotate left strategy")
    void shouldReturnRotateLeftStrategy() {
        var expectedPositionX = 0;
        var expectedPositionY = 0;
        var expectedDirection = "WEST";

        var robot = Robot.newRobot(Position.with(0, 0, Direction.from("NORTH")));

        var command = CommandStrategyFactory.getCommand(CommandType.ROTATE_LEFT, robot);
        command.execute();

        assertNotNull(robot.getId());
        assertEquals(expectedPositionX, robot.getPosition().getX());
        assertEquals(expectedPositionY, robot.getPosition().getY());
        assertEquals(expectedDirection, robot.getPosition().getDirection().toString());
    }

    @Test
    @DisplayName("Given a command to rotate right, should execute the rotate right strategy")
    void shouldReturnRotateRightStrategy() {
        var expectedPositionX = 0;
        var expectedPositionY = 0;
        var expectedDirection = "EAST";

        var robot = Robot.newRobot(Position.with(0, 0, Direction.from("NORTH")));

        var command = CommandStrategyFactory.getCommand(CommandType.ROTATE_RIGHT, robot);
        command.execute();

        assertNotNull(robot.getId());
        assertEquals(expectedPositionX, robot.getPosition().getX());
        assertEquals(expectedPositionY, robot.getPosition().getY());
        assertEquals(expectedDirection, robot.getPosition().getDirection().toString());
    }

    @Test
    @DisplayName("Given a command to move forward, should execute the move forward strategy")
    void shouldReturnMoveForwardStrategy() {
        var expectedPositionX = 0;
        var expectedPositionY = 1;
        var expectedDirection = "NORTH";

        var robot = Robot.newRobot(Position.with(0, 0, Direction.from("NORTH")));
        var command = CommandStrategyFactory.getCommand(CommandType.MOVE_FORWARD, robot);
        command.execute();

        assertNotNull(robot.getId());
        assertEquals(expectedPositionX, robot.getPosition().getX());
        assertEquals(expectedPositionY, robot.getPosition().getY());
        assertEquals(expectedDirection, robot.getPosition().getDirection().toString());
    }

}
