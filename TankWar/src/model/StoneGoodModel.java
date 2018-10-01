package model;

public class StoneGoodModel extends StoneModel {

	private static final int ATTACK_BLOOD_ONCE = 20;
	
	private static final double STONE_SPEED = 1;	// ÿ���ƶ�һ����λ����

	
	public StoneGoodModel(long stoneId, long tankId, ModelShapePosition modelPosition, MoveDirection direction)
	{
		super(stoneId, tankId, modelPosition, direction);
		this.setStoneType(StoneType.GOODSTONE);
		this.setAttackBloodOnce(ATTACK_BLOOD_ONCE);
		this.setStoneSpeed(STONE_SPEED);
	}

}
