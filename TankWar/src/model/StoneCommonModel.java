package model;

public class StoneCommonModel extends StoneModel {

	private static final int ATTACK_BLOOD_ONCE = 10;
	
	private static final double STONE_SPEED = 0.5;

	
	public StoneCommonModel(long stoneId, long tankId, ModelShapePosition modelPosition, MoveDirection direction)
	{
		super(stoneId, tankId, modelPosition, direction);
		this.setStoneType(StoneType.MIDDLESTONE);
		this.setAttackBloodOnce(ATTACK_BLOOD_ONCE);
		this.setStoneSpeed(STONE_SPEED);
	}

}
