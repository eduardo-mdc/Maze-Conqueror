package game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.gui2.Borders;
import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.screen.Screen;

public class Instructions {
    private Screen screen;
    public Instructions(Screen screen) {
        this.screen = screen;
        draw();
    }

    private void draw() {
        TextGraphics textgraphics = screen.newTextGraphics();
        textgraphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        textgraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(200, 200), ' ');

        TextBox textBox = new TextBox();
        // Creates a textbox 30 columns long, 1 column high
        new TextBox(new TerminalSize(10, 1), "Here is some default content!");


    }
}
