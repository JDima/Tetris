public class State {

	public Field field = new Field();
	public Figure figure;
	public int figureRow;
	public int figureColumn;

	public State() {
		newFigure();
	}
	
	void moveFigureLeft() {
		figureColumn--;
	}

	public int getFigureColumn() {
		return figureColumn;
	}

	public void moveFigureRight() {
		figureColumn++;
	}

	public void slideDown() {
		figureRow += 1;
	}

	public int getFigureRow() {
		return figureRow;
	}

	public boolean hasConflictWhenShifted(int rowShift, int columnShift) {
		return field.hasConflictAt
				(figureRow + rowShift, 
						figureColumn + columnShift, 
						figure.data);
	}

	public void pasteFigure() {
		field.paste(figureRow, figureColumn, figure.data);
	}

	public void newFigure() {
		figure = Figure.randomFigure();
		figureRow = 0;
		figureColumn = field.box[0].length / 2
		- figure.data[0].length / 2 + 1;
	}

	public void removeFullRows() {
		field.removeFullRows();
	}

	public void isEnd() {
		field.isEnd();
		
	}

    public int getScore() {
        return field.getScore();
    }

    public void newField() {
        field.newField();
    }

}
