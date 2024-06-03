package br.com.contazul.martianrobotnavigation.domain.robot;

import br.com.contazul.martianrobotnavigation.domain.Entity;
import br.com.contazul.martianrobotnavigation.domain.exceptions.DomainException;
import br.com.contazul.martianrobotnavigation.domain.utils.IdUtils;
import br.com.contazul.martianrobotnavigation.domain.utils.StringUtils;

import java.time.LocalDateTime;
import java.util.Objects;

public class Robot extends Entity {

    private final Position position;

    private Robot(
            final String id,
            final Position position
    ) {
        super(id);
        this.position = position;
        this.validate();
    }

    public static Robot newRobot(final Position position) {
        var id = IdUtils.uuid();
        return new Robot(id, position);
    }

    private void validate() {
        if (Objects.isNull(this.position)) {
            throw new DomainException("Robot require a starting position");
        }

    }

    public Position getPosition() {
        return this.position;
    }

}
