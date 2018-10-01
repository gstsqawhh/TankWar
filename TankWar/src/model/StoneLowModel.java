package model;

public class StoneLowModel extends StoneModel {

	private static final int ATTACK_BLOOD_ONCE = 5;
	
	private static final double STONE_SPEED = 0.2;

	
	public StoneLowModel(long stoneId, long tankId, ModelShapePosition modelPosition, MoveDirection direction)
	{
		super(stoneId, tankId, modelPosition, direction);
		this.setStoneType(StoneType.BADSTONE);
		this.setAttackBloodOnce(ATTACK_BLOOD_ONCE);
		this.setStoneSpeed(STONE_SPEED);
	}

}
