package model;

import java.util.Observable;

public class GameBoardModel extends Observable {
	
	private int width;
	
	private int length;
	
	private CellModel[][] cells;
	
	public GameBoardModel(int width, int length)
	{
		this.width = width;
		this.length = length;
		cells = new CellModel[width][length];
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < length; j++)
			{
				cells[i][j] = new CellModel();
			}
		}
	}

	
	
	
	
	
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public CellModel[][] getCells() {
		return cells;
	}

	public void setCells(CellModel[][] cells) {
		this.cells = cells;
	}

	
	
}
