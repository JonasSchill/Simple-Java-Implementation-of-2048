import java.util.ArrayList;
import java.util.Random;

public class state {
	private ArrayList<ArrayList<Integer>> board;
	
	public state(){
	board = new ArrayList<ArrayList<Integer>>();
	setUp();
	}
	
	public void setUp(){
		ArrayList<Integer> tempRow;
		Integer tempCell;
		for(int i = 0; i < 5; i++){
			tempRow = new ArrayList<Integer>();
			for(int j = 0; j < 5; j++){
				tempCell = new Integer(0);
				tempRow.add(tempCell);
			}
			board.add(tempRow);
		}
		spawnCell();
		spawnCell();
	}
	
	public void spawnCell(){
		int[] cord = getRandomEmptyCord();
		if(Math.random() < 0.5){
			board.get(cord[0]).set(cord[1], 2);
		} else {
			board.get(cord[0]).set(cord[1], 4);
		}
	}
	
	public int[] getRandomEmptyCord(){
		ArrayList<int[]> emptyCords = new ArrayList<int[]>();
		int[] tempCord;
		Random randomGenerator = new Random();
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				if(board.get(i).get(j) == 0){
					tempCord = new int[2];
					tempCord[0] = i;
					tempCord[1] = j;
					emptyCords.add(tempCord);
				}
			}
		}
		return emptyCords.get(randomGenerator.nextInt(emptyCords.size()));
	}
	
	public ArrayList<ArrayList<Integer>> getBoard(){
		return board;
	}

}
