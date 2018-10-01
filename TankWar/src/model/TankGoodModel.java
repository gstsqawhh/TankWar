package model;

public class TankGoodModel extends TankModel {

	private static final int STONE_NUM = 20;
	
	private static final int REST_BLOOD = 120;
	
	private static final double MOVE_SPEED = 1;	// 即1s运行1个单位长度
	
	public TankGoodModel(long tankId, ModelShapePosition modelShape, MoveDirection mvDirect, String tankName)
	{
		super(tankId, modelShape, mvDirect, tankName);
		this.setTankType(TankType.GOODTANK);
		this.setStoneType(StoneType.GOODSTONE);
		this.setStoneNum(STONE_NUM);
		this.setRestBlood(REST_BLOOD);
		this.setMoveSpeed(MOVE_SPEED);
	}
	
}
