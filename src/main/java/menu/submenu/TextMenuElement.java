package menu.submenu;

import element.position.PositionInterface;
import menu.GenericMenuElement;

public class TextMenuElement extends GenericMenuElement {

    public TextMenuElement(PositionInterface position, String text){
        super(position);
        setText(text);
    }
    @Override
    public String toString(){
        return text;
    }

}
