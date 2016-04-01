import java.util.*;

/**
 * Created by Антон on 30.08.2015.
 */
public class GameHelper {
    String name;
    static int turns;
    private static HashMap<Integer, BattleShip> fleet;
    private static HashMap<Integer, BattleShip> fleetAi;
    static GameHelper instance;
    SeaGrid sea;
    SeaGrid seaAi;

    public static HashMap<Integer, BattleShip> getFleet() {
        return fleet;
    }

    public static HashMap<Integer, BattleShip> getFleetAi() {
        return fleetAi;
    }

    private GameHelper() {
        turns = 0;
        sea = new SeaGrid();
        BattleShipFactory bf = new BattleShipFactory();
        fleet = bf.createFleet();
        mountFleet(sea, fleet);

        seaAi = new SeaGrid();
        BattleShipFactory bfAi = new BattleShipFactory();
        fleetAi = bfAi.createFleet();
        mountFleet(seaAi, fleetAi);
        AI ai = new AI(); // Экземпляр объекта компьютер, позволяет ему стрелять, не знаю пока место ему здесь или в гуи
        //view.view(sea);
        //Далее раньше шли ходы, до тех пор, пока один из флотов не будет пустым

    }

    public SeaGrid getSea() {
        return sea;
    }

    public SeaGrid getSeaAi() {
        return seaAi;
    }

    //    private GameHelper() {
//        turns = 0;
//        SeaGrid sea = new SeaGrid();
//        BattleShipFactory bf = new BattleShipFactory();
//        fleet = bf.createFleet();
//        mountFleet(sea, fleet);
//        SeaGridView view = new SeaGridView();
//
//        SeaGrid seaAi = new SeaGrid();
//        BattleShipFactory bfAi = new BattleShipFactory();
//        fleetAi = bfAi.createFleet();
//        mountFleet(seaAi, fleetAi);
//        AI ai = new AI();
//        //view.view(sea);
//        while (!fleet.isEmpty() || !fleetAi.isEmpty()) {
//            view.view(seaAi, sea);
//            turns++;
//            view.sendMessage("Ход: " + turns);
//            //System.out.println("Ход: " + turns);
//
//            boolean res = true;
//            while (res) {
//                view.sendMessage("Ход игрока");
//                //System.out.println("Ход игрока");
//                int[] xy = new int[2];
//                xy = KeyInput.getInput();
//                res = shooting(sea, xy[0], xy[1], fleet);
//                if (res) view.view(seaAi, sea);
//            }
//            //Ход компа
//            boolean res2 = true;
//            while (res2) {
//                view.sendMessage("Ход соперника");
//                ShotCell shotShotCell = ai.aiShoot(sea);
//                res2 = shooting(seaAi, shotShotCell.x, shotShotCell.y, fleetAi);
//                if (res2) view.view(seaAi, sea);
//            }
//        }
//        if (fleet.isEmpty()) view.sendMessage("Ваш флот разгромлен! Соперник победил!");
//        else view.sendMessage("Поздравляю, вы победили!");
//        view.sendMessage("Игра окончена за " + turns + " ходов");
//
//    }

    static GameHelper getInstance() {
        if (instance == null) {
            instance = new GameHelper();
        }
        return instance;
    }

    static GameHelper newGame(){

        return new GameHelper();
    }


    public ShotCell xyGen(SeaGrid grid, BattleShip ship) {
        ShotCell shotCell = new ShotCell();
        Random rnd = new Random();
        boolean setResult = false;
        while (!setResult) {
            int x = rnd.nextInt(9);
            int y = rnd.nextInt(9);
            shotCell.setX(x);
            shotCell.setY(y);
            setResult = grid.canSetShip(shotCell, ship);
        }

        return shotCell;
    }

    public void mountFleet(SeaGrid sea, HashMap<Integer, BattleShip> listOfShips) {
        Set<Map.Entry<Integer, BattleShip>> set = listOfShips.entrySet();
        for (Map.Entry<Integer, BattleShip> me : set) {
            BattleShip ship = me.getValue();
            sea.mountShip(xyGen(sea, ship), me.getValue());

        }
        System.out.println("Флот готов!");

    }

    public boolean shooting(SeaGrid sea, int x, int y, HashMap<Integer, BattleShip> fleet) {
        boolean result = false;
        int gridVol = sea.grid[x][y];
        if (gridVol == sea.blockCell || gridVol == sea.emptyCell) {
            System.out.println("Мимо!");
            sea.grid[x][y] = sea.shootCell;
        } else if (gridVol == sea.shootCell) System.out.println("Вы уже стреляли в это место");
        else {
            if (gridVol % 10 > 0) System.out.println("Вы уже побили эту часть корабля, ничего не выйдет!");
            else {
                System.out.print("Отлично! Вы подбили часть корабля! ");
                int id = gridVol / 100;
                System.out.println(id);
                fleet.get(id).livesCount--;
                sea.grid[x][y]++;
                result = true;
                if (fleet.get(id).livesCount < 1) {
                    System.out.println("Поздравляю, корабль потоплен!");
                    sea.markBlankPoints(fleet.get(id));
                    fleet.get(id).isAlive = false;
                    fleet.remove(id);
                }

            }

        }
        return result;
    }

    public boolean isFleetEmpty(HashMap<Integer, BattleShip> fleet){
        return fleet.isEmpty();
    }

}
