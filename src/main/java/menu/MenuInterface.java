package menu;

import com.googlecode.lanterna.gui2.WindowBasedTextGUI;

import java.io.IOException;

public interface MenuInterface {

    void startMenu(WindowBasedTextGUI textGUI);

    void pauseMenu(WindowBasedTextGUI textGUI);

    void instructionsMenu(WindowBasedTextGUI textGUI) throws IOException;

    void draw(int type) throws IOException;
}
