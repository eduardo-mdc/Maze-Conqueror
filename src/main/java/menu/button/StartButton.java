package menu.button;

import element.position.Position;
import game.Game;
import menu.Button;

public class StartButton extends Button {
    public StartButton(Game game,Position position, int width, int height) {
        super(position,
                width,
                height,
                "Start",
                new ButtonExecute(1, game),
                "WHITE",
                "BLACK");
    }
}
