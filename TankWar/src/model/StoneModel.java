package model;

/**
 * StoneModel可以作为父类，各个子类炮弹类型可以继承它，并默认设置stoneType、speed、attackBloodOnce等属性
 * 当然也可以读取配置文件，但在这里的话可以写死到子类的初始化函数中，也可以写在ConstantsUtil的固定参数中，
 * 
 * 选择写在ConstantsUtil的固定参数中似乎好一些，可以更好的更换值
 * 
 * @author whstar
 *
 */
public class StoneModel {
	
	private long stoneId;

	private long tankId;
	
	private ModelShapePosition modelPosition;
	
	private MoveDirection moveDirection;
	
	// 以下属性根据stoneType呈现固定的值
	private StoneType stoneType;
	
	private int attackBloodOnce;
	
	// 表示子弹移动的速度，每种坦克的速度恒定，单位是x单位/s，单位即是坐标系中为1的长度，如坦克在坐标系中的面积为1*1，
	// 然后在子弹控制器中，如每100ms移动一次，则根据速度可以算出，每次移动的距离为x/10单位长度，
	private double stoneSpeed;
	
	public StoneModel(long stoneId)
	{
		this.setStoneId(stoneId);
	}
	
	public StoneModel(long stoneId, long tankId, ModelShapePosition modelPosition, MoveDirection direction)
	{
		this.stoneId = stoneId;
		this.tankId = tankId;
		this.modelPosition = modelPosition;
		this.moveDirection = direction;
	}

	/**
	 * 作用：更新对应stone的位置
	 * 		至于判断对应stone是否碰上了坦克，需要GameModel去判断
	 * 
	 * 感觉StoneController在触发stone移动时，可以根据自己的时间间隔和stone自身的速度，
	 * 算出一个时间间隔内stone移动的距离，然后作为Msg传给GameModel的处理方法。
	 * 由GameModel判断是否是否击中目标坦克或是障碍物，然后进行相应的操作，并通知view端显示
	 */
	public void move(int distance)
	{
		modelPosition.move(moveDirection, distance);
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

	public ModelShapePosition getModelPosition() {
		return modelPosition;
	}

	public void setModelPosition(ModelShapePosition modelPosition) {
		this.modelPosition = modelPosition;
	}

}
