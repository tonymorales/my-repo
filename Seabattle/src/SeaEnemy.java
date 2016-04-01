import java.awt.*;

/**
 * Created by Tony on 08.10.2015.
 */
public class SeaEnemy extends SeaField {
    public SeaEnemy(SeaGrid sea) {
        super(sea);
    }

    @Override
    protected void paintElement(Graphics g, int i, int j) {
        super.paintElement(g, i, j);
        int cellValue = sea.grid[i][j];
        if (cellValue <= 1) g.setColor(Color.blue);
        else if (cellValue == 2) g.setColor(Color.WHITE);
        else if (cellValue > 10 && cellValue%2 == 0) g.setColor(Color.GREEN);
        else if (cellValue > 10 && cellValue%2 != 0) g.setColor(Color.RED);
        g.fillRect(i * 25, j * 25, 25, 25);
    }
}
