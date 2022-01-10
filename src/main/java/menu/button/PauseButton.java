package menu.button;

import element.position.Position;
import game.Game;
import menu.Button;

public class PauseButton extends Button {
    public PauseButton(Game game,Position position, int width, int height) {
        super(position,
                width,
                height,
                "PAUSE",
                new ButtonExecute(1, game), // dunno
                "WHITE",
                "BLACK");
    }
}
