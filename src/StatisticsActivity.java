import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticsActivity implements ActionListener{
    private MenuStartActivity mA;
    private ScoreList scoreList;

    StatisticsActivity(MenuStartActivity mA, ScoreList scoreList) {
        this.mA = mA;
        this.scoreList = scoreList;
    }

    private void scoreListBox() {
        StringBuilder sb = new StringBuilder();
        sb.append("Score list: \n");
        int i = 0;
        for (String user : scoreList.players) {
            if (user == null) {
                break;
            }
            sb.append(user + " - " + scoreList.scores[i++] + "\n");
        }
        JOptionPane.showMessageDialog(null, sb);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        mA.stopGame();
        scoreListBox();
        mA.playGameAfterStat();
    }
}
