package menu;

import com.googlecode.lanterna.gui2.WindowBasedTextGUI;

import java.io.IOException;

/**
 * Menu interface generate various types of menus.
 *
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */

public interface MenuInterface {

    /**
     * load menu type one.
     *
     * @param textGUI base interface for the TextGUI.
     */
    void startMenu(WindowBasedTextGUI textGUI);

    /**
     * loads menu type 2.
     *
     * @param textGUI base interface for the TextGUI.
     */
    void pauseMenu(WindowBasedTextGUI textGUI);

    /**
     * loads menu type 3.
     *
     * @param textGUI base interface for the TextGUI.
     * @throws IOException
     */
    void instructionsMenu(WindowBasedTextGUI textGUI) throws IOException;

    /**
     * Draws the menu into the given screen.
     * Type 1 = Starting Menu.
     * Type 2 = Pause Menu.
     * Type 3 = Instructions Menu.
     *
     * @param type type of menu to draw.
     * @throws IOException .
     */
    void draw(int type) throws IOException;
}
