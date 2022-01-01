package element;

import element.position.Position;
import element.position.PositionInterface;

public abstract class Element implements ElementInterface{
    private PositionInterface position;

    protected Element(PositionInterface position){
        this.position = position;
    }

    @Override
    public PositionInterface getPosition() {
        return position;
    }

    @Override
    public void setPosition(PositionInterface position) {
        this.position = position;
    }

}
