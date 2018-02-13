package mattemonwumpus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BoardGenerator {
	
	/**
	 * 0 = Amonoc
	 * 1 = Mushu le dragon
	 * 2 = Puit sans fond
	 * 3 = Vent frais
	 * 4 = Odeur d'anu
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
		// entre 20% et 30% de puits :
		int nbPit = (int) Math.floor((x*y)*0.2) + (int)(Math.random() * (((x*y)*0.1) + 1));
		System.out.println(nbPit);
		map[x-1][0][0] = 1;
		for(int i = 0; i < nbPit; i++) {
			HashMap<String, Integer> pitcoords = generateNewCoords(x, y);
			map[pitcoords.get("x")][pitcoords.get("y")][2] = 1;
		}
		HashMap<String, Integer> mushuLeDragonCoords = generateNewCoords(x, y);
		map[mushuLeDragonCoords.get("x")][mushuLeDragonCoords.get("y")][1] = 1;
		HashMap<String, Integer> goldCoords = generateNewCoords(x, y);
		map[goldCoords.get("x")][goldCoords.get("y")][5] = 1;
		hadMapInformations();
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
		int xPos = 0 + (int)(Math.random() * (((maxXCoord-1) - 0)));
		int yPos = 0 + (int)(Math.random() * (((maxYCoord-1) - 0)));
		ArrayList<Integer> values = getValues(xPos,yPos);
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
	
	private void hadMapInformations() {
		for(int x = 0; x < map.length; x++) {
			for(int y = 0; y < map[x].length; y++) {
				ArrayList<Integer> values = getValues(x,y);
				if(values.contains((Integer)2)) {
					if(x != 0 && map[x-1][y][2] != 1) {
							map[x-1][y][3] = 1;
					}
					if(x != map.length - 1 && map[x+1][y][2] != 1) {
							map[x+1][y][3] = 1;
					}
					if(y != 0 && map[x][y-1][2] != 1) {
							map[x][y-1][3] = 1;
					}
					if(y != map.length - 1 && map[x][y+1][2] != 1) {
							map[x][y+1][3] = 1;
					}
				}
				if(values.contains((Integer)1)) {
					if(x != 0 && map[x-1][y][2] != 1) {
						map[x-1][y][4] = 1;
					}
					if(x != map.length - 1 && map[x+1][y][2] != 1) {
						map[x+1][y][4] = 1;
					}
					if(y != 0 && map[x][y-1][2] != 1) {
						map[x][y-1][4] = 1;
					}
					if(y != map.length - 1 && map[x][y+1][2] != 1) {
						map[x][y+1][4] = 1;
					}
				}
			}
		}
	}
	
	private void displayMap() {
		for(int x = 0; x < map.length; x++) {
			for(int y = 0; y < map[x].length; y++) {
				ArrayList<Integer> values = getValues(x,y);
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
