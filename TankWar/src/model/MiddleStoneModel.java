package model;

public class MiddleStoneModel extends StoneModel {

	private static final int ATTACK_BLOOD_ONCE = 10;
	
	private static final double STONE_SPEED = 0.2;

	
	public MiddleStoneModel(long stoneId, long tankId, Position position, MoveDirection direction)
	{
		super(stoneId, tankId, position, direction);
		this.setStoneType(StoneType.MIDDLESTONE);
		this.setAttackBloodOnce(ATTACK_BLOOD_ONCE);
		this.setStoneSpeed(STONE_SPEED);
	}

}
