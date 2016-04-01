import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Тоня on 06.10.2015.
 */
public class GameGui extends JFrame implements MouseInputListener {

    GameHelper game;
    SeaGrid sea;
    SeaGrid seaAi;
    int offSet = 35;
    SeaPlayer sp;
    SeaEnemy se;
    AI ai;
    JTextField textField;

    GameGui(){
        super("Морской бой");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setResizable(false);
        this.setLayout(new BorderLayout());
        //getContentPane().setLayout(null);
        getContentPane().setLayout(null);
        textField = new JTextField();
        textField.setSize(this.getWidth(), this.getHeight() - 330);
        textField.setLocation(0, 330);
        textField.getAccessibleContext();
        //textField.setLineWrap(true);
        //JScrollPane jScrollPane = new JScrollPane(textField);
       // textField.add(jScrollPane);







        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem newGameItem = new JMenuItem("Новая игра");
        menu.add(newGameItem);
        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        menu.addActionListener(new MenuListener());

        exitItem.addActionListener(new ExitItem());

        JMenu aboutMenu = new JMenu("About");
        JMenuItem about = new JMenuItem("About");
        aboutMenu.add(about);
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Тут должно выходить окно About
            }
        });

        menuBar.add(menu);
        menuBar.add(aboutMenu);
        this.setJMenuBar(menuBar);
        JPanel gPanel = new JPanel();
        this.add(gPanel);


        ai = new AI();
        Start start = new Start();
        this.getContentPane().add(start.getSeaPlayer());
        this.getContentPane().add(start.getSeaEnemy());

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                update();

                ShotCell shot = getMousePoint(e.getPoint());

                int x = shot.getX();
                int y = shot.getY();
                if (x >= 0 && x < 10 && y >= 0 && y < 10) {

                    if (!game.shooting(sea, x, y, game.getFleet())) {
                        while (true) {
                            update();
                            int aiX = ai.aiShoot(seaAi).getX();
                            int aiY = ai.aiShoot(seaAi).getY();
                            if (!game.shooting(seaAi, aiX, aiY, game.getFleetAi())) break;
                            update();
                        }
                    }

                }


                if (game.getFleet().isEmpty()) {
                    endGame(true);
                } else if (game.getFleetAi().isEmpty()) endGame(false);

            }


            public void endGame(boolean isVictory) {
                String endGameText;
                String endGameTitle;
                if (isVictory) {
                    endGameText = "Поздравляю! Вы выиграли! Хотите начать новую игру?";
                    endGameTitle = "Победа!";
                } else {
                    endGameText = "Поражение! Вы проиграли, хотите попробовать снова?";
                    endGameTitle = "Потрачено!";
                }
                int n = JOptionPane.showConfirmDialog(
                        new JFrame(),
                        endGameText,
                        endGameTitle,
                        JOptionPane.YES_NO_OPTION);
                if (n == 0) {
                    new GameGui();
                    System.out.println("Начинаем новую игру");
                } else System.exit(0);//если не ответить да то n = 0.
            }
//при начале новой игры должно быть создан новый геймхелпер, вместе с ним должны будут созданы новые поля. Они должны будут заполнены кораблями заново.
            //необходимо создать метод, который будет это делать

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        add(textField);
    }

    class Start{


        public Start() {
            game = GameHelper.getInstance();
            sea = game.getSea();
            seaAi = game.getSeaAi();
            sp = new SeaPlayer(sea);
            se = new SeaEnemy(seaAi);
            sp.setBounds(20, 50, 250, 250);
            se.setBounds(320, 50, 250, 250);
        }

        SeaEnemy getSeaEnemy(){
            return se;
        }

        SeaPlayer getSeaPlayer(){
            return sp;
        }

    }

    public void update(){
        se.repaint();
        sp.repaint();
        this.repaint();
    }



    public void sendMessage(String string) {
        textField.setText(string);
    }





    class MenuListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           new GameGui();
        }
    }

    class ExitItem implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public ShotCell getMousePoint(Point p){
        ShotCell shotCell = new ShotCell();

        shotCell.setX((p.x - 23) / 25);
        shotCell.setY((p.y - 100) / 25);
        sendMessage(shotCell.toString()+ "\n");
        return shotCell;
    }
}
