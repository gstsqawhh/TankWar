package model;

import util.ConstantsUtil;

/**
 * StoneModel������Ϊ���࣬���������ڵ����Ϳ��Լ̳�������Ĭ������stoneType��speed��attackBloodOnce������
 * ��ȻҲ���Զ�ȡ�����ļ�����������Ļ�����д��������ĳ�ʼ�������У�Ҳ����д��ConstantsUtil�Ĺ̶������У�
 * 
 * ѡ��д��ConstantsUtil�Ĺ̶��������ƺ���һЩ�����Ը��õĸ���ֵ
 * 
 * @author whstar
 *
 */
public class StoneModel {
	
	private long stoneId;
	
	private Position position;
	
	private StoneType stoneType;
	
	private int attackBloodOnce;
	
	private long tankId;
	
	private MoveDirection moveDirection;
	
	private double stoneSpeed;
	
	public StoneModel(long stoneId)
	{
		this.setStoneId(stoneId);
	}
	
	public StoneModel(long stoneId, long tankId, Position position, MoveDirection direction)
	{
		this.stoneId = stoneId;
		this.tankId = tankId;
		this.position = position;
		this.moveDirection = direction;
	}

	/**
	 * ���ã����¶�Ӧstone��λ��
	 * 		�����ж϶�Ӧstone�Ƿ�������̹�ˣ���ҪGameModelȥ�ж�
	 * 
	 * �о�StoneController�ڴ���stone�ƶ�ʱ�����Ը����Լ���ʱ������stone������ٶȣ�
	 * ���һ��ʱ������stone�ƶ��ľ��룬Ȼ����ΪMsg����GameModel�Ĵ�������
	 * ��GameModel�ж��Ƿ��Ƿ����Ŀ��̹�˻����ϰ��Ȼ�������Ӧ�Ĳ�������֪ͨview����ʾ
	 */
	public void move(int distance)
	{
		switch(moveDirection)
		{
			case EAST:
			{
				position.setX(position.getX() + distance);
				break;
			}
			case WEST:
			{
				position.setX(position.getX() - distance);
				break;
			}
			case NORTH:
			{
				position.setY(position.getY() + distance);
				break;
			}
			case SOUTH:
			{
				position.setY(position.getY() - distance);
				break;
			}
			default:
				// do nothing
		}
	}
	
	public void destroy()
	{
		
	}
	
	public long getStoneId() {
		return stoneId;
	}

	public void setStoneId(long stoneId) {
		this.stoneId = stoneId;
	}

	public MoveDirection getMoveDirection() {
		return moveDirection;
	}

	public void setMoveDirection(MoveDirection moveDirection) {
		this.moveDirection = moveDirection;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public StoneType getStoneType() {
		return stoneType;
	}

	public void setStoneType(StoneType stoneType) {
		this.stoneType = stoneType;
	}

	public int getAttackBloodOnce() {
		return attackBloodOnce;
	}

	public void setAttackBloodOnce(int attackBloodOnce) {
		this.attackBloodOnce = attackBloodOnce;
	}

	public long getTankId() {
		return tankId;
	}

	public void setTankId(long tankId) {
		this.tankId = tankId;
	}

	public double getStoneSpeed() {
		return stoneSpeed;
	}

	public void setStoneSpeed(double stoneSpeed) {
		this.stoneSpeed = stoneSpeed;
	}

}
