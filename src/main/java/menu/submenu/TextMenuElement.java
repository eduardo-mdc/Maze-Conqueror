package menu.submenu;

import element.position.Position;
import menu.GenericMenuElement;

public class TextMenuElement extends GenericMenuElement {

    public TextMenuElement(Position position, String text){
        super(position);
        setText(text);
    }
    @Override
    public String toString(){
        return text;
    }

}
