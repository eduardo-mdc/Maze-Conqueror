package maze;

public class VisitedCell {
    private int row;
    private int col;
    private int dist;
    public VisitedCell(int row , int col , int dist ){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }
    public int getDist(){
    return dist;
    }
}
