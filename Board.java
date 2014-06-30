import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JPanel{

    private State state;

    public Board() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);
        
        state = new State();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setFont((new Font("TimesRoman", Font.PLAIN, 25)));
        ArrayList<ArrayList<Integer>> board = state.getBoard();
        
        for(int i = 0; i < 5; i++){
        	for(int j = 0; j < 5; j++){
        		if(board.get(i).get(j) == 2){
        			g.setColor(Color.DARK_GRAY);
        		} else if(board.get(i).get(j) == 4){
        			g.setColor(Color.GRAY);
        		} else if(board.get(i).get(j) == 8){
        			g.setColor(Color.LIGHT_GRAY);
        		} else if(board.get(i).get(j) == 16){
        			g.setColor(Color.BLUE);
        		} else if(board.get(i).get(j) == 32){
        			g.setColor(Color.CYAN);
        		} else if(board.get(i).get(j) == 64){
        			g.setColor(Color.RED);
        		} else if(board.get(i).get(j) == 128){
        			g.setColor(Color.ORANGE);
        		} else if(board.get(i).get(j) == 256){
        			g.setColor(Color.YELLOW);
        		} else if(board.get(i).get(j) == 512){
        			g.setColor(Color.MAGENTA);
        		} else if(board.get(i).get(j) == 1024){
        			g.setColor(Color.PINK);
        		}
        		g.drawString(board.get(i).get(j).toString(), j*100+100, i*100+100);
        		g.setColor(Color.BLACK);
        	}
        } 
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    private class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            state.keyPressed(e);
            repaint();
            ArrayList<ArrayList<Integer>> board = state.getBoard();
            for(int i = 0; i < 5; i++){
            	for(int j = 0; j < 5; j++){
            		if(board.get(i).get(j) == 8){
            		        int option = JOptionPane.showConfirmDialog(null, "you win play again?", "you win", JOptionPane.YES_NO_OPTION);
            		       	if(option == 0){
            		      		state = new State();
            		       	} else if(option == 1){
            		       		System.exit(0);
            		       	}
            		}
            	}
            }
            if(state.getRandomEmptyCord().equals(null)){
            	int option = JOptionPane.showConfirmDialog(null, "you lose play again?", "you lose", JOptionPane.YES_NO_OPTION);
		       	if(option == 0){
		      		state = new State();
		       	} else if(option == 1){
		       		System.exit(0);
		       	}
            }
            repaint();
        }
    }
}
