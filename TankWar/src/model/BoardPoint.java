package model;

public class BoardPoint {
	
	private double x;
	
	private double y;
	
	private int gameBoardWidth;
	
	private int gameBoardHeight;
	
	public BoardPoint(double x, double y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.gameBoardWidth = width;
		this.gameBoardHeight = height;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		if (x < 0 || x > gameBoardWidth)
		{
			System.out.println("position setX超出界限，设置失败");
			return;
		}
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		if (y < 0 || y > gameBoardHeight)
		{
			System.out.println("position setY超出界限，设置失败");
			return;
		}
		this.y = y;
	}

	public int getGameBoardWidth() {
		return gameBoardWidth;
	}

	public void setGameBoardWidth(int gameBoardWidth) {
		this.gameBoardWidth = gameBoardWidth;
	}

	public int getGameBoardHeight() {
		return gameBoardHeight;
	}

	public void setGameBoardHeight(int gameBoardHeight) {
		this.gameBoardHeight = gameBoardHeight;
	}
	
	

}
