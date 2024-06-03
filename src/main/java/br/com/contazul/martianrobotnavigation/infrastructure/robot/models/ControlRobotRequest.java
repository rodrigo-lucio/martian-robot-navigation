package br.com.contazul.martianrobotnavigation.infrastructure.robot.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ControlRobotRequest(
        @JsonProperty("commands") String commands
) {
}
