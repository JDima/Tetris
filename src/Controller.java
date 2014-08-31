public class Controller implements ModelListener, EventProcessor {
	
	Model model;
	View view;
	
	public Controller(Model model, View view) {
		super();
		this.model = model;
		this.view = view;
		model.setListener(this);
	}

	@Override
	public void updateState(State state) {
		view.updateState(state);
	}

	@Override
	public void moveLeft() {
		model.moveLeft();
	}

	@Override
	public void moveRight() {
		model.moveRight();
	}

	@Override
	public void rotate() {
		model.rotate();
	}

	@Override
	public void dropDown() {
		model.dropDown();
	}

	@Override
	public void slideDownOneRow() {
		model.slideDownOneRow();
	}

    @Override
    public int getScore() {
        return model.getScore();
    }

    @Override
    public void newField() {
        model.newField();
    }
}
