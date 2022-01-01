package menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.gui2.dialogs.ActionListDialogBuilder;
import com.googlecode.lanterna.screen.Screen;
import element.stat.Wall;
import game.Game;

import java.io.IOException;

public class Menu implements MenuInterface {
    final private String backgroundcolor = "#000000";
    private Screen screen;
    public Menu(Screen screen, int type ){
        this.screen = screen;
        draw(type);
    }
    public void draw(int type) {
        TextGraphics textgraphics = screen.newTextGraphics();
        textgraphics.setBackgroundColor(TextColor.Factory.fromString(backgroundcolor));
        textgraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(200, 200), ' ');
        final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);
        switch (type) {
            case 1:
                new ActionListDialogBuilder()
                        .setCanCancel(false)
                        .setTitle("Game menu")
                        .setDescription("                                                                                                                       ")
                        .addAction("Start Game", new Runnable() {
                            @Override
                            public void run() {
                                Game.setState(1);

                            }
                        })
                        .addAction("Instructions", new Runnable() {
                            @Override
                            public void run() {
                                Game.setState(2);
                            }
                        })
                        .addAction("Exit", new Runnable() {
                            @Override
                            public void run() {
                                Game.setState(3);
                            }
                        })
                        .build()
                        .showDialog(textGUI);
                break;
            case 2:
                new ActionListDialogBuilder()
                        .setCanCancel(false)
                        .setTitle("Pause menu")
                        .setDescription("                                                                                                                       ")
                        .addAction("Resume Game", new Runnable() {
                            @Override
                            public void run() {
                                Game.setState(1);
                            }
                        })
                        .addAction("Restart", new Runnable() {
                            @Override
                            public void run() {
                                Game.setState(4);
                            }
                        })
                        .addAction("Exit", new Runnable() {
                            @Override
                            public void run() {
                                Game.setState(3);
                            }
                        })
                        .build()
                        .showDialog(textGUI);
                break;
            case 3:
                new ActionListDialogBuilder()
                        .setCanCancel(false)
                        .setTitle("Instructions menu")
                        .setDescription("                                                                                                                       ")
                        .addAction("Instructions WIP", new Runnable() {
                            @Override
                            public void run() {
                                Game.setState(1);
                            }
                        })
                        .build()
                        .showDialog(textGUI);
                break;
        }





    }
}
