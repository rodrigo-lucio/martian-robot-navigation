package br.com.contazul.martianrobotnavigation.infrastructure.robot.api;

import br.com.contazul.martianrobotnavigation.application.controlrobot.ControlRobotInput;
import br.com.contazul.martianrobotnavigation.application.controlrobot.ControlRobotOutput;
import br.com.contazul.martianrobotnavigation.application.controlrobot.ControlRobotUseCase;
import br.com.contazul.martianrobotnavigation.domain.exceptions.DomainException;
import br.com.contazul.martianrobotnavigation.domain.robot.Direction;
import br.com.contazul.martianrobotnavigation.domain.robot.Position;
import br.com.contazul.martianrobotnavigation.domain.robot.Robot;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RobotApi.class)
@DisplayName("Robot api tests")
class RobotApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private ControlRobotUseCase controlRobotUseCase;

    @Test
    @DisplayName("Given a robot and a list of valid commands, should move the robot with rotation right")
    void shouldControlRobotRight() throws Exception {
        var expectedPositionX = 2;
        var expectedPositionY = 0;
        var expectedDirection = Direction.SOUTH;
        var expectedRobot = Robot.newRobot(Position.with(expectedPositionX, expectedPositionY, expectedDirection));

        var inputRequest = "MMRMMRMM";

        var request = post("/mars/" + inputRequest);

        when(controlRobotUseCase.execute(Mockito.any(ControlRobotInput.class))).
                thenReturn(ControlRobotOutput.from(expectedRobot));

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.robotId").isNotEmpty())
                .andExpect(jsonPath("$.positionX").value(expectedPositionX))
                .andExpect(jsonPath("$.positionY").value(expectedPositionY))
                .andExpect(jsonPath("$.direction").value(expectedDirection.getFirstChar()));

        verify(controlRobotUseCase).execute(argThat(argument ->
                argument.commands().equals(inputRequest)));

    }

    @Test
    @DisplayName("Given a robot and a list of valid commands, should move the robot with rotation left")
    void shouldControlRobotLeft() throws Exception {
        var expectedPositionX = 2;
        var expectedPositionY = 0;
        var expectedDirection = Direction.WEST;
        var expectedRobot = Robot.newRobot(Position.with(expectedPositionX, expectedPositionY, expectedDirection));

        var inputRequest = "MML";

        var request = post("/mars/" + inputRequest);

        when(controlRobotUseCase.execute(Mockito.any(ControlRobotInput.class))).
                thenReturn(ControlRobotOutput.from(expectedRobot));

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.robotId").isNotEmpty())
                .andExpect(jsonPath("$.positionX").value(expectedPositionX))
                .andExpect(jsonPath("$.positionY").value(expectedPositionY))
                .andExpect(jsonPath("$.direction").value(expectedDirection.getFirstChar()));

        verify(controlRobotUseCase).execute(argThat(argument ->
                argument.commands().equals(inputRequest)));

    }

    @Test
    @DisplayName("Given an invalid command, it should return an error")
    void shouldThrowExceptionWhenInvalidCommand() throws Exception {
        var expectedMessageError = "Invalid command: A. Valid commands are: L, R, M";

        var inputRequest = "AAA";

        var request = post("/mars/" + inputRequest);

        when(controlRobotUseCase.execute(Mockito.any(ControlRobotInput.class))).
                thenThrow(new DomainException(expectedMessageError));

        mockMvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(jsonPath("$.reason").value(HttpStatus.BAD_REQUEST.getReasonPhrase()))
                .andExpect(jsonPath("$.message").value(expectedMessageError))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());;

        verify(controlRobotUseCase).execute(argThat(argument ->
                argument.commands().equals(inputRequest)));

    }

    @Test
    @DisplayName("Given a robot and a list of valid commands, an error should occur when the robot attempts to leave the exploration area")
    void shouldThrowExceptionWhenRobotLeavesExplorationArea() throws Exception {
        var expectedMessageError = "The robot cannot leave the exploration area";
        var inputRequest = "AAA";

        var request = post("/mars/" + inputRequest);

        when(controlRobotUseCase.execute(Mockito.any(ControlRobotInput.class))).
                thenThrow(new DomainException(expectedMessageError));

        mockMvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(jsonPath("$.reason").value(HttpStatus.BAD_REQUEST.getReasonPhrase()))
                .andExpect(jsonPath("$.message").value(expectedMessageError))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());;

        verify(controlRobotUseCase).execute(argThat(argument ->
                argument.commands().equals(inputRequest)));
    }

    @Test
    @DisplayName("Given an empty command, it should return an error")
    void shouldNotControlRobotWhenCommandIsBlank() throws Exception {
        var expectedMessageError = "Commands are required";
        var inputRequest = "AAA";

        var request = post("/mars/" + inputRequest);

        when(controlRobotUseCase.execute(Mockito.any(ControlRobotInput.class))).
                thenThrow(new DomainException(expectedMessageError));

        mockMvc.perform(request)
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(jsonPath("$.reason").value(HttpStatus.BAD_REQUEST.getReasonPhrase()))
                .andExpect(jsonPath("$.message").value(expectedMessageError))
                .andExpect(jsonPath("$.timestamp").isNotEmpty());;

        verify(controlRobotUseCase).execute(argThat(argument ->
                argument.commands().equals(inputRequest)));

    }
}
