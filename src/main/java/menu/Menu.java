package menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import element.Static.StaticElement;
import element.position.Position;
import game.Game;
import menu.button.ExitButton;
import menu.button.InstructionsButton;
import menu.button.StartButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private Game game;
    private Screen screen;

    private  List<Button> btn;
    private final int xIncr = 10;
    private final int yIncr = 5;

    private final String backgroundcolor = "BLACK";

    public Menu(Game game, Screen screen) throws IOException {
        this.game = game;
        this.screen = screen;
    }

    public void draw(){
        TextGraphics textgraphics = screen.newTextGraphics();
        textgraphics.setBackgroundColor(TextColor.Factory.fromString(backgroundcolor));
        textgraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(200, 200), ' ');
        for(Button button : btn){
            button.draw(textgraphics);
        }
    }
}
