package model;

import java.util.Observable;

public class GameBoardModel extends Observable {
	
	private int width;
	
	private int height;
	
	private CellModel[][] cells;
	
	public GameBoardModel(int width, int height)
	{
		this.width = width;
		this.height = height;
		cells = new CellModel[width][height];
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				cells[i][j] = new CellModel(i, j);
			}
		}
	}

	/**
	 * 生成地图：
	 * 有两种大的方向：
	 * 方向1：设置固定的几种地图，生成地图时从这几种固定的地图中选择，特殊情况是只有一张地图；
	 * 方向2：随机生成地图，每次生成时可以设置障碍物行的数量和行数等等，包括一列障碍物；
	 * 
	 * 目前为简单起见，通过方向1生成地图，先只生成一张地图，该地图特征如下，
	 * 从每一行来看，障碍物与通道相间隔
	 * 从每一列来看，列都是通道，为了覆盖与障碍物行重合的格子，先设置行，在设置列
	 * 
	 */
	public void generateGameMap()
	{
		// 1、先设置行，障碍物与通道间隔设置
		for (int i = 0; i < height ; i++)
		{
			if (i % 2 == 0) //如果是偶数行，设置为通道
			{
				for (int j = 0; j < width; j++)
				{
					cells[j][i].setWall(false);
				}
			}
			else // 如果是奇数行，设置为障碍物
			{
				for (int j = 0; j < width; j++)
				{
					cells[j][i].setWall(true);
				}
			}
		}
		
		
		
		// 2、后设置列，每个4列刷一列，刷的列全部为通道，覆盖与行重合的格子
		for (int i = 0; i < width; i++)
		{
			if ((i+1) % 4 == 0) //每隔4列刷一列
			{
				for (int j = 0; j < height; j++)
				{
					cells[i][j].setWall(false);
				}
			}
		}
		
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public CellModel[][] getCells() {
		return cells;
	}

	public void setCells(CellModel[][] cells) {
		this.cells = cells;
	}


	
	
}
