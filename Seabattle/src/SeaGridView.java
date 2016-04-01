
/**
 * Created by APecherskih on 31.08.2015.
 */
public class SeaGridView implements SeaFieldView{

    public void view(SeaGrid sea){
        System.out.println("    A B C D E F G H I J");
        System.out.println("    _ _ _ _ _ _ _ _ _ _");
        for (int i = 0; i < sea.xSize; i++) {
            if(i == 9) System.out.print(i+1+" |");
            else System.out.print(i+1+"  |");
            for (int j = 0; j < sea.ySize; j++) {
                int p = sea.grid[j][i];
                if(p>10){
                    if(!(p%2 == 0)) System.out.print("X|");
                    else System.out.print("H|");
                }
                else System.out.print(sea.grid[j][i] + "|");

            }
            System.out.println();
        }
    }



    @Override
    public void view(SeaGrid seaPlayer, SeaGrid seaAi) {
        System.out.println("        Ваше поле                 Поле противника  ");
        System.out.println("    A B C D E F G H I J         A B C D E F G H I J");

        for (int i = 0; i < seaAi.xSize; i++) {
            if(i == 9) System.out.print(i+1+"  ");
            else System.out.print(i+1+"   ");

            for (int j = 0; j < seaAi.ySize; j++) {
                int p = seaAi.grid[j][i];
                if(p>10){
                    if(!(p%2 == 0)) System.out.print("X ");
                    else System.out.print(". ");
                }

                else if(p<2) System.out.print(". ");
                else if(p == 2) System.out.print("O ");

            }

            System.out.print("    ");
            if(i == 9) System.out.print(i+1+"  ");
            else System.out.print(i+1+"   ");

            for (int j = 0; j < seaPlayer.ySize; j++) {
                int p = seaPlayer.grid[j][i];
                if(p>10){
                    if(!(p%2 == 0)) System.out.print("X ");
                    else System.out.print("H ");
                }
                else{
                    if(seaPlayer.grid[j][i] == 2) System.out.print("O ");
                    else System.out.print(". ");

                }
            }


            System.out.println();
        }
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println(msg);
    }
}
