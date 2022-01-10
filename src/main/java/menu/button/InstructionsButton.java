package menu.button;

import element.position.Position;
import game.Game;
import menu.Button;

public class InstructionsButton extends Button {
    public InstructionsButton(Game game,Position position, int width, int height) {
        super(position,
                width,
                height,
                "INSTRUCTIONS",
                new ButtonExecute(1, game), // dunno
                "WHITE",
                "BLACK");
    }
}
