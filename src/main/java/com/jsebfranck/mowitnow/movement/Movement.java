package com.jsebfranck.mowitnow.movement;

/**
 * All possible movements of a mover.
 * @author jsebfranck
 */
public enum Movement {
    TURN_LEFT(new TurnToLeftMovementAction()),
    TURN_RIGHT(new TurnToRightMovementAction()),
    ADVANCE(new AdvanceMovementAction());

    private final MovementAction movementAction;

    private Movement(MovementAction movementAction) {
        this.movementAction = movementAction;
    }

    public MovementAction getMovementAction() {
        return movementAction;
    }
}
