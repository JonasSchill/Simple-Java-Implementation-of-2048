import java.util.ArrayList;

public class State{
  private ArrayList<ArrayList<Integer>> board;
  
  public State(){
    board = new ArrayList<ArrayList<Integer>>();
    setUp();
  }
  
  public void setUp(){
    //fill board with all 0's
    spawnCell();
    spawnCell();
  }
  
  public void spawnCell(){
    int[] cord = getRandomEmptyCord();
    //put a 2 or 4 in a random spot of board with a zero calls of getRandomEmptyCord
  }
  
  public int[] getRandomEmptyCord(){
    int[] cord = new int[2];
    //get a random empty cord
    return cord;
  }
}
