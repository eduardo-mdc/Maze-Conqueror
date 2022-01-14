package menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.Game;
import menu.submenu.TextMenuElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Game game;
    private Screen screen;
    protected List<Button> btn;
    protected List<TextMenuElement> texts;
    protected String text;
    private int selected;

    private final String backgroundcolor = "BLACK";

    public Menu(Game game, Screen screen) throws IOException {
        this.game = game;
        this.screen = screen;
        btn = new ArrayList<>();
        texts = new ArrayList<>();
        text = "";
        selected = 0;
    }

    public void iterateSelection(int iterator) {
        selected += iterator;
        if (selected < 0) selected = btn.size() - 1;
        else if (selected > btn.size() - 1) selected = 0;
    }

    public void select() {
        btn.get(selected).execute();
    }

    protected void splitText(String separator, int xIncr, int yIncr) {
        String[] strArr = text.split(separator);
        int counter = 0;
        for (String word : strArr) {
            texts.add(new TextMenuElement(new Position(xIncr, yIncr + counter), word));
            counter += 2;
        }
    }

    public void draw() {
        int counter = 0;
        TextGraphics textgraphics = screen.newTextGraphics();
        textgraphics.setBackgroundColor(TextColor.Factory.fromString(backgroundcolor));
        textgraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(200, 200), ' ');
        for (Button button : btn) {
            if (selected == counter) button.setSelected(true);
            else button.setSelected(false);
            button.draw(textgraphics);
            counter++;
        }
        for (TextMenuElement element : texts) {
            element.draw(textgraphics);
        }
    }
}
