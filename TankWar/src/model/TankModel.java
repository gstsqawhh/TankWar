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
	 * 作用：使得坦克向moveDirection所指的方向运行一段指定的距离
	 * 注意：此处不进行判断，如：
	 * 						是否移动超出范围，
	 * 						是否可以移动，如被障碍物阻挡，不能继续前进或转向
	 * 						等等。
	 * 以上的判断交由GameModel去做判断，因为GameModel有全局的信息，而TankModel则只有自身的信息，
	 * 因此TankModel只负责执行最终的移动操作，而不进行检测。
	 * 
	 * 但是为了检测边界，可以在新建position时给它gameBoard的宽和高
	 * position可以自己执行检测。
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
	 * 作用：在用户执行不同方向时执行，或者在电脑坦克碰到障碍物时自动执行转向
	 * 		同样，该方法不做检查，是否可以转向，检查操作在GameModel中进行即可。
	 */
	public void turn(MoveDirection moveDirection)
	{
		this.setMoveDirection(moveDirection);
	}
	
	/**
	 * 作用：在坦克执行攻击操作时，生成子弹（属于坦克的），并且减少剩余子弹数量等操作
	 * 
	 * 后续扩展时，可以给定stoneType参数，如果一个坦克要有不同种类的子弹的话，目前先不设置
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
