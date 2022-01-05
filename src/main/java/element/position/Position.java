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
         * Returns the X coordinate.
         * @return Integer corresponding to the X value.
         */
        public int getX() {
            return x;
        }
        /**
         * Sets the X coordinate.
         * @param x Integer to change the x value to.
         */
        public void setX(int x) {
            this.x = x;
        }
        /**
         * Returns the Y coordinate.
         * @return Integer corresponding to the Y value.
         */
        public int getY() {
            return y;
        }
        /**
         * Sets the Y coordinate.
         * @param y Integer to change the x value to.
         */
        public void setY(int y) {
            this.y = y;
        }

        /**
         * Verifies equality to another object.
         * @param o object to compare to.
         * @return boolean representing the equality of the objects.
         */
        public boolean equals(Object o) {
                if(o == null || o.getClass() != this.getClass()) return false;

                return (this == o) ||
                        (this.x == ((Position) o).x && this.y == ((Position) o).y);
        }
}
