import java.util.ArrayList;
import java.util.Collections;
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
	
	public void moveRight(){
		condenseRight();
		addRight();
	}
	
	public void condenseRight(){
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				if(board.get(i).get(j) == 0){
					board.get(i).remove(j);
					board.get(i).add(0, 0);
				}
			}
		}
	}
	
	public void addRight(){
		
	}
	
	public void moveLeft(){
		condenseLeft();
		addLeft();
	}
	
	public void condenseLeft(){
		for(int i = 0; i < 5; i++){
			board.get(i).removeAll(Collections.singleton(0));
			int tempSize = board.get(i).size();
			for(int j = tempSize; j < 5; j++){
				board.get(i).add(j, 0);
			}
		}
	}
	
	public void addLeft(){
		
	}
	
	public void moveDown(){
		condenseDown();
		addDown();
	}
	
	public void condenseDown(){
		ArrayList<Integer> tempCollum;
		for(int i = 0; i < 5; i++){
			tempCollum = new ArrayList<Integer>();
			for(int j = 0; j < 5; j++){
				tempCollum.add(board.get(j).get(i));
			}
			for(int j = 0; j < 5; j++){
				if(tempCollum.get(j) == 0){
					tempCollum.remove(j);
					tempCollum.add(0, 0);
				}
			}
			for(int j = 0; j < 5; j++){
				board.get(j).set(i, tempCollum.get(j));
			}
		}
	}
	
	public void addDown(){
		
	}
	
	public void moveUp(){
		condenseUp();
		addUp();
	}
	
	public void condenseUp(){
		ArrayList<Integer> tempCollum;
		for(int i = 0; i < 5; i++){
			tempCollum = new ArrayList<Integer>();
			for(int j = 0; j < 5; j++){
				tempCollum.add(board.get(j).get(i));
			}
			tempCollum.removeAll(Collections.singleton(0));
			int tempSize = tempCollum.size();
			for(int j = tempSize; j < 5; j++){
				tempCollum.add(j, 0);
			}
			for(int j = 0; j < 5; j++){
				board.get(j).set(i, tempCollum.get(j));
			}
		}
	}
	
	public void addUp(){
		
	}
	
	public ArrayList<ArrayList<Integer>> getBoard(){
		return board;
	}

}
