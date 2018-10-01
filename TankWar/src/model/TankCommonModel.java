package model;
/**
 * �о��⼸��̹����ֻ����ֵ��ͬ���Ƿ����ͨ����ȡ�����ļ��ķ�ʽʵ�֣�����һЩ���������Ƶ���
 * @author whstar
 *
 */
public class TankCommonModel extends TankModel {
	
	private static final int STONE_NUM = 15;
	
	private static final int REST_BLOOD = 100;
	
	private static final double MOVE_SPEED = 0.75;	// ��1s����0.75����λ����
	
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
