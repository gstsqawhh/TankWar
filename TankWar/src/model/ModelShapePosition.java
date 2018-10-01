package model;

public class ModelShapePosition {
	
	private BoardPoint leftDownPiont;
	
	private BoardPoint rightUpPiont;
	
	
	public ModelShapePosition(BoardPoint ldP, BoardPoint ruP)
	{
		this.leftDownPiont = ldP;
		this.rightUpPiont = ruP;
	}

	public ModelShapePosition(CellModel cell, int width, int height) {
		int x = cell.getX();
		int y = cell.getY();
		this.leftDownPiont = new BoardPoint(x, y, width, height);
		this.rightUpPiont = new BoardPoint(x+1, y+1, width, height);
	}

	public void move(MoveDirection md, double moveDistance)
	{
		switch(md)
		{
			case EAST:
			{
				leftDownPiont.setX(leftDownPiont.getX() + moveDistance);
				rightUpPiont.setX(rightUpPiont.getX() + moveDistance);
				break;
			}
			case WEST:
			{
				leftDownPiont.setX(leftDownPiont.getX() - moveDistance);
				rightUpPiont.setX(rightUpPiont.getX() - moveDistance);
				break;
			}
			case NORTH:
			{
				leftDownPiont.setY(leftDownPiont.getY() + moveDistance);
				rightUpPiont.setY(rightUpPiont.getY() + moveDistance);
				break;
			}
			case SOUTH:
			{
				leftDownPiont.setY(leftDownPiont.getY() - moveDistance);
				rightUpPiont.setY(rightUpPiont.getY() - moveDistance);
				break;
			}
			default:
				// do nothing
		}
	}

	public BoardPoint getLeftDownPiont() {
		return leftDownPiont;
	}

	public void setLeftDownPiont(BoardPoint leftDownPiont) {
		this.leftDownPiont = leftDownPiont;
	}

	public BoardPoint getRightUpPiont() {
		return rightUpPiont;
	}

	public void setRightUpPiont(BoardPoint rightUpPiont) {
		this.rightUpPiont = rightUpPiont;
	}
	
	

}
