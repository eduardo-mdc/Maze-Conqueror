package menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import game.GameInterface;
import menu.submenu.TextMenuElement;

import java.util.List;

/**
 * Menu interface generate various types of menus.
 *
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */

public interface MenuInterface {


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
     * Return the menu text shown in gui of the application.
     *
     * @return the menu text,
     */
    String getText();

    /**
     * Return the menu buttons list, containing all the buttons to be selected for the menu.
     *
     * @return buttons list.
     */
    List<ButtonInterface> getButtonsList();

    /**
     * Return the menu text list.
     *
     * @return menu text list.
     */
    List<TextMenuElement> getTextList();

    /**
     * Returns the number of the button selected.
     *
     * @return number of the button.
     */
    int getSelected();

    /**
     * Loads the Menu visual walls used for design proposes.
     */
    void loadWalls();

    /**
     * Return the middle of the text String displayed in the Menu screen.
     *
     * @param screenWidth
     * @param text
     * @return the middle of the text String.
     */
    int getMiddle(int screenWidth, String text);

    /**
     * Iterates the selection of buttons to use.
     *
     * @param iterator
     */
    void iterateSelection(int iterator);

    /**
     * Selects the usage of a certain selected button.
     */
    void select();

    /**
     * Splits the text into words and add them to the list of texts.
     *
     * @param separator
     * @param xIncr
     * @param yIncr
     */
    void splitText(String separator, int xIncr, int yIncr);

    /**
     * Checks the selected buttons and apply the buttons drawing into the screen.
     *
     * @param counter
     * @param textgraphics
     */
    void buttonDraw(int counter, TextGraphics textgraphics);

    /**
     * Draws all the text menu elements in the text screen.
     *
     * @param textgraphics
     */
    void textMenuElementDraw(TextGraphics textgraphics);

    /**
     * Draws the menu object into the screen.
     */
    void draw();
}
