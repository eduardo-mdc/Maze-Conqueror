package menu;

import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.screen.Screen;
import game.GameInterface;

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
     * Sets the background string color.
     *
     * @param color
     */
    void setBackGroundColor(String color);

    /**
     * Returns the string representing the background color of the menu.
     *
     * @return Menu background color.
     */
    String getBackGroundColor();

    /**
     * Returns the current game object interface.
     *
     * @return game object interface.
     */
    GameInterface getGame();

    /**
     * Returns the used screen object in the menu.
     *
     * @return Screen object.
     */
    Screen getScreen();

    /**
     * Returns the type of the menu created.
     *
     * @return menu type.
     */
    int getType();

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
