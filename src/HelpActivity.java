import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HelpActivity implements ActionListener{
    private MenuStartActivity mA;
    private ScoreList scoreList;

    HelpActivity(MenuStartActivity mA, ScoreList scoreList) {
        this.mA = mA;
        this.scoreList = scoreList;
    }

    private void scoreListBox() {
        StringBuilder sb = new StringBuilder();
        sb.append("Instruction: \n");
        sb.append("Menu bar item New game - create new game. \n");
        sb.append("Menu bar item Statistics - show score list. \n");
        sb.append("Button up arrow - rotate figure. \n");
        sb.append("Button down arrow - speed up figure. \n");
        sb.append("Button left arrow - move figure left. \n");
        sb.append("Button right arrow - move figure right. \n");

        JOptionPane.showMessageDialog(null, sb, "Help", JOptionPane.INFORMATION_MESSAGE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        mA.stopGame();
        scoreListBox();
        mA.playGameAfterStat();
    }
}
