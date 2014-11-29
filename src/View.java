public class View {

	private Kernel _kernel;

	public View(Kernel kernel) {
		_kernel = kernel;
	}

	public void updateState(State state) {
        _kernel.updateState(state);
		//drawField(state.field);
		//drawFigure(state);
	}

	private void drawFigure(State state) {
		for (int r = 0; r < state.figure.data.length; r++) {
			for (int c = 0; c < state.figure.data[r].length; c++) {
				if (state.figure.data[r][c] == 0) {
					continue;
				}

				_kernel.drawCell(state.figure.data[r][c], state.figureRow + r,
						state.figureColumn + c);
			}
		}
	}

	private void drawField(Field field) {
		for (int r = 4; r < field.box.length; r++) {
			for (int c = 0; c < field.box[r].length; c++) {
				_kernel.drawCell(field.box[r][c], r, c);
			}
		}
	}

}
