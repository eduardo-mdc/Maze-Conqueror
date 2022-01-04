package menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.ActionListDialogBuilder;
import com.googlecode.lanterna.screen.Screen;
import game.Game;
import game.GameInterface;

import java.io.IOException;

public class Menu implements MenuInterface {

    private final String backgroundcolor = "#000000";
    private final GameInterface game;
    private final Screen screen;
    private final int type;

    public Menu(GameInterface game, Screen screen, int type) throws IOException {
        this.screen = screen;
        this.game = game;
        screen.clear();
        this.type = type;
        draw(this.type);
    }

    private void startMenu(WindowBasedTextGUI textGUI) {
        new ActionListDialogBuilder()
                .setCanCancel(false)
                .setTitle("Game menu")
                .setDescription("                                                                                                                       ")
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

    private void pauseMenu(WindowBasedTextGUI textGUI) {
        new ActionListDialogBuilder()
                .setCanCancel(false)
                .setTitle("Pause menu")
                .setDescription("                                                                                                                       ")
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

    private void instructionsMenu(WindowBasedTextGUI textGUI) throws IOException {
        new ActionListDialogBuilder()
                .setCanCancel(false)
                .setTitle("Instructions")
                .setDescription("                                                                                                                       ")
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

    public void draw(int type) throws IOException {
        TextGraphics textgraphics = screen.newTextGraphics();
        textgraphics.setBackgroundColor(TextColor.Factory.fromString(backgroundcolor));
        textgraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(200, 200), ' ');
        final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);
        switch (type) {
            case 1 -> startMenu(textGUI);
            case 2 -> pauseMenu(textGUI);
            case 3 -> instructionsMenu(textGUI);
        }
    }
}

