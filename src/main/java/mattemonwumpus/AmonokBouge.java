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
        boolean valueRandom;
        int x = 0;
        int y = 0;
                
        valueRandom = getBool();
        if(valueRandom == true){
            x += 1;
        } else{
            y += 1;
        }
        
        ArrayList<Integer> values = board.getValues(x,y);
      
    }
    
    private boolean getBool(){
        int i = new Random().nextInt(10);
        if(i < 4) {
            return true;
        } else {
            return false;
        }
    }
    
    
}
