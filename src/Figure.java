import java.util.Random;


public class Figure {

	private static int i;

	private static int j;
	
	static int[][] rotate(int [][] data) {
		int[][] newdata = new int[4][4];
		j = (j + 1) % setFigures[0].length;
		newdata = setFigures[i][j];
		return newdata;
	}

    static void prevPosition() {
        if (j == 0) {
            j = setFigures[0].length - 1;
        }
        else {
            j--;
        }
    }

	static int[][][][] setFigures = new int[7][4][][];
	
	
	static {
		setFigures[0][0] = Elements.FIGURE_F[0];
		setFigures[0][1] = Elements.FIGURE_F[1];
		setFigures[0][2] = Elements.FIGURE_F[2];
		setFigures[0][3] = Elements.FIGURE_F[3];
		
		setFigures[1][0] = Elements.FIGURE_L[0];
		setFigures[1][1] = Elements.FIGURE_L[1];
		setFigures[1][2] = Elements.FIGURE_L[2];
		setFigures[1][3] = Elements.FIGURE_L[3];
		
		setFigures[2][0] = Elements.FIGURE_Z[0];
		setFigures[2][1] = Elements.FIGURE_Z[1];
		setFigures[2][2] = Elements.FIGURE_Z[0];
		setFigures[2][3] = Elements.FIGURE_Z[1];
		
		setFigures[3][0] = Elements.FIGURE_H[0];
		setFigures[3][1] = Elements.FIGURE_H[1];
		setFigures[3][2] = Elements.FIGURE_H[0];
		setFigures[3][3] = Elements.FIGURE_H[1];
		
		setFigures[4][0] = Elements.FIGURE_T[0];
		setFigures[4][1] = Elements.FIGURE_T[1];
		setFigures[4][2] = Elements.FIGURE_T[2];
		setFigures[4][3] = Elements.FIGURE_T[3];
		
		setFigures[5][0] = Elements.FIGURE_I[0];
		setFigures[5][1] = Elements.FIGURE_I[1];
		setFigures[5][2] = Elements.FIGURE_I[0];
		setFigures[5][3] = Elements.FIGURE_I[1];
		
		setFigures[6][0] = Elements.FIGURE_O[0];
		setFigures[6][1] = Elements.FIGURE_O[0];
		setFigures[6][2] = Elements.FIGURE_O[0];
		setFigures[6][3] = Elements.FIGURE_O[0];
	}
	
	static Random random = new Random();
	
	public int[][] data = new int[4][4];
	
	private Figure() {
	}

	public static Figure randomFigure() {
		Figure figure = new Figure();
		i = random.nextInt(setFigures.length);
		j = random.nextInt(setFigures[0].length);
		int[][] data = setFigures[i][j];
		figure.data = data;
		return figure;
	}

}
