package br.com.contazul.martianrobotnavigation.domain.utils;

import java.util.Objects;

public final class StringUtils {
    public static boolean isNullOrBlank(String value) {
        return Objects.isNull(value) || value.trim().isEmpty();
    }

    public static boolean isNotNullOrBlank(String value) {
        return !isNullOrBlank(value);
    }

}
