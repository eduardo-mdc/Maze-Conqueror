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
     * Sets the current texts used by the menus subclasses.
     *
     * @param text
     */
    void setText(String text);

    /**
     * Sets the button list with a new list passed as argument.
     *
     * @param btn
     */
    void setButtonList(List<ButtonInterface> btn);

    /**
     * Return the menu buttons list, containing all the buttons present.
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
     * Returns the index of the currently selected button.
     *
     * @return index of the button.
     */
    int getSelected();

    /**
     * Loads the outer border.
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
     * Iterates the value of the selected button. This is used to change which button is selected.
     *
     * @param iterator value to sum to currently selected button.
     */
    void iterateSelection(int iterator);

    /**
     * Executes the currently selected button.
     */
    void select();

    /**
     * Splits the text on the text string and adds them to the texts list. This method is used to facilitate writing long texts on the menu
     *
     * @param separator separator to split the text on
     * @param xIncr x coordinate increment for the text
     * @param yIncr y coordinate increment for the text
     */
    void splitText(String separator, int xIncr, int yIncr);

    /**
     * Draws the buttons present on the menu. Selected buttons appear with a different colour.
     *
     * @param counter index of currently selected button
     * @param textgraphics lanterna textgraphics screen to draw buttons on
     */
    void buttonDraw(int counter, TextGraphics textgraphics);

    /**
     * Draws all the text menu elements in the lanterna textgraphics screen.
     *
     * @param textgraphics lanterna textgraphics screen to draw text on
     */
    void textMenuElementDraw(TextGraphics textgraphics);

    /**
     * Draws the instantiated menu onto the screen.
     */
    void draw();
}
