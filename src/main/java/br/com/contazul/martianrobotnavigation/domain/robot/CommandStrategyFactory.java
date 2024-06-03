package br.com.contazul.martianrobotnavigation.domain.robot;

import br.com.contazul.martianrobotnavigation.domain.exceptions.DomainException;

public class CommandStrategyFactory {

    public static Command getCommand(CommandType commandType, Robot robot) {
        var position = robot.getPosition();
        return switch (commandType) {
            case ROTATE_LEFT -> position::rotateLeft;
            case ROTATE_RIGHT -> position::rotateRight;
            case MOVE_FORWARD -> position::moveForward;
            default -> throw new DomainException("Invalid command");
        };
    }

}
