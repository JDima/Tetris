import javax.swing.*;
import java.awt.*;

public class JavaKernel implements Kernel {

	static private Color[] colors = { Color.black, Color.blue, Color.yellow,
			Color.red, Color.green, Color.orange };
	private static final int CELL_SIZE = 30;
    private static final int FIGURE_SIZE = 4;
	private JPanel _panel;
    private State _state;
    private boolean isEnded;
    public JPanel getPanel() {
        return _panel;
    }

    public JavaKernel() {
        //_state = new State();
        isEnded = true;
		_panel = new JPanel()
        {
            @Override
            public void paint(Graphics g) {
                if (!isEnded) {
                    Graphics2D g2d = (Graphics2D) g;
                    for (int r = 4; r < _state.field.box.length; r++) {
                        for (int c = 0; c < _state.field.box[r].length; c++) {
                            g2d.setColor(colors[_state.field.box[r][c]]);
                            g2d.fillRect(c * CELL_SIZE, (r - FIGURE_SIZE)* CELL_SIZE, CELL_SIZE, CELL_SIZE);
                        }
                    }
                    for (int r = 0; r < _state.figure.data.length; r++) {
                        for (int c = 0; c < _state.figure.data[r].length; c++) {
                            if (_state.figure.data[r][c] == 0) {
                                continue;
                            }
                            g2d.setColor(colors[_state.figure.data[r][c]]);
                            int fr = _state.figureRow + r;
                            int fc = _state.figureColumn + c;
                            g2d.fillRect(fc * CELL_SIZE, (fr - FIGURE_SIZE)* CELL_SIZE, CELL_SIZE, CELL_SIZE);
                        }
                    }

                    if (g2d != null)
                        g2d.dispose();
                    //super.paint(g2d);
                } else {
                    super.paint(g);
                }
            }

        };
        //_panel.setPreferredSize(new Dimension(270, 620));
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

    @Override
    public void updateState(State state) {
        if (!isEnded) {
            _state = state;
            _panel.repaint();
        }
    }

    public void gameEnded(boolean isEnded) {
        this.isEnded = isEnded;
    }


}
