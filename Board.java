import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
        
        for(int i = 0; i < 5; i++){
        	for(int j = 0; j < 5; j++){
        		g.drawString(state.getBoard().get(i).get(j).toString(), j*100+100, i*100+100);
        	}
        }
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    private class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            state.keyPressed(e);
            repaint();
        }
    }
}
