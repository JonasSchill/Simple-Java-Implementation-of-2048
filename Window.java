import javax.swing.JFrame;

/**
 * 
 * @author Jonas Schill
 *
 */
public class Window extends JFrame {
	
    public Window() {

        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setTitle("Simple Java Implementation of 2048 by Jonas Schill");
        setResizable(false);
        setVisible(true);
    }
    
    

    public static void main(String[] args) {
        new Window();
    }
}
