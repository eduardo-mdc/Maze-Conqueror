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
    private Screen screen;
    public Menu(Screen screen){
        this.screen = screen;
        draw();
    }
    public void draw() {
        TextGraphics textgraphics = screen.newTextGraphics();
        textgraphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        textgraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(200, 200), ' ');

        final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);
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
                        // Do 2nd thing...
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



    }
}
