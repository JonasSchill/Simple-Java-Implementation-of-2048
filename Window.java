import javax.swing.JFrame;

public class Window extends JFrame {

    public Window() {

        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setTitle("2048");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Window();
    }
}
