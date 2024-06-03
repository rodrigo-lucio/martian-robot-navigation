package br.com.contazul.martianrobotnavigation.application.controlrobot;

import br.com.contazul.martianrobotnavigation.application.exceptions.UseCaseException;
import br.com.contazul.martianrobotnavigation.domain.robot.*;
import br.com.contazul.martianrobotnavigation.domain.utils.StringUtils;
import org.springframework.stereotype.Service;


@Service
public class ControlRobotUseCase {

    public ControlRobotOutput execute(final ControlRobotInput input) {
        this.validateInput(input);
        final var initialPosition = Position.with(0, 0, Direction.NORTH);
        final var robot = Robot.newRobot(initialPosition);

        for (char charCommand : input.commands().toCharArray()) {
            var command = String.valueOf(charCommand);
            var commandType = CommandType.from(command);
            CommandStrategyFactory.getCommand(commandType, robot).execute();
        }

        return ControlRobotOutput.from(robot);
    }

    private void validateInput(ControlRobotInput input) {
        if (StringUtils.isNullOrBlank(input.commands())) {
            throw new UseCaseException("Commands are required");
        }
    }

}
