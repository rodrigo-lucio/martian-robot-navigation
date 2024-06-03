package br.com.contazul.martianrobotnavigation.domain.robot;

import br.com.contazul.martianrobotnavigation.domain.exceptions.DomainException;
import br.com.contazul.martianrobotnavigation.domain.utils.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Direction {

    NORTH,
    SOUTH,
    EAST,
    WEST;


    public static Direction from(final String value) {
        if (StringUtils.isNullOrBlank(value)) {
            throw new DomainException("Direction is required");
        }

        return Arrays.stream(Direction.values())
                .filter(dir -> value.equals(dir.toString()))
                .findFirst()
                .orElseThrow(() -> new DomainException(String.format(
                        "Invalid direction: %s. Valid directions are: %s",
                        value,
                        Arrays.stream(Direction.values()).map(Direction::toString).collect(Collectors.joining(", "))
                )));

    }


}
