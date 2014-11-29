import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuStartActivity implements ActionListener {
    private Controller controller;
    private JFrame frame;
    private MainActivity mA;
    private ScoreList scoreList;
    private Kernel kernel;

    MenuStartActivity(JFrame frame, Controller controller, ScoreList scoreList, Kernel kernel) {
        this.frame = frame;
        this.controller = controller;
        this.scoreList = scoreList;
        this.kernel = kernel;
    }

    public void stopGame() {
        if (mA != null) {
            mA.end();
        }
    }

    public void playGameAfterStat() {
        if (mA != null && !mA.isEndedGame()) {
            mA.end();
            mA = new MainActivity(controller, frame, scoreList, kernel);
            mA.play();
        }
    }

    public void playGame() {
        if (mA != null) {
            mA.end();
        }
        mA = new MainActivity(controller, frame, scoreList, kernel);
        mA.play();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.model.newField();
        playGame();
    }
}
