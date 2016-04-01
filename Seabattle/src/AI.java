import java.util.ArrayList;
import java.util.Random;

/**
 * Created by APecherskih on 11.09.2015.
 */
public class AI {
    ArrayList<ShotCell> shotShotCells = new ArrayList<ShotCell>();

    public ShotCell aiShoot(SeaGrid sea){
        ShotCell p = null;
        if(shotShotCells.isEmpty()){
            Random rnd = new Random();
            while (true){
                p = new ShotCell(rnd.nextInt(9), rnd.nextInt(9));
                if(sea.grid[p.getX()][p.getY()] < 2 || (sea.grid[p.getX()][p.getY()] < 10 && sea.grid[p.getX()][p.getY()]%2 == 0)){
                    break;
                }
            }
        }

        return p;
    }


    /*
    Алгоритм работы ИИ. Чтобы не забыть. Из начальных условий мы имеем два массива. Один с отстрелянными точками, другой с наиболее вероятными.
    Начнем. При выстреле мы генерируем случайные координаты. Затем мы проверяем их на совпадение с границами поля и на отсутствие
    данного значения в массиве стрелянных ячеек. Далее при неудачном попадании мы добывляем точку в массив стрелянных. Т.е. нам необходим
    метод, который будет получать результативность выстрела. Самое интересное начинается во время результативого выстрела. Тут необходимо учесть
    палубность корабля, т.е.ИИ необходимо проверять тот момент, что выстрел был результативным но корабль подбит. Сейчас мы это все обрисуем.
    При попадании метод goodShot(Point p) получает значение координаты ячейки р. Далее в этом методе необходимо определить какие из точек рядом могут быть
    потенциально следующей часть корабля.
    1. Проверяем сколько осталось жизней у корабля. Если они еще есть, то можно выбирать следующую точку.
    2. Если жизней больше нет, то ничего не заносим в спиок вероятный попаданий. Зато необходимо занести в список отстрелянны все точки вокруг корабля
    над этим необходимо подумать!!!
    3. РАссмотрим случай, что значение количества жизнекй у кораля отлично от нуля. Тогда берем точку ч+1 и сначала проверяем на попадания
    в границы поля, затем в нахождении этого значения в массиве стрелянных. Если и там и там точки нет, то она попадает в массив вероятностей.
    Далее проводим аналогичное с точками х-1, y+1? y-1;
    4. При следующем выстреле необходимо знать предыдущий. Если происходит попадание, то значит необходимо уточнить как из координать остались прежними.
    Если y, то продалжаем прибавлять или убавлять Х или наоборот. Пока корабль не будет унечтожен. Тогда из вероятночтного массима убиратся все возможные точки.
    Технически можно очистить массив,, но тогда вероятно остенутся нетронутые адреса. хз, надо подумать. Ч мспать.
     */
}
