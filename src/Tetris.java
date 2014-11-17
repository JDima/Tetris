import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Tetris {

    public static void main(String[] args) {


        JFrame frame = new JFrame("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(270, 620));

        frame.add(panel);

        frame.pack();

        Kernel kernel = new JavaKernel(panel);

        Model model = new Model();
        View view = new View(kernel);
        ScoreList scoreList = new ScoreList("ScoreList.xls");
        final Controller controller = new Controller(model, view);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    controller.moveLeft();
                }

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    controller.moveRight();
                }

                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    controller.rotate();
                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    controller.dropDown();
                }
            }

        });
        MenuStartActivity mA = new MenuStartActivity(frame, controller, scoreList);
        StatisticsActivity sA = new StatisticsActivity(mA, scoreList);
        HelpActivity hA = new HelpActivity(mA, scoreList);

        JMenuBar mb = new JMenuBar();

        JMenuItem newGame = new JMenuItem("New game");
        newGame.setMnemonic(KeyEvent.VK_N);
        newGame.addActionListener(mA);
        mb.add(newGame);

        JMenuItem scoreListItem = new JMenuItem("Statistics");
        scoreListItem.setMnemonic(KeyEvent.VK_S);
        scoreListItem.addActionListener(sA);
        mb.add(scoreListItem);

        JMenuItem helpItem = new JMenuItem("Help");
        helpItem.setMnemonic(KeyEvent.VK_H);
        helpItem.addActionListener(hA);
        mb.add(helpItem);


        frame.setJMenuBar(mb);
        frame.setVisible(true);
    }

}
