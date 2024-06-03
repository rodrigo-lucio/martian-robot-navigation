package br.com.contazul.martianrobotnavigation.infrastructure.robot.models;

import br.com.contazul.martianrobotnavigation.application.controlrobot.ControlRobotOutput;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public record ControlRobotResponse(
        @JsonProperty("robotId") String robotId,
        @JsonProperty("positionX") Integer positionX,
        @JsonProperty("positionY") Integer positionY,
        @JsonProperty("direction") String direction
) {

    public static ControlRobotResponse from(final ControlRobotOutput output) {
        return new ControlRobotResponse(
                output.robotId(),
                output.positionX(),
                output.positionY(),
                output.direction()
        );
    }

}
