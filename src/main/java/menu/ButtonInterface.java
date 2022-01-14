package menu;

public interface ButtonInterface {

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
}
