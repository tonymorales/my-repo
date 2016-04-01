import java.awt.*;

/**
 * Created by Тоня on 08.10.2015.
 */
public class SeaPlayer extends SeaField {

    public SeaPlayer(SeaGrid sea) {
        super(sea);
    }

    @Override
    protected void paintElement(Graphics g, int i, int j) {
        super.paintElement(g, i, j);
        int cellValue = sea.grid[i][j];
        if (cellValue <= 1) g.setColor(Color.blue);
        else if (cellValue == 2) g.setColor(Color.WHITE);
        else if (cellValue > 10 && cellValue%2 == 0) g.setColor(Color.BLUE);
        else if (cellValue > 10 && cellValue%2 != 0) g.setColor(Color.RED);
        g.fillRect(i * 25, j * 25, 25, 25);
    }
}
