package br.com.contazul.martianrobotnavigation.domain.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("String utils tests")
class StringUtilsTest {

    @Test
    @DisplayName("Should return true for a null string")
    void shouldReturnTrueForNullString() {
        assertTrue(StringUtils.isNullOrBlank(null));
    }

    @Test
    @DisplayName("Should return true for an empty string")
    void shouldReturnTrueForEmptyString() {
        assertTrue(StringUtils.isNullOrBlank(""));
    }

    @Test
    @DisplayName("Should return true for a string containing spaces")
    void shouldReturnTrueForStringWithSpaces() {
        assertTrue(StringUtils.isNullOrBlank(" "));
    }

    @Test
    @DisplayName("Should return false for a string with content")
    void shouldReturnFalseForStringWithContent() {
        assertFalse(StringUtils.isNullOrBlank("a"));
    }

    @Test
    @DisplayName("Should return false for a null string")
    void shouldReturnFalseForNullString() {
        assertFalse(StringUtils.isNotNullOrBlank(null));
    }

    @Test
    @DisplayName("Should return false for an empty string")
    void shouldReturnFalseForEmptyString() {
        assertFalse(StringUtils.isNotNullOrBlank(""));
    }

    @Test
    @DisplayName("Should return false for a string containing spaces")
    void shouldReturnFalseForStringWithSpaces() {
        assertFalse(StringUtils.isNotNullOrBlank(" "));
    }

    @Test
    @DisplayName("Should return true for a string with content")
    void shouldReturnTrueForStringWithContent() {
        assertTrue(StringUtils.isNotNullOrBlank("a"));
    }

}
