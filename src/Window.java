import javax.swing.*;

public class Window extends JFrame {

    static JFrame jf;
    static JPanel main;
    static JPanel help;
    static JPanel oneplayer;
    static JPanel twoplayer;


    public static void main(String[] args) {
        Window w = new Window();
        w.init();
    }

    private void init() {

        jf = new JFrame();
        main= new Main();
        help  = new Help();
        oneplayer = new OnePlayer();
        twoplayer = new TwoPlayer();

        main.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setSize(600, 400);


    }
}
