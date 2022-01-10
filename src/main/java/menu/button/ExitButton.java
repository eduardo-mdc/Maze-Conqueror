package menu.button;

import element.position.Position;
import game.Game;
import menu.Button;

public class ExitButton extends Button {
    public ExitButton(Game game, Position position, int width, int height) {
        super(position,
                width,
                height,
                "EXIT",
                new ButtonExecute(1, game),
                "WHITE",
                "BLACK");
    }
}
