package br.com.contazul.martianrobotnavigation.domain.robot;

import br.com.contazul.martianrobotnavigation.domain.exceptions.DomainException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Command type tests")
class CommandTypeTest {

    @Test
    @DisplayName("Given a command L, should return the enumerator of the command to rotate left")
    void shouldConvertCommandRotateLeft() {
        var command = CommandType.from("L");
        assertEquals(CommandType.ROTATE_LEFT, command);
    }

    @Test
    @DisplayName("Given a command R, should return the enumerator of the command to rotate right")
    void shouldConvertCommandRotateRight() {
        var command = CommandType.from("R");
        assertEquals(CommandType.ROTATE_RIGHT, command);
    }

    @Test
    @DisplayName("Given a command M, should return the enumerator of the command to move forward")
    void shouldConvertCommandMoveForward() {
        var command = CommandType.from("M");
        assertEquals(CommandType.MOVE_FORWARD, command);
    }

    @Test
    @DisplayName("An exception should be thrown when the command is null")
    void shouldThrowExceptionWhenValueIsNull() {
        var expectedMessageError = "Command is required";

        var actualException = assertThrows(DomainException.class, () -> CommandType.from(null));

        assertEquals(expectedMessageError, actualException.getMessage());
    }

    @Test
    @DisplayName("An exception should be thrown when the command is empty")
    void shouldThrowExceptionWhenValueIsEmpty() {
        var expectedMessageError = "Command is required";

        var actualException = assertThrows(DomainException.class, () -> CommandType.from(""));

        assertEquals(expectedMessageError, actualException.getMessage());
    }

    @Test
    @DisplayName("An exception should be thrown when the command is invalid")
    void shouldThrowExceptionWhenInvalidCommand() {
        var expectedMessageError = "Invalid command: X. Valid commands are: L, R, M";

        var actualException = assertThrows(DomainException.class, () -> CommandType.from("X"));

        assertEquals(expectedMessageError, actualException.getMessage());
    }

}
