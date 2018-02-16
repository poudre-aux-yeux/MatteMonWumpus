/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mattemonwumpus;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mushu
 */
public class AmonokBouge {
    
    int[][][] map;
    int[][][] moveAmonok;
    BoardGenerator board = new BoardGenerator(map);
    
        
    public void test () {
        System.out.println("elo");
    }
    
    public AmonokBouge(int [][][] p_map){
        map = p_map;
    }
         
    public void AmonokStart(){
        int xy[] = new int[2];
        int result = 99;
        
        while(result != 0){
            if (result != 3 && result != 4 && result != 34){
                xy = AmonokRandomMove();        
            }            
            if (result == 3){
                xy = AmonokMove(3);
            }
            if (result == 4){
                xy = AmonokMove(4);
            }
            if (result == 34){
                xy = AmonokMove(34);
            }
            result = AmonokResultMove(xy[1], xy[2]);
        }                     
                     
    }
    
    private boolean getBool(){
        int i = new Random().nextInt(10);
        if(i < 4) {
            return true;
        } else {
            return false;
        }
    }
    
    private int[] AmonokRandomMove(){
        boolean valueRandom;
        int x = 0;
        int y = 0;
        int xy[] = new int [2];
                
        valueRandom = getBool();
        if(valueRandom == true){
            x += 1;
            moveAmonok[x][y][0] = 0;
            xy[1] = x;
        } else{
            y += 1;
            moveAmonok[x][y][0] = 0;
            xy[2] = x;
        }
        return xy;
    }
    
    private int AmonokResultMove(int x, int y){
        int result = 0;
        ArrayList<Integer> values = board.getValues(x,y);
        if(values.contains(1)){
            System.out.println("Vous vous êtes fait dévorer par Mushu le Draaagon !");
            return 0;
        }
         if(values.contains(2)){            
            System.out.println("Vous tombez dans un puit sans fond, game over..");
            return 0;
        }
        if(values.contains(5)){            
            System.out.println("Vous avez trouvé l'or !");
            return 0;
        }
          if(values.contains(3)){
            result = 3;
        }
           if(values.contains(4)){
            result = 4;
        }
        if (values.contains(3) && values.contains(4)){
            result = 34;
        }
            
        for (int i = 0; i < values.size(); i++) {
            switch (values.get(i)){
                case 1:
                    moveAmonok[x][y][1] = 1;
                    break;
                case 2:
                    moveAmonok[x][y][2] = 2;
                    break;
                case 3:
                    moveAmonok[x][y][3] = 3;
                    break;
                case 4:
                    moveAmonok[x][y][4] = 4;
                    break;     
                case 5:
                    moveAmonok[x][y][5] = 5;
                    break; 
            }
        }
        return result;
    }
    
    //Gérer les cas de vents, d'odeur
    private int[] AmonokMove(int v){
        int xy[] = new int [2];
        
        
        
        return xy;
    }
}
