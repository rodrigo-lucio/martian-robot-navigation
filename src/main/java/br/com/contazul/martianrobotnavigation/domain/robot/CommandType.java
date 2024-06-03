package br.com.contazul.martianrobotnavigation.domain.robot;

import br.com.contazul.martianrobotnavigation.domain.exceptions.DomainException;
import br.com.contazul.martianrobotnavigation.domain.utils.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum CommandType {

    ROTATE_LEFT("L"),
    ROTATE_RIGHT("R"),
    MOVE_FORWARD("M");

    private final String value;

    public String getValue() {
        return value;
    }

    CommandType(final String value) {
        this.value = value;
    }

    public static CommandType from(final String value) {
        if (StringUtils.isNullOrBlank(value)) {
            throw new DomainException("Command is required");
        }

        return Arrays.stream(CommandType.values())
                .filter(dir -> value.equals(dir.getValue()))
                .findFirst()
                .orElseThrow(() -> new DomainException(String.format(
                        "Invalid command: %s. Valid commands are: %s",
                        value,
                        Arrays.stream(CommandType.values()).map(CommandType::getValue).collect(Collectors.joining(", "))
                )));

    }

}
