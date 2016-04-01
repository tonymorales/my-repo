/**
 * Created by Антон on 30.08.2015.
 */
public class SeaGrid {

    int xSize = 10;
    int ySize = 10;
    int[][] grid;
    int emptyCell = 0;
    int blockCell = 1;
    int shootCell = 2;

    public SeaGrid() {  //Создаем пустое поле

        grid = new int[xSize][ySize];
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                grid[i][j] = 0;
            }

        }
        System.out.println("Игровое поле создано");
    }

    public void mountShip(ShotCell shotCell, BattleShip ship) {
        ship.shotCell = shotCell;
        if (ship.isHorizontal) {
            for (int j = shotCell.getY() - 1; j < shotCell.getY() + 2; j++) {
                for (int i = shotCell.getX() - 1; i < shotCell.getX() + ship.type + 1; i++) {
                    if (i >= 0 && i < xSize && j >= 0 && j < ySize) grid[i][j] = blockCell;
                }
            }
            for (int i = 0; i < ship.type; i++) {
                grid[shotCell.getX() + i][shotCell.getY()] = Integer.parseInt("" + ship.id + i + 0);
            }
        } else {
            for (int j = shotCell.getX() - 1; j < shotCell.getX() + 2; j++) {
                for (int i = shotCell.getY() - 1; i < shotCell.getY() + ship.type + 1; i++) {
                    if (i >= 0 && i < xSize && j >= 0 && j < ySize) grid[j][i] = blockCell;
                }
            }
            for (int i = 0; i < ship.type; i++) {
                grid[shotCell.getX()][shotCell.getY() + i] = Integer.parseInt("" + ship.id + i + 0);
            }
        }
    }

    public void markBlankPoints(BattleShip ship) {
        if (ship.isHorizontal) {
            for (int j = ship.shotCell.getY() - 1; j < ship.shotCell.getY() + 2; j++) {
                for (int i = ship.shotCell.getX() - 1; i < ship.shotCell.getX() + ship.type + 1; i++) {
                    if (i >= 0 && i < xSize && j >= 0 && j < ySize) grid[i][j] = shootCell;
                }
            }
            for (int i = 0; i < ship.type; i++) {
                grid[ship.shotCell.getX() + i][ship.shotCell.getY()] = Integer.parseInt("" + ship.id + i + 1);

            }
        } else {
            for (int j = ship.shotCell.getX() - 1; j < ship.shotCell.getX() + 2; j++) {
                for (int i = ship.shotCell.getY() - 1; i < ship.shotCell.getY() + ship.type + 1; i++) {
                    if (i >= 0 && i < xSize && j >= 0 && j < ySize) grid[j][i] = shootCell;
                }
            }

            for (int i = 0; i < ship.type; i++) {
                grid[ship.shotCell.getX()][ship.shotCell.getY() + i] = Integer.parseInt("" + ship.id + i + 1);

            }
        }
    }


    public boolean canSetShip(ShotCell shotCell, BattleShip ship) {
        // System.out.println("Проверяем возможность установки по координатам " + point.x +"-"+ point.y + " корабль " + ship.id);

        if (ship.isHorizontal) {
            for (int i = shotCell.getX(); i < shotCell.getX() + ship.type; i++) {
                if (!isEmptyCell(i, shotCell.getY())) return false;
            }
        } else {
            for (int i = shotCell.getY(); i < shotCell.getY() + ship.type; i++) {
                if (!isEmptyCell(shotCell.getX(), i)) return false;
            }
        }
        return true;
    }


    private boolean isEmptyCell(int x, int y) {
        if (x >= 0 && x < xSize && y >= 0 && y < ySize) {
            if (grid[x][y] == emptyCell) {
                //  System.out.println("Значение " + grid[x][y] + " на клетке " + x + "-" + y + ". Чисто!");
                return true;
            }
        }
        return false;
    }

}
