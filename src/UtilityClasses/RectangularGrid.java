package UtilityClasses;

import java.awt.*;

public class RectangularGrid implements RectangularGridInterface {

    private Graphics g;
    private int canvasWidth;
    private int canvasHeight;
    private int graphWidth;
    private int graphHeight;
    private int gridWidth;
    private int gridHeight;

    public RectangularGrid(Graphics g, int canvasWidth, int canvasHeight, int graphWidth, int graphHeight) {
        this.g = g;
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        this.graphWidth = graphWidth;
        this.graphHeight = graphHeight;

        this.gridWidth = canvasWidth / (graphWidth + 2);
        this.gridHeight = canvasHeight / (graphHeight + 2);
    }

    @Override
    public void drawRectangularGrid(int row, int col) {
        int x = this.gridWidth * (row + 1);
        int y = this.gridHeight * (col + 1);

        this.g.setColor(Color.BLACK);
        this.g.drawRect(x, y, this.gridWidth, this.gridHeight);
    }

    @Override
    public void fillRectangularGrid(int row, int col, Color color) {
        int x = this.gridWidth * (row + 1);
        int y = this.gridHeight * (col + 1);

        this.g.setColor(color);
        this.g.fillRect(x, y, this.gridWidth, this.gridHeight);
        this.g.drawRect(x, y, this.gridWidth, this.gridHeight);
    }

    @Override
    public Point getRectangularGridIndexes(int x, int y) {

        int row = (x / this.gridWidth) - 1;
        int col = (y / this.gridHeight) - 1;

        if (row < 0 || row >= this.graphWidth) {
            return null;
        } else if (col < 0 || col >= this.graphHeight) {
            return null;
        }
        return new Point(row, col);
    }
}
