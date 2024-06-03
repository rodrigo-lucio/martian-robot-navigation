package br.com.contazul.martianrobotnavigation.infrastructure.robot.api;

import br.com.contazul.martianrobotnavigation.infrastructure.robot.models.ControlRobotResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "mars")
public interface RobotApi {

    @PostMapping(
            value = "{commands}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<ControlRobotResponse> controlRobot(
            @PathVariable(name = "commands") final String commands);

}
