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
    int u_x;
    int u_y;    
    static int x;
    static int y;
    BoardGenerator board;
    BoardGenerator boardAmonok;
    
    public void test () {
        System.out.println("elo");
    }
    
    public AmonokBouge(int [][][] p_map, int x, int y){
        map = p_map;
        u_x = y;
        u_y = x;
        board = new BoardGenerator(map, u_x, u_y);
        moveAmonok = new int[board.getU_x()][board.getU_y()][6];
        boardAmonok = new BoardGenerator(moveAmonok, u_x, u_y);
    }
         
    public void AmonokStart(){
   //     int xy[] = new int[2];
        int result = 99;
        
        while(result != 0){
//            if (result != 3 && result != 4 && result != 34){
//                AmonokRandomMove();        
//            }            
//            if (result == 3){
//                AmonokMove(3);
//            }
//            if (result == 4){
//                AmonokMove(4);
//            }
//            if (result == 34){
//                AmonokMove(34);
//            }
                AmonokRandomMove(); 
                System.out.println("x :" + x + " y : " + y);
//                AmonokRandomMove(); 
//            }
            
            //result = AmonokResultMove(xy[0], xy[1]);
            result = AmonokResultMove();
        }                     
         System.out.println("pt arret");            
    }
    
    private boolean getBool(){
        Random r = new Random();
        //0 = valeur min, 10 = valeur max
        int i = 0 + r.nextInt(10 - 0);
                
        if(i < 4) {
            return true;
        } else {
            return false;
        }
    }
    
    private void AmonokRandomMove(){
        boolean valueRandom;
        int xTest = x+1;
        int yTest = y+1;
 //       int xy[] = new int [2];
               
        valueRandom = getBool();
        if(valueRandom == true){
            if (xTest < u_x){
                x += 1;
            }else{
             if (yTest < u_y)   {
                y += 1;
             }
            }            
        } else{
            if (yTest < u_y){
                y += 1;                
            }else{
             if (xTest < u_x)   {
                x += 1;
             }
            } 
        }
   //     xy[0] = x;
    //    xy[1] = y;
        moveAmonok[x][y][0] = 1;
        //return xy;
    }
    
    //private int AmonokResultMove(int x, int y){
    private int AmonokResultMove(){
        int result = 0;
        ArrayList<Integer> values = board.getValues(x,y);
        
        for (int i = 0; i < values.size(); i++) {
            switch (values.get(i)){
                case 1:
                    moveAmonok[x][y][1] = 1;
                    break;
                case 2:
                    moveAmonok[x][y][2] = 1;
                    break;
                case 3:
                    moveAmonok[x][y][3] = 1;
                    break;
                case 4:
                    moveAmonok[x][y][4] = 1;
                    break;     
                case 5:
                    moveAmonok[x][y][5] = 1;
                    break; 
            }
        }
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
              System.out.println("Vent frais");
            result = 3;
        }
           if(values.contains(4)){
               System.out.println("Odeur");
            result = 4;
        }
        if (values.contains(3) && values.contains(4)){
            System.out.println("Vent frais + odeur");
            result = 34; 
        }
        
        return result;
    }
    
    //Gérer les cas de vents, d'odeur, etc.
    private void AmonokMove(){
        
        
        
    }
    
}
