package br.com.contazul.martianrobotnavigation.domain.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Id utils tests")
class IdUtilsTest {

    @Test
    @DisplayName("Should return a valid UUID")
    void shouldReturnValidId() {
        var id = IdUtils.uuid();
        assertNotNull(id);
        assertFalse(id.isEmpty());
        assertDoesNotThrow(() -> UUID.fromString(id));
    }

    @Test
    @DisplayName("Should return a UUID from a string")
    void shouldReturnUUIDFromString() {
        var id = IdUtils.uuid();
        var uuid = IdUtils.fromString(id);
        assertNotNull(uuid);
        assertEquals(id, uuid.toString());
    }

    @Test
    @DisplayName("Should return a string from a UUID")
    void shouldReturnStringFromUUID() {
        var uuid = UUID.fromString("59080ca2-5711-4219-8545-1ac22a4ed3b5");
        var id = IdUtils.fromUUID(uuid);
        assertNotNull(id);
        assertEquals(uuid.toString(), id);
    }

}
