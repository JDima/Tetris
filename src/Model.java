public class Model implements EventProcessor {

	State state;
	Logic logic;
	
	public Model() {
		state = new State();
		logic = new Logic(state);
	}
	
	ModelListener listener;
	
	public void setListener(ModelListener listener) {
		this.listener = listener;
	}



	@Override
	public void moveLeft() {
		logic.moveLeft();
		listener.updateState(state);
	}
	@Override
	public void moveRight() {
		logic.moveRight();
		listener.updateState(state);
	}
	@Override
	public void rotate() {
		logic.rotate();
		listener.updateState(state);
	}
	@Override
	public void dropDown() {
		logic.dropDown();
		listener.updateState(state);
	}
	@Override
	public void slideDownOneRow() {
		logic.slideDownOneRow();
		listener.updateState(state);
	}

    @Override
    public int getScore() {
        return logic.getScore();
    }

    @Override
    public void newField() {
        logic.newField();
        listener.updateState(state);
    }
}
