/**
 * Created by APecherskih on 24.08.2015.
 */
public class ShotCell {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ShotCell(){}

    public ShotCell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
