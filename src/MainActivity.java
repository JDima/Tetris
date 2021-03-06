import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class MainActivity {
    private ScheduledExecutorService service;
    private Controller controller;
    private JFrame frame;
    private ScoreList scoreList;
    private Kernel kernel;
    private boolean isEnded;

    MainActivity(final Controller controller, JFrame frame, ScoreList scoreList, Kernel kernel) {
        service =
                Executors.newSingleThreadScheduledExecutor();
        this.frame = frame;
        this.controller = controller;
        this.scoreList = scoreList;
        this.kernel = kernel;
    }

    public void play() {
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    isEnded = false;
                    kernel.gameEnded(isEnded);
                    int score = controller.getScore();
                    frame.setTitle("Score is " + score);
                    controller.slideDownOneRow();
                }catch (Exception e) {
                    isEnded = true;
                    kernel.gameEnded(isEnded);
                    service.shutdown();
                    gameOverBox(controller.getScore());
                }
            }
        }, 500, 200, TimeUnit.MILLISECONDS);
    }

    public boolean isEndedGame() {
        return isEnded;
    }

    public void end() {
        if (service != null) {
            service.shutdown();
        }
    }

    private void gameOverBox(int nowScore) {
        JOptionPane.showMessageDialog(null, "Game over! You score is " + nowScore + " points!", "The End", JOptionPane.INFORMATION_MESSAGE);
        String nickname;
        while ((nickname = JOptionPane.showInputDialog(null, "Enter your nickname","Save result", JOptionPane.INFORMATION_MESSAGE)).isEmpty())
            JOptionPane.showMessageDialog(null, "Incorrect nickname!", "Error", JOptionPane.INFORMATION_MESSAGE);;
        int i = 0, cI = -1;
        for (int score : scoreList.scores) {
            if (score <= nowScore) {
                cI = i;
                break;
            }
            i++;
        }
        if (cI != -1) {
            for (int j = 4; j >= cI + 1; j--) {
                scoreList.scores[j] = scoreList.scores[j - 1];
                scoreList.players[j] = scoreList.players[j - 1];
            }
            scoreList.scores[cI] = nowScore;
            scoreList.players[cI] = nickname;
            scoreList.writeNewList();
        }
    }
}
