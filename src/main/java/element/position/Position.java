package element.position;
/**
 * The position class is responsible for handling the object's location on the lanterna screen.
 * @author Eduardo Correia
 * @author Alberto Serra
 * @author José Carvalho
 */
public class Position implements PositionInterface{
        /**
         * Stored X coordinate value;
         */
        private int x;
        /**
         * Stored Y coordinate value;
         */
        private int y;
        /**
         * Constructor for the Position Class. Creates position based on received coordinates.
         * @param x X coordinate for object.
         * @param y Y coordinate for object.
         */
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Alternate Constructor for the Position Class. Creates position based on previous position and increments to the x and y coordinates.
         * @param pos previously created position object
         * @param incrX X increment for new position.
         * @param incrY Y increment for new position.
         */
        public Position(PositionInterface pos,int incrX , int incrY){
            this.x = pos.getX() + incrX;
            this.y = pos.getY() + incrY;
        }

        /**
         * Alternate Constructor for the Position Class. Creates position based on previous position.
         * @param pos previously created position object
         */
        public Position(PositionInterface pos){
            this.x = pos.getX();
            this.y = pos.getY();
        }

        @Override
        public int getX() {
            return x;
        }

        @Override
        public void setX(int x) {
            this.x = x;
        }

        @Override
        public int getY() {
            return y;
        }

        @Override
        public void setY(int y) {
            this.y = y;
        }

        @Override
        public void changePos(int x, int y){
            this.x += x;
            this.y += y;
        }

        /**
         * Verifies equality to another object.
         * @param o object to compare to.
         * @return boolean representing the equality of the objects.
         */
        @Override
        public boolean equals(Object o) {
            if(o == null || o.getClass() != this.getClass()) return false;
            return (this == o) ||
                    (this.x == ((Position) o).x && this.y == ((Position) o).y);
        }

        @Override
        public String toString(){
            return "(" + getX() + "," + getY() + ")" ;
        }
}
