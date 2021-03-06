package menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import element.position.Position;
import game.GameInterface;
import menu.submenu.TextMenuElement;

import java.util.ArrayList;
import java.util.List;

//Menu class should be abstract but isn't due to testing purposes.
/**
 * Abstract parent class that is used to create the menu's that are used throughout the game.
 */
public class Menu implements MenuInterface {
    private GameInterface game;
    private Screen screen;
    private List<ButtonInterface> btn;
    private List<TextMenuElement> texts;
    private String text;
    private int selected;
    private final String backGroundColor;

    /**
     * Constructor for the menu class, receives a game object and a screen to draw on.
     * @param game current game object.
     * @param screen lanterna screen to draw objects on.
     */
    public Menu(GameInterface game, Screen screen) {
        this.game = game;
        this.screen = screen;
        btn = new ArrayList<>();
        texts = new ArrayList<>();
        text = "";
        selected = 0;
        backGroundColor = "BLACK";
        loadWalls();
    }

    @Override
    public String getBackGroundColor() {
        return backGroundColor;
    }

    @Override
    public GameInterface getGame() {
        return game;
    }

    @Override
    public Screen getScreen() {
        return screen;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void setButtonList(List<ButtonInterface> btn) {
        this.btn = btn;
    }

    @Override
    public List<ButtonInterface> getButtonsList() {
        return btn;
    }

    @Override
    public List<TextMenuElement> getTextList() {
        return texts;
    }

    @Override
    public int getSelected() {
        return selected;
    }

    @Override
    public void loadWalls() {
        for (int i = 0; i < game.getScreenW(); i++) {
            for (int j = 0; j < game.getScreenH(); j++)
                if (i <= 1 || j <= 1 || j >= game.getScreenH() - 2 || i >= game.getScreenW() - 2)
                    texts.add(new TextMenuElement(new Position(i, j), "#"));

        }

    }

    @Override
    public int getMiddle(int screenWidth, String text) {
        int middle = text.length() / 2;
        return screenWidth / 2 - middle;
    }

    @Override
    public void iterateSelection(int iterator) {
        selected += iterator;
        if (selected < 0) selected = btn.size() - 1;
        else if (selected > btn.size() - 1) selected = 0;
    }

    @Override
    public void select() {
        btn.get(selected).execute();
    }

    @Override
    public void splitText(String separator, int xIncr, int yIncr) {
        String[] strArr = text.split(separator);
        int counter = 0;
        for (String word : strArr) {
            texts.add(new TextMenuElement(new Position(xIncr, yIncr + counter), word));
            counter += 2;
        }
    }


    @Override
    public void buttonDraw(int counter, TextGraphics textgraphics) {
        for (ButtonInterface button : btn) {
            if (selected == counter) button.setSelected(true);
            else button.setSelected(false);
            button.draw(textgraphics);
            counter++;
        }
    }

    @Override
    public void textMenuElementDraw(TextGraphics textgraphics) {
        for (TextMenuElement element : texts)
            element.draw(textgraphics);
    }

    @Override
    public void draw() {
        int counter = 0;
        TextGraphics textgraphics = screen.newTextGraphics();
        textgraphics.setBackgroundColor(TextColor.Factory.fromString(backGroundColor));
        textgraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(200, 200), ' ');
        buttonDraw(counter, textgraphics);
        textMenuElementDraw(textgraphics);
    }
}
