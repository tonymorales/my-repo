import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by APecherskih on 03.09.2015.
 */
public class BattleShipFactory {

    //public HashMap<Integer, BattleShip> listOfShips = new HashMap<Integer, BattleShip>();
    ArrayList<Integer> idList = new ArrayList<Integer>();


    BattleShip newBattleShip(int type, boolean isHorizontal) {
        int idGen = idGenerator();
        // System.out.println("Создаем корабл с id  " + idGen);
        return new BattleShip(type, isHorizontal, idGen);
    }

    public HashMap createFleet() {
        HashMap<Integer, BattleShip> listOfShips = new HashMap<Integer, BattleShip>();
        //Для пробы создадим один корабль
        int k = 0;
        for (int i = 1; i < 5; i++) {
            Random rnd = new Random();
            BattleShip ship = new BattleShip(1, rnd.nextBoolean(), idGenerator());
            listOfShips.put(ship.id, ship);
            //System.out.println(k+".Создан корабль id "+ ship.id);
            k++;
        }
        for (int i = 1; i < 4; i++) {
            Random rnd = new Random();
            BattleShip ship = new BattleShip(2, rnd.nextBoolean(), idGenerator());
            listOfShips.put(ship.id, ship);
            //System.out.println(k+".Создан корабль id "+ ship.id);
            k++;
        }
        for (int i = 1; i < 3; i++) {
            Random rnd = new Random();
            BattleShip ship = new BattleShip(3, rnd.nextBoolean(), idGenerator());
            listOfShips.put(ship.id, ship);
            //System.out.println(k+".Создан корабль id "+ ship.id);
            k++;
        }
        Random rnd = new Random();
        BattleShip ship = new BattleShip(4, rnd.nextBoolean(), idGenerator());
        listOfShips.put(ship.id, ship);


        return listOfShips;

    }


    int idGenerator() {
        Random rnd = new Random();
        int idRnd = rnd.nextInt(88) + 11;
        while (idList.contains(idRnd)) {
            idRnd = rnd.nextInt(88) + 11;
        }

        return idRnd;
    }


}
