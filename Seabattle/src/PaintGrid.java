import javax.swing.*;
import java.awt.*;

/**
 * Created by ����� on 04.10.2015.
 */
public class PaintGrid extends JPanel {

    private int offSet = 35;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.cyan);
        g.fillRect(25, 25, 480, 220);
        g.setColor(Color.BLACK);
        for(int i = 0; i < 11; i++) {
            g.drawLine(i*20+offSet, 0+offSet, i*20+offSet,200+offSet);
            g.drawLine(0+offSet,i*20+offSet, 200+offSet, i*20+offSet);
            g.drawLine(i*20+offSet+250, 0+offSet, i*20+offSet+250,200+offSet);
            g.drawLine(0+offSet+250,i*20+offSet, 200+offSet+250, i*20+offSet);
        }


    }



}
