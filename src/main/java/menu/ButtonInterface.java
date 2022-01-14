package menu;

import menu.submenu.GenericMenuElementInterface;

public interface ButtonInterface extends GenericMenuElementInterface {

    /**
     * Return the button current color string.
     *
     * @return the button current color.
     */
    String getCurrentColor();

    /**
     * Sets the button current color in string format.
     *
     * @param newColor
     */
    void setCurrentColor(String newColor);

    /**
     * Sets the current button as selected or not by the user.
     *
     * @param value
     */
    void setSelected(boolean value);

    /**
     * When a button is clicked, this executes the button action.
     * The button will execute his current function and make behavioral changes to the application.
     */
    void execute();
}
