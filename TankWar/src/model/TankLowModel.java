package model;

public class TankLowModel extends TankModel {
	
	private static final int STONE_NUM = 10;
	
	private static final int REST_BLOOD = 80;
	
	private static final double MOVE_SPEED = 0.5;	// 即1s运行0.5个单位长度
	
	public TankLowModel(long tankId, ModelShapePosition modelShape, MoveDirection mvDirect, String tankName)
	{
		super(tankId, modelShape, mvDirect, tankName);
		this.setTankType(TankType.GOODTANK);
		this.setStoneType(StoneType.GOODSTONE);
		this.setStoneNum(STONE_NUM);
		this.setRestBlood(REST_BLOOD);
		this.setMoveSpeed(MOVE_SPEED);
	}
}
