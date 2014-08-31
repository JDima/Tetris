import javax.swing.*;
import java.awt.*;

public class JavaKernel implements Kernel {

	static private Color[] colors = { Color.black, Color.blue, Color.yellow,
			Color.red, Color.green, Color.orange };
	private static final int CELL_SIZE = 30;
    private static final int FIGURE_SIZE = 4;
	private JPanel _panel;
	
	public JavaKernel(JPanel panel) {
		_panel = panel;
	}
	
	@Override
	public void drawCell(int colorIndex, int r, int c) {
		Graphics2D g = (Graphics2D) _panel.getGraphics();
		g.setColor(colors[colorIndex]);
		try {
			g.fillRect(c * CELL_SIZE, (r - FIGURE_SIZE)* CELL_SIZE, CELL_SIZE, CELL_SIZE);
		} finally {
			if (g != null)
				g.dispose();
		}

	}

}
