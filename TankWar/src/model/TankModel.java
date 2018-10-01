package model;

import java.util.ArrayList;
import java.util.List;

import util.StoneGenerator;

public class TankModel{
	
	private long tankId;
	
	private ModelShapePosition modelShapePosition; // ռһ�����Ӵ�С
	
	private MoveDirection moveDirection;
	
	private String tankName;
	
	// ���µ������������й̶�����
	private TankType tankType;
	
	private StoneType stoneType;
	
	private int stoneNum;
	
	private int restBlood;
	
	// ��ʾ̹���ƶ����ٶȣ�ÿ��̹�˵��ٶȺ㶨����λ��x��λ/s����λ��������ϵ��Ϊ1�ĳ��ȣ���̹��������ϵ�е����Ϊ1*1��
	// Ȼ����̹�˿������У���ÿ100ms�ƶ�һ�Σ�������ٶȿ��������ÿ���ƶ��ľ���Ϊx/10��λ���ȣ�
	// �����û�̹�˶��ԣ������ַ�����
	// ����A���û�ÿ���һ�¶�Ӧ�ķ������̹����ǰ�ƶ�һ���̶��ĵ�λ���ȣ��û����ϰ�ס��������򲻶ϵ��ƶ�
	// ����B����Ȼ��̹�˿��������ƣ��û���������ֻ�Ǹı䷽����ѡ�
	// ��ʱ���÷���A��
	
	private double moveSpeed;
		
	private int destoryedTankNum;

	private List<StoneModel> runningStones;
	
	
	
	public TankModel(long tankId)
	{
		this.setTankId(tankId);
	}
	
	// �ù��캯������������ǲ�ȷ����ֵ������TankType��ȷ����ֵ������������
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
	 * 
	 * ��Ҫ���Ƿ�ִ��move��GameModel���м��
	 */
	public void move(double distance)
	{
		modelShapePosition.move(moveDirection, distance);
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
	 * �����ӵ���СΪ����Ϊ1/4�ĸ��ӵ�λ��С����Ϊ1/5���Ӵ�С��̹��Shapeռ��һ�����ӣ��������ӵ��������ڸ�������1/5����
	 * ����̹�˵�ldPoint��yֵ����2/5�����Ӵ�С��Ϊ�ӵ����¶�yֵ��
	 * ��̹�˵�ruPoint��yֵ��ȥ2/5�����Ӵ�С��Ϊ�ӵ����϶�yֵ��
	 * ��̹�˵�ruPoint��xֵ����1/4�����Ӵ�С��Ϊ�ӵ������xֵ��
	 * ��̹�˵�ruPoint��xֵ����1/2�����Ӵ�С��Ϊ�ӵ����Ҷ�xֵ��
	 * 
	 * 
	 * ������չʱ�����Ը���stoneType���������һ��̹��Ҫ�в�ͬ������ӵ��Ļ���Ŀǰ�Ȳ�����
	 */
	public void attack(int gameBoardWidth, int gameBoardHeight)
	{
		
		BoardPoint ldPointOfTank = modelShapePosition.getLeftDownPiont();
		BoardPoint ruPointOfTank = modelShapePosition.getRightUpPiont();
		double xOfLeftOfStone = ruPointOfTank.getX() + 0.25;
		double xOfRightOfStone = ruPointOfTank.getX() + 0.5;
		double yOfDownOfStone = ldPointOfTank.getY() + 0.4;
		double yOfUpOfStone = ruPointOfTank.getY() - 0.4;
		
		// ��Ҫ���̹�����ɵ��ӵ�λ���Ƿ��Ѿ�����gameBoard�ķ�Χ�����ѳ������������ӵ�
		if (xOfLeftOfStone <= 0 || xOfRightOfStone >= gameBoardWidth 
				|| yOfDownOfStone <=0 || yOfUpOfStone >= gameBoardHeight)
		{
			System.out.println("���ɵ��ӵ��������̷�Χ�������½��ӵ�");
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
			System.out.println("̹��" + tankId + "��ʱ�������ɸ����͵��ڵ�");
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
