import javax.swing.*;

public interface Kernel {

	void drawCell(
            int colorIndex,
            int row, int col);

    void updateState(State state);
    JPanel getPanel();
    void gameEnded(boolean isEnded);
}
