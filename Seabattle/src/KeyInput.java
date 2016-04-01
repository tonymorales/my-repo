import java.lang.invoke.SwitchPoint;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by APecherskih on 10.09.2015.
 */
public class KeyInput {

    private KeyInput() {
    }

    public static int[] getInput() {
        int x = -1;
        int y = -1;
        int[] keys = new int[2];
        System.out.println("Введите координаты через пробел:");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine();
            String[] playerShot = str.split(" ");
            try
            {
            x = chars(playerShot[0]);
             y = Integer.parseInt(playerShot[1])-1;
            }
            catch (ArrayIndexOutOfBoundsException ex){
                System.out.println("Данные введены неверно");
                continue;
            }

            if(x<0 || x>10 || y<0 || y>10){
                System.out.println("Данные введены неверно");
                continue;
            }
            else {
                keys[0] = x;
                keys[1] = y ;
            }
            return keys;
        }
    }

    private static int chars(String str){

       int x = -1;
        char a = str.toLowerCase().toCharArray()[0];
        if(a == 'a' ) x = 0;
        else if(a == 'b' ) x = 1;
        else if(a == 'c' ) x = 2;
        else if(a == 'd' ) x = 3;
        else if(a == 'e' ) x = 4;
        else if(a == 'f' ) x = 5;
        else if(a == 'g' ) x = 6;
        else if(a == 'h' ) x = 7;
        else if(a == 'i' ) x = 8;
        else if(a == 'j' ) x = 9;

        /*switch(str.toLowerCase().toCharArray()[0]){  // Не могу понять почему не работает. Нужно будет разобраться.
            case 'a': x = 0;
            case 'b': x = 1;
            case 'c': x = 2;
            case 'd': x = 3;
            case 'e': x = 4;
            case 'f': x = 5;
            case 'g': x = 6;
            case 'h': x = 7;
            case 'i': x = 8;
            case 'j': x = 9;

        }*/

        return x;
    }




}
