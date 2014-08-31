import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuStartActivity implements ActionListener {
    private Controller controller;
    private JFrame frame;
    private MainActivity mA;
    private ScoreList scoreList;

    MenuStartActivity(JFrame frame, Controller controller, ScoreList scoreList) {
        this.frame = frame;
        this.controller = controller;
        this.scoreList = scoreList;
    }

    public void stopGame() {
        if (mA != null) {
            mA.end();
        }
    }

    public void playGameAfterStat() {
        if (mA != null && !mA.isEndedGame()) {
            mA.end();
            mA = new MainActivity(controller, frame, scoreList);
            mA.play();
        }
    }

    public void playGame() {
        if (mA != null) {
            mA.end();
        }
        mA = new MainActivity(controller, frame, scoreList);
        mA.play();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.model.newField();
        playGame();
    }
}
