package model;
/**
 * 感觉这几个坦克类只有数值不同，是否可以通过读取配置文件的方式实现，更好一些，减少相似的类
 * @author whstar
 *
 */
public class TankCommonModel extends TankModel {
	
	private static final int STONE_NUM = 15;
	
	private static final int REST_BLOOD = 100;
	
	private static final double MOVE_SPEED = 0.75;	// 即1s运行0.75个单位长度
	
	public TankCommonModel(long tankId, ModelShapePosition modelShape, MoveDirection mvDirect, String tankName)
	{
		super(tankId, modelShape, mvDirect, tankName);
		this.setTankType(TankType.GOODTANK);
		this.setStoneType(StoneType.GOODSTONE);
		this.setStoneNum(STONE_NUM);
		this.setRestBlood(REST_BLOOD);
		this.setMoveSpeed(MOVE_SPEED);
	}
}
