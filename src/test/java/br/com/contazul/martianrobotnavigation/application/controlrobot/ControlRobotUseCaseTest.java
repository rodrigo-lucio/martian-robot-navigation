package br.com.contazul.martianrobotnavigation.application.controlrobot;

import br.com.contazul.martianrobotnavigation.application.exceptions.UseCaseException;
import br.com.contazul.martianrobotnavigation.domain.exceptions.DomainException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Control robots use case tests")
class ControlRobotUseCaseTest {

    private ControlRobotUseCase controlRobotUseCase;

    @BeforeEach
    void setup() {
        controlRobotUseCase = new ControlRobotUseCase();
    }

    @Test
    @DisplayName("Given a robot and a list of valid commands, should move the robot with rotation right")
    void shouldControlRobotRight() {
        var expectedPositionX = 2;
        var expectedPositionY = 0;
        var expectedDirection = "S";
        var command = "MMRMMRMM";
        var controlRobotInputDTO = ControlRobotInput.with(command);

        var actualOutput = controlRobotUseCase.execute(controlRobotInputDTO);

        assertNotNull(actualOutput.robotId());
        assertEquals(expectedPositionX, actualOutput.positionX());
        assertEquals(expectedPositionY, actualOutput.positionY());
        assertEquals(expectedDirection, actualOutput.direction());

    }
    @Test
    @DisplayName("Given a list of valid commands, should move the robot with rotation left")
    void shouldControlRobotLeft() {
        var expectedPositionX = 0;
        var expectedPositionY = 2;
        var expectedDirection = "W";
        var command = "MML";
        var controlRobotInputDTO = ControlRobotInput.with(command);

        var actualOutput = controlRobotUseCase.execute(controlRobotInputDTO);

        assertNotNull(actualOutput.robotId());
        assertEquals(expectedPositionX, actualOutput.positionX());
        assertEquals(expectedPositionY, actualOutput.positionY());
        assertEquals(expectedDirection, actualOutput.direction());
    }

    @Test
    @DisplayName("Given an invalid command, it should return an error")
    void shouldThrowExceptionWhenInvalidCommand() {
        var expectedMessageError = "Invalid command: A. Valid commands are: L, R, M";
        var command = "AAA";
        var controlRobotInputDTO = ControlRobotInput.with(command);

        var actualException = assertThrows(DomainException.class, () -> controlRobotUseCase.execute(controlRobotInputDTO));

        assertEquals(expectedMessageError, actualException.getMessage());
    }

    @Test
    @DisplayName("Given a robot and a list of valid commands, an error should occur when the robot attempts to leave the exploration area")
    void shouldThrowExceptionWhenRobotLeavesExplorationArea() {
        var expectedMessageError = "The robot cannot leave the exploration area";
        var command = "MMMMMMMMMMMMMMMMMMMMMMMM";
        var controlRobotInputDTO = ControlRobotInput.with(command);

        var actualException = assertThrows(DomainException.class, () -> controlRobotUseCase.execute(controlRobotInputDTO));

        assertEquals(expectedMessageError, actualException.getMessage());
    }

    @Test
    @DisplayName("Given a null command, it should return an error")
    void shouldNotControlRobotWhenCommandIsNull() {
        var expectedError = "Commands are required";

        var controlRobotInputDTO = ControlRobotInput.with(null);

        var actualException = assertThrows(UseCaseException.class, () -> controlRobotUseCase.execute(controlRobotInputDTO));
        assertEquals(expectedError, actualException.getMessage());
    }

    @Test
    @DisplayName("Given an empty command, it should return an error")
    void shouldNotControlRobotWhenCommandIsBlank() {
        var expectedError = "Commands are required";

        var controlRobotInputDTO = ControlRobotInput.with("");

        var actualException = assertThrows(UseCaseException.class, () -> controlRobotUseCase.execute(controlRobotInputDTO));
        assertEquals(expectedError, actualException.getMessage());
    }

}
