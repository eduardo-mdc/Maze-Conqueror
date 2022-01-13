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

    protected List<Button> btn;
    private final int xIncr = 10;
    private final int yIncr = 5;
    private int selected;

    private final String backgroundcolor = "BLACK";

    public Menu(Game game, Screen screen) throws IOException {
        this.game = game;
        this.screen = screen;
        btn = new ArrayList<>();
        selected = 0;
    }

    public void iterateSelection(int iterator){
        selected += iterator;
        if(selected < 0) selected = 0;
        else if(selected > btn.size()-1) selected = btn.size()-1;
    }

    public void select(){
        btn.get(selected).execute();
    }

    public void draw(){
        int counter = 0;
        TextGraphics textgraphics = screen.newTextGraphics();
        textgraphics.setBackgroundColor(TextColor.Factory.fromString(backgroundcolor));
        textgraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(200, 200), ' ');
        for(Button button : btn){
            if(selected == counter) button.setSelected(true);
            else button.setSelected(false);
            button.draw(textgraphics);
            counter++;
        }
    }
}
