package br.com.contazul.martianrobotnavigation.application.controlrobot;

import br.com.contazul.martianrobotnavigation.domain.robot.Robot;

public record ControlRobotOutput(
        String robotId,
        Integer positionX,
        Integer positionY,
        String direction
) {

    public static ControlRobotOutput from(final Robot robot) {
        return new ControlRobotOutput(
                robot.getId(),
                robot.getPosition().getX(),
                robot.getPosition().getY(),
                robot.getPosition().getDirection().getFirstChar()
        );
    }

}
