import java.util.ArrayList;
import java.util.Scanner;

public class Interaction {
	public int[][] treasureLoctaion = new int[10][10];
	public int[][] initialPlayerLocation = new int[10][10];
	public int[][] treasureLocation = new int[10][10];
	public int[][] distanceFromPlayerToTreasure = new int[10][10];
	public int[][] currentLocation = new int[10][10];
	
	public int[][] setTreasureLocation() {
		treasureLocation[5][5]=1;
		return treasureLocation;
	}
	
	public int[][] initialPlayerLocation() {
		initialPlayerLocation[0][0]=1;
		return initialPlayerLocation;
	}
	public int[][] currentLocation(int xDir, int yDir){
		currentLocation[xDir][yDir]=1;
		return currentLocation;
	}
	
	public String distanceToTreasure(int xDistance, int yDistance) {
		treasureLoctaion=setTreasureLocation();
		currentLocation[xDistance][yDistance]=1;
		
		int totalDistance;
		int actualXDistance=0;
		int actualYDistance=0;
		
		for (int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				if (treasureLocation[i][j]==1) {
					actualXDistance=i;
					actualYDistance=j;
				}
			}
		}
		totalDistance=Math.abs((xDistance-actualXDistance)+(yDistance-actualYDistance));
		//totalDistance=actualXDistance+actualYDistance;
		return "The dial reads '"+totalDistance+"m'";
	}
	public void finalGame() {
		int currentX=0;
		int currentY=0;
		treasureLocation = setTreasureLocation();
		
		Scanner s = new Scanner(System.in);
		System.out.println("Grey foggy clouds float oppressively close to you, reflected in the murky grey water which reaches up your shins.");
		System.out.println("Try typing 'north', 'south', 'east', 'west'");
		while (treasureLocation!=currentLocation(currentX, currentY)){
			String direction = s.nextLine();
			if (direction.equals("north") && (currentY-1)>0){
				currentY=currentY-1;
				System.out.println(distanceToTreasure(currentX, currentY));
			}
			else if (direction.equals("east") && currentX+1<10 && currentX+1>0) {
				currentX=currentX+1;
				System.out.println(distanceToTreasure(currentX,currentY));
				}
			else if (direction.equals("south") && (currentY+1)<10) {
				currentY=currentY+1;
				System.out.println(distanceToTreasure(currentX, currentY));
				}
			else if(direction.equals("west") && currentX-1<10 && currentX-1>0) {
				currentX=currentX-1;
				System.out.println(distanceToTreasure(currentX, currentY));
				}
			else {
				System.out.println(distanceToTreasure(currentX, currentY));
				}
			
		}
	}
}
