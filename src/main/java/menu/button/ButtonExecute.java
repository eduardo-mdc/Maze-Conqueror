package menu.button;

import game.Game;
import menu.Action;

public class ButtonExecute implements Action {
    private final int nextState;
    private final Game game;
    ButtonExecute(int nextState, Game game){
        this.nextState = nextState;
        this.game = game;
    }
    @Override
    public boolean execute() {
        game.setState(nextState);
        return true;
    }
}
