import javax.swing.*;
import java.awt.*;

/**
 * Created by Тоня on 07.10.2015.
 */
abstract public class SeaField extends JPanel {

    SeaGrid sea;
        public SeaField(SeaGrid sea){
            this.sea = sea;
        }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Рисуем кораблики и прочее на сеточке
        for(int j = 0; j < 10; j++) {
            for(int i = 0; i < 10; i++) {
                paintElement(g, i, j);
            }
        }

        //Рисуем сеточку
        g.setColor(Color.BLACK);
        for(int i = 0; i < 11; i++) {
            g.drawLine(i*25, 0, i*25,250);
            g.drawLine(0,i*25, 250, i*25);
        }




    }

    protected void paintElement(Graphics g, int i, int j) {
    }


}
