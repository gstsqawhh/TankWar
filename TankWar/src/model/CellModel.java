package model;

public class CellModel {
	
	private int x;
	
	private int y;
		
	private boolean isWall;
	
	private boolean hasTank;
	
	public CellModel(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isWall() {
		return isWall;
	}

	public void setWall(boolean isWall) {
		this.isWall = isWall;
	}

	public boolean isHasTank() {
		return hasTank;
	}

	public void setHasTank(boolean hasTank) {
		this.hasTank = hasTank;
	}
	
	
	

}
