package br.com.contazul.martianrobotnavigation.domain.robot;

import br.com.contazul.martianrobotnavigation.domain.exceptions.DomainException;

import java.util.Objects;

public class Position {

    private static final Integer MAX_X = 5;
    private static final Integer MAX_Y = 5;
    public static final int MIN_X = 0;
    public static final int MIN_Y = 0;

    private Integer x;
    private Integer y;
    private Direction direction;

    private Position(final Integer x, final Integer y, final Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.validate();
    }

    public static Position with(final Integer x, final Integer y, final Direction direction) {
        return new Position(x, y, direction);
    }

    private void validate() {
        this.validateFields();
        this.validatePosition();
    }

    private void validateFields() {
        if (Objects.isNull(this.x)) {
            throw new DomainException("Positon X is required");
        }

        if (Objects.isNull(this.y)) {
            throw new DomainException("Positon Y is required");
        }

        if (Objects.isNull(this.direction)) {
            throw new DomainException("Direction is required");
        }

    }

    private void validatePosition() {
        if (positionXInvalid() || positionYInvalid()) {
            throw new DomainException("The robot cannot leave the exploration area");
        }
    }

    private boolean positionYInvalid() {
        return this.y < MIN_Y || this.y > MAX_Y;
    }

    private boolean positionXInvalid() {
        return this.x < MIN_X || this.x > MAX_X;
    }

    protected void rotateRight() {
        switch (this.direction) {
            case NORTH -> this.changeDirection(Direction.EAST);
            case EAST -> this.changeDirection(Direction.SOUTH);
            case SOUTH -> this.changeDirection(Direction.WEST);
            case WEST -> this.changeDirection(Direction.NORTH);
            default -> throw new DomainException("Invalid direction");
        }
    }

    protected void rotateLeft() {
        switch (this.direction) {
            case NORTH -> this.changeDirection(Direction.WEST);
            case WEST -> this.changeDirection(Direction.SOUTH);
            case SOUTH -> this.changeDirection(Direction.EAST);
            case EAST -> this.changeDirection(Direction.NORTH);
            default -> throw new DomainException("Invalid direction");
        }
    }

    private void changeDirection(Direction direction) {
        this.direction = direction;
    }

    public void moveForward() {
        switch (this.direction) {
            case NORTH -> this.y++;
            case EAST -> this.x++;
            case SOUTH -> this.y--;
            case WEST -> this.x--;
            default -> throw new DomainException("Invalid direction");
        }

        this.validatePosition();
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }

    public Direction getDirection() {
        return this.direction;
    }

}
