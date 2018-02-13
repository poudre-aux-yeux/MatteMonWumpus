package mattemonwumpus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BoardGenerator {
	
	/**
	 * 0 = Agent
	 * 1 = Mushu le dragon
	 * 2 = Puit
	 * 3 = Vent
	 * 4 = Odeur
	 * 5 = Or
	 */
	int[][][] map;
	
	public int[][][] getInstance() {
		if(map != null) {
			return map;
		}else {
			this.generateNewMap();
			return map;
		}
	}
	
	private void generateNewMap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir une longueur :");
		int x = sc.nextInt();
		System.out.println("Veuillez saisir une largeur :");
		int y = sc.nextInt();
		map = new int[x][y][6];
		int nbPit = 1 + (int)(Math.random() * (((Math.min(x,y)) - 0) + 1));
		map[x-1][0][0] = 1;
		for(int i = 0; i < nbPit; i++) {
			HashMap<String, Integer> pitcoords = generateNewCoords(x, y);
			map[pitcoords.get("y")][pitcoords.get("x")][2] = 1;
		}
		HashMap<String, Integer> mushuLeDragonCoords = generateNewCoords(x, y);
		map[mushuLeDragonCoords.get("y")][mushuLeDragonCoords.get("x")][1] = 1;
		HashMap<String, Integer> goldCoords = generateNewCoords(x, y);
		map[goldCoords.get("y")][goldCoords.get("x")][5] = 1;
		displayMap();
	}
	
	private ArrayList<Integer> getValues(int x, int y) {
		ArrayList<Integer> values = new ArrayList<>();
		for(int i = 0; i < map[x][y].length; i++) {
			if(map[x][y][i] > 0) {
				values.add(i);
			}
		}
		return values;
	}
	
	
	private HashMap<String, Integer> generateNewCoords(int maxXCoord, int maxYCoord){
		HashMap<String, Integer> newCoords;
		int xPos = 0 + (int)(Math.random() * (((maxXCoord-1) - 0) + 1));
		int yPos = 0 + (int)(Math.random() * (((maxYCoord-1) - 0) + 1));
		ArrayList<Integer> values = getValues(yPos,xPos);
		if(values.contains((Integer)0) ||
			values.contains((Integer)1) ||
			values.contains((Integer)2) ||
			values.contains((Integer)5))
		{
			newCoords = generateNewCoords(maxXCoord, maxYCoord);
		}else {
			newCoords = new HashMap<>();
			newCoords.put("x", xPos);
			newCoords.put("y", yPos);
		}
		return newCoords;
	}
	
	private void displayMap() {
		for(int y = 0; y < map.length; y++) {
			for(int i = 0; i < map[y].length; i++) {
				ArrayList<Integer> values = getValues(y,i);
				if(values.size() == 0) {
					System.out.print("[-]");
				}else {
					System.out.print(values);
				}
			}
			System.out.println("");
		}
	}
	
}
