package br.com.contazul.martianrobotnavigation.application.controlrobot;

public record ControlRobotInput(String commands) {

    public static ControlRobotInput with(final String commands) {
        return new ControlRobotInput(commands);
    }

}
