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
	 * ���ɵ�ͼ��
	 * �����ִ�ķ���
	 * ����1�����ù̶��ļ��ֵ�ͼ�����ɵ�ͼʱ���⼸�̶ֹ��ĵ�ͼ��ѡ�����������ֻ��һ�ŵ�ͼ��
	 * ����2��������ɵ�ͼ��ÿ������ʱ���������ϰ����е������������ȵȣ�����һ���ϰ��
	 * 
	 * ĿǰΪ�������ͨ������1���ɵ�ͼ����ֻ����һ�ŵ�ͼ���õ�ͼ�������£�
	 * ��ÿһ���������ϰ�����ͨ������
	 * ��ÿһ���������ж���ͨ����Ϊ�˸������ϰ������غϵĸ��ӣ��������У���������
	 * 
	 */
	public void generateGameMap()
	{
		// 1���������У��ϰ�����ͨ���������
		for (int i = 0; i < height ; i++)
		{
			if (i % 2 == 0) //�����ż���У�����Ϊͨ��
			{
				for (int j = 0; j < width; j++)
				{
					cells[j][i].setWall(false);
				}
			}
			else // ����������У�����Ϊ�ϰ���
			{
				for (int j = 0; j < width; j++)
				{
					cells[j][i].setWall(true);
				}
			}
		}
		
		
		
		// 2���������У�ÿ��4��ˢһ�У�ˢ����ȫ��Ϊͨ�������������غϵĸ���
		for (int i = 0; i < width; i++)
		{
			if ((i+1) % 4 == 0) //ÿ��4��ˢһ��
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
