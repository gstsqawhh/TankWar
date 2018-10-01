package model;

import java.util.ArrayList;
import java.util.List;

import util.StoneGenerator;

public class TankModel{
	
	private long tankId;
	
	private ModelShapePosition modelShapePosition; // 占一个格子大小
	
	private MoveDirection moveDirection;
	
	private String tankName;
	
	// 以下的属性在子类中固定声明
	private TankType tankType;
	
	private StoneType stoneType;
	
	private int stoneNum;
	
	private int restBlood;
	
	// 表示坦克移动的速度，每种坦克的速度恒定，单位是x单位/s，单位即是坐标系中为1的长度，如坦克在坐标系中的面积为1*1，
	// 然后在坦克控制器中，如每100ms移动一次，则根据速度可以算出，每次移动的距离为x/10单位长度，
	// 对于用户坦克而言，有两种方案：
	// 方案A：用户每点击一下对应的方向键，坦克向前移动一个固定的单位长度，用户不断按住方向键，则不断地移动
	// 方案B：依然由坦克控制器控制，用户点击方向键只是改变方向而已。
	// 暂时采用方案A。
	
	private double moveSpeed;
		
	private int destoryedTankNum;

	private List<StoneModel> runningStones;
	
	
	
	public TankModel(long tankId)
	{
		this.setTankId(tankId);
	}
	
	// 该构造函数输入参数都是不确定的值，根据TankType能确定的值不在这里输入
	public TankModel(long tankId, ModelShapePosition modelShape, MoveDirection mvDirect, String tankName)
	{
		this.tankId = tankId;
		this.modelShapePosition = modelShape;
		this.moveDirection = mvDirect;
		this.tankName = tankName;
		this.setDestoryedTankNum(0);
		this.setRunningStones(new ArrayList<StoneModel>());
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
	 * 
	 * 重要：是否执行move由GameModel进行检测
	 */
	public void move(double distance)
	{
		modelShapePosition.move(moveDirection, distance);
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
	 * 定义子弹大小为：宽为1/4的格子单位大小，高为1/5格子大小，坦克Shape占据一个格子，发出的子弹都运行在格子中央1/5处，
	 * 即由坦克的ldPoint的y值加上2/5个格子大小作为子弹的下端y值，
	 * 由坦克的ruPoint的y值减去2/5个格子大小作为子弹的上端y值，
	 * 由坦克的ruPoint的x值加上1/4个格子大小作为子弹的左端x值，
	 * 由坦克的ruPoint的x值加上1/2个格子大小作为子弹的右端x值。
	 * 
	 * 
	 * 后续扩展时，可以给定stoneType参数，如果一个坦克要有不同种类的子弹的话，目前先不设置
	 */
	public void attack(int gameBoardWidth, int gameBoardHeight)
	{
		
		BoardPoint ldPointOfTank = modelShapePosition.getLeftDownPiont();
		BoardPoint ruPointOfTank = modelShapePosition.getRightUpPiont();
		double xOfLeftOfStone = ruPointOfTank.getX() + 0.25;
		double xOfRightOfStone = ruPointOfTank.getX() + 0.5;
		double yOfDownOfStone = ldPointOfTank.getY() + 0.4;
		double yOfUpOfStone = ruPointOfTank.getY() - 0.4;
		
		// 需要检查坦克生成的子弹位置是否已经超出gameBoard的范围，若已超出，则不生成子弹
		if (xOfLeftOfStone <= 0 || xOfRightOfStone >= gameBoardWidth 
				|| yOfDownOfStone <=0 || yOfUpOfStone >= gameBoardHeight)
		{
			System.out.println("生成的子弹超出棋盘范围，不会新建子弹");
			return;
		}
		
		BoardPoint leftDownStone = new BoardPoint(xOfLeftOfStone, yOfDownOfStone, gameBoardWidth, gameBoardHeight);
		BoardPoint rightUpStone = new BoardPoint(xOfRightOfStone, yOfUpOfStone, gameBoardWidth, gameBoardHeight);
		
		ModelShapePosition modelPosition = new ModelShapePosition(leftDownStone, rightUpStone);

		switch(stoneType)
		{
		case GOODSTONE:
			StoneModel newStone = StoneGenerator.getStoneGenerator().generateGoodStone(tankId, modelPosition, moveDirection);
			runningStones.add(newStone);
			stoneNum--;
			break;
		case MIDDLESTONE:
			StoneModel middleStone = StoneGenerator.getStoneGenerator().generateMiddleStone(tankId, modelPosition, moveDirection);
			runningStones.add(middleStone);
			stoneNum--;
			break;
		case BADSTONE:
			StoneModel badStone = StoneGenerator.getStoneGenerator().generateBadStone(tankId, modelPosition, moveDirection);
			runningStones.add(badStone);
			stoneNum--;
			break;
		default:
			System.out.println("坦克" + tankId + "暂时不能生成该类型的炮弹");
		}
		
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

	public List<StoneModel> getRunningStones() {
		return runningStones;
	}

	public void setRunningStones(List<StoneModel> runningStones) {
		this.runningStones = runningStones;
	}

	public ModelShapePosition getModelShapePosition() {
		return modelShapePosition;
	}

	public void setModelShapePosition(ModelShapePosition modelShapePosition) {
		this.modelShapePosition = modelShapePosition;
	}

	public double getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(double moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	
	

}
