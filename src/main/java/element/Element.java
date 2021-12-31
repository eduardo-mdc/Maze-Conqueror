package element;

import element.position.Position;
import element.position.PositionInterface;

public abstract class Element implements ElementInterface{
    private PositionInterface position;

    protected Element(int x, int y){
        position = new Position(x,y);
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
