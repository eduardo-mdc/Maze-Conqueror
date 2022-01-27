package menu;

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
     * When a button is pressed, this calls the execute function.
     * The execute function changes depending on which button is pressed.
     */
    void execute();
}
