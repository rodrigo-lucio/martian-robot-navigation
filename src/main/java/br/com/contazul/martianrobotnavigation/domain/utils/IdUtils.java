package br.com.contazul.martianrobotnavigation.domain.utils;

import java.util.UUID;

public final class IdUtils {

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static UUID fromString(String uuid) {
        return UUID.fromString(uuid);
    }

    public static String fromUUID(UUID id) {
        return id.toString();
    }
}
