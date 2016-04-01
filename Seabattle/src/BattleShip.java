/**
 * Created by APecherskih on 24.08.2015.
 */
public class BattleShip {

    ShotCell shotCell;
    int type;
    boolean isHorizontal;
    int id;
    boolean isAlive;
    int livesCount;

    final int SINGLE_DECK = 1;
    final int DOUBLE_DECKED = 2;
    final int THREE_DECKED = 3;
    final int FOUR_DECKED = 4;

    public BattleShip(int type, boolean isHorizontal, int id) {
        this.type = type;
        this.isHorizontal = isHorizontal;
        this.id = id;
        this.isAlive = true;
        this.livesCount = type;
    }
}
