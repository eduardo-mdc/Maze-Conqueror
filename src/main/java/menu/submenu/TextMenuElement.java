package menu.submenu;

import element.position.PositionInterface;
import menu.GenericMenuElement;

/**
 * Class used to represent texts elements on the various menus. Extension of the generic menu element class.
 */
public class TextMenuElement extends GenericMenuElement {
    /**
     * TextMenuElement constructor, receives a position and text to represent the element on the lanterna screen.
     * @param position position of the element on the screen.
     * @param text text to write to the element.
     */
    public TextMenuElement(PositionInterface position, String text){
        super(position);
        setText(text);
    }
    @Override
    public String toString(){
        return text;
    }

}
