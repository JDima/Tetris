public class Logic implements EventProcessor {

	public State state;

	public Logic(State state) {
		this.state = state;
	}

	@Override
	public void moveLeft() {
		if (state.hasConflictWhenShifted(0, -1)) {
			return;
		}
		state.moveFigureLeft();
	}

	@Override
	public void moveRight() {
		if (state.hasConflictWhenShifted(0, 1)) {
			return;
		}
		state.moveFigureRight();
	}

	@Override
	public void rotate() {
        int[][] prevdata = state.figure.data;
        state.figure.data = state.figure.rotate(state.figure.data);
		if (state.hasConflictWhenShifted(0, 0)) {
            state.figure.prevPosition();
            state.figure.data = prevdata;
			return;
		}
	}

	@Override
	public void dropDown() {
		if (state.hasConflictWhenShifted(1, 0)) {
			return;
		}
		state.slideDown();
	}

	@Override
	public void slideDownOneRow() {
		if (state.hasConflictWhenShifted(1, 0)) {
			state.pasteFigure();
			state.removeFullRows();
            state.isEnd();
			state.newFigure();
			return;
		}
		state.slideDown();
	}

    @Override
    public int getScore() {
        return state.getScore();
    }

    @Override
    public void newField() {
        state.newFigure();
        state.newField();
    }


}
