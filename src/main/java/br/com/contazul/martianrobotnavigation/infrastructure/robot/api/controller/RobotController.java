package br.com.contazul.martianrobotnavigation.infrastructure.robot.api.controller;

import br.com.contazul.martianrobotnavigation.application.controlrobot.ControlRobotInput;
import br.com.contazul.martianrobotnavigation.application.controlrobot.ControlRobotUseCase;
import br.com.contazul.martianrobotnavigation.infrastructure.robot.api.RobotApi;
import br.com.contazul.martianrobotnavigation.infrastructure.robot.models.ControlRobotRequest;
import br.com.contazul.martianrobotnavigation.infrastructure.robot.models.ControlRobotResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RobotController implements RobotApi {

    private final ControlRobotUseCase controlRobotUseCase;

    public RobotController(final ControlRobotUseCase controlRobotUseCase) {
        this.controlRobotUseCase = controlRobotUseCase;
    }

    @Override
    public ResponseEntity<ControlRobotResponse> controlRobot(final String commands) {
        final var input = ControlRobotInput.with(commands);
        final var output = this.controlRobotUseCase.execute(input);
        return ResponseEntity.ok(ControlRobotResponse.from(output));
    }

}
