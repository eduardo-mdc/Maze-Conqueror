package menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.ActionListDialogBuilder;
import com.googlecode.lanterna.screen.Screen;
import game.GameInterface;

import java.io.IOException;

/**
 * Menu class generate various types of menus.
 *
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */

public class Menu implements MenuInterface {

    private final String backGroundColor;
    private final GameInterface game;
    private final Screen screen;
    private final int type;

    /**
     * Main constructor of the class.
     *
     * @param game   Game running.
     * @param screen Screen to load the menu on.
     * @param type   type of menu to load.
     * @throws IOException .
     */

    public Menu(GameInterface game, Screen screen, int type) throws IOException {
        backGroundColor = "#000000";
        this.screen = screen;
        this.game = game;
        screen.clear();
        this.type = type;
        draw(this.type);
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
    public int getType() {
        return type;
    }

    @Override
    public void startMenu(WindowBasedTextGUI textGUI) {
        new ActionListDialogBuilder()
                .setCanCancel(false)
                .setTitle("Game menu")
                .setDescription("                                   ")
                .addAction("Start Game", new Runnable() {
                    @Override
                    public void run() {
                        game.setState(1);
                    }
                })
                .addAction("Instructions", new Runnable() {
                    @Override
                    public void run() {
                        game.setState(2);
                    }
                })
                .addAction("Exit", new Runnable() {
                    @Override
                    public void run() {
                        game.setState(3);
                    }
                })
                .build()
                .showDialog(textGUI);
    }


    @Override
    public void pauseMenu(WindowBasedTextGUI textGUI) {
        new ActionListDialogBuilder()
                .setCanCancel(false)
                .setTitle("Pause menu")
                .setDescription("                                   ")
                .addAction("Resume Game", new Runnable() {
                    @Override
                    public void run() {
                        game.setState(1);
                    }
                })
                .addAction("Restart", new Runnable() {
                    @Override
                    public void run() {
                        game.setState(4);
                    }
                })
                .addAction("Exit", new Runnable() {
                    @Override
                    public void run() {
                        game.setState(3);
                    }
                })
                .build()
                .showDialog(textGUI);
    }


    @Override
    public void instructionsMenu(WindowBasedTextGUI textGUI) throws IOException {
        new ActionListDialogBuilder()
                .setCanCancel(false)
                .setTitle("Instructions")
                .setDescription("                                   ")
                .addAction("Ir do inicio ate ao trofeu", new Runnable() {
                    @Override
                    public void run() {

                    }
                })
                .addAction("", new Runnable() {
                    @Override
                    public void run() {

                    }
                })
                .addAction("Back", new Runnable() {
                    @Override
                    public void run() {
                        game.setState(0);
                    }
                })
                .build()
                .showDialog(textGUI);
    }


    @Override
    public void draw(int type) throws IOException {
        TextGraphics textgraphics = screen.newTextGraphics();
        textgraphics.setBackgroundColor(TextColor.Factory.fromString(backGroundColor));
        textgraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(200, 200), ' ');
        final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);
        switch (type) {
            case 1 -> startMenu(textGUI);
            case 2 -> pauseMenu(textGUI);
            case 3 -> instructionsMenu(textGUI);
        }
    }
}

