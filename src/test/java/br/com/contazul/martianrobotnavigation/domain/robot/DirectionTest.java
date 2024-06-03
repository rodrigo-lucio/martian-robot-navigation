package br.com.contazul.martianrobotnavigation.domain.robot;

import br.com.contazul.martianrobotnavigation.domain.exceptions.DomainException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Direction tests")
class DirectionTest {

    @Test
    @DisplayName("Given a direction N, should return the North direction")
    void shouldConvertDirectionNorth() {
        var direction = Direction.from("NORTH");
        assertEquals(Direction.NORTH, direction);
    }

    @Test
    @DisplayName("Given a direction S, should return the South direction")
    void shouldConvertDirectionSouth() {
        var direction = Direction.from("SOUTH");
        assertEquals(Direction.SOUTH, direction);
    }

    @Test
    @DisplayName("Given a direction E, should return the East direction")
    void shouldConvertDirectionEast() {
        var direction = Direction.from("EAST");
        assertEquals(Direction.EAST, direction);
    }

    @Test
    @DisplayName("Given a direction W, should return the West direction")
    void shouldConvertDirectionWest() {
        var direction = Direction.from("WEST");
        assertEquals(Direction.WEST, direction);
    }

    @Test
    @DisplayName("An exception should be thrown when the value for a direction is null")
    void shouldThrowExceptionWhenValueIsNull() {
        var expectedMessageError = "Direction is required";

        var actualException = assertThrows(DomainException.class, () -> Direction.from(null));

        assertEquals(expectedMessageError, actualException.getMessage());
    }

    @Test
    @DisplayName("An exception should be thrown when the value for a direction is empty")
    void shouldThrowExceptionWhenValueIsEmpty() {
        var expectedMessageError = "Direction is required";

        var actualException = assertThrows(DomainException.class, () -> Direction.from(""));

        assertEquals(expectedMessageError, actualException.getMessage());
    }

    @Test
    @DisplayName("An exception should be thrown when the value for a direction is invalid")
    void shouldThrowExceptionWhenInvalidDirection() {
        var expectedMessageError = "Invalid direction: TESTE. Valid directions are: NORTH, SOUTH, EAST, WEST";
        
        var actualException = assertThrows(DomainException.class, () -> Direction.from("TESTE"));
        
        assertEquals(expectedMessageError, actualException.getMessage());
    }

}
