package model.handlers;

import model.Machine;
import model.Player;

public abstract class Handler {
    private Handler nextHandler;

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract boolean handle(int type, Player player, Machine machine);

    public Handler getNextHandler() {
        return nextHandler;
    }
}