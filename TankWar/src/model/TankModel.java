package model;

import util.ConstantsUtil;

public class TankModel {
	
	private long tankId;
	
	private Position position;
	
	private MoveDirection moveDirection;
	
	private String tankName;
		
	private TankType tankType;
	
	private StoneType stoneType;
		
	private int stoneNum;
	
	private int destoryedTankNum;

	private int restBlood;
	
	
	public TankModel(long tankId)
	{
		this.setTankId(tankId);
	}
	
	public TankModel(long tankId, Position position, MoveDirection initMoveDirection, String tankName, TankType tankType,
						StoneType stoneType, int stoneNum)
	{
		this.setTankId(tankId);
		this.setPosition(position);
		this.setMoveDirection(initMoveDirection);
		this.setTankName(tankName);
		this.setTankType(tankType);
		this.setStoneType(stoneType);
		this.setStoneNum(stoneNum);
		this.setDestoryedTankNum(0);
		this.setRestBlood(100);
	}
	
	/**
	 * ���ã�ʹ��̹����moveDirection��ָ�ķ�������һ��ָ���ľ���
	 * ע�⣺�˴��������жϣ��磺
	 * 						�Ƿ��ƶ�������Χ��
	 * 						�Ƿ�����ƶ����类�ϰ����赲�����ܼ���ǰ����ת��
	 * 						�ȵȡ�
	 * ���ϵ��жϽ���GameModelȥ���жϣ���ΪGameModel��ȫ�ֵ���Ϣ����TankModel��ֻ���������Ϣ��
	 * ���TankModelֻ����ִ�����յ��ƶ��������������м�⡣
	 * 
	 * ����Ϊ�˼��߽磬�������½�positionʱ����gameBoard�Ŀ�͸�
	 * position�����Լ�ִ�м�⡣
	 */
	public void move()
	{
		switch(moveDirection)
		{
			case EAST:
			{
				position.setX(position.getX() + ConstantsUtil.DISTANCE_OF_ONCE_TANKMOVE);
				break;
			}
			case WEST:
			{
				position.setX(position.getX() - ConstantsUtil.DISTANCE_OF_ONCE_TANKMOVE);
				break;
			}
			case NORTH:
			{
				position.setY(position.getY() + ConstantsUtil.DISTANCE_OF_ONCE_TANKMOVE);
				break;
			}
			case SOUTH:
			{
				position.setY(position.getY() - ConstantsUtil.DISTANCE_OF_ONCE_TANKMOVE);
				break;
			}
			default:
				// do nothing
		}
	}
	
	/**
	 * ���ã����û�ִ�в�ͬ����ʱִ�У������ڵ���̹�������ϰ���ʱ�Զ�ִ��ת��
	 * 		ͬ�����÷���������飬�Ƿ����ת�򣬼�������GameModel�н��м��ɡ�
	 */
	public void turn(MoveDirection moveDirection)
	{
		this.setMoveDirection(moveDirection);
	}
	
	/**
	 * ���ã���̹��ִ�й�������ʱ�������ӵ�������̹�˵ģ������Ҽ���ʣ���ӵ������Ȳ���
	 * 
	 * ������չʱ�����Ը���stoneType���������һ��̹��Ҫ�в�ͬ������ӵ��Ļ���Ŀǰ�Ȳ�����
	 */
	public void attack()
	{
		
	}
	
	public void destroy()
	{
		
	}

	public long getTankId() {
		return tankId;
	}

	public void setTankId(long tankId) {
		this.tankId = tankId;
	}

	public MoveDirection getMoveDirection() {
		return moveDirection;
	}

	public void setMoveDirection(MoveDirection moveDirection) {
		this.moveDirection = moveDirection;
	}

	public String getTankName() {
		return tankName;
	}

	public void setTankName(String tankName) {
		this.tankName = tankName;
	}

	public TankType getTankType() {
		return tankType;
	}

	public void setTankType(TankType tankType) {
		this.tankType = tankType;
	}

	public StoneType getStoneType() {
		return stoneType;
	}

	public void setStoneType(StoneType stoneType) {
		this.stoneType = stoneType;
	}

	public int getStoneNum() {
		return stoneNum;
	}

	public void setStoneNum(int stoneNum) {
		this.stoneNum = stoneNum;
	}

	public int getDestoryedTankNum() {
		return destoryedTankNum;
	}

	public void setDestoryedTankNum(int destoryedTankNum) {
		this.destoryedTankNum = destoryedTankNum;
	}

	public int getRestBlood() {
		return restBlood;
	}

	public void setRestBlood(int restBlood) {
		this.restBlood = restBlood;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
}
