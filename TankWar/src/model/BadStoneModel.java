package model;

public class BadStoneModel extends StoneModel {

	private static final int ATTACK_BLOOD_ONCE = 5;
	
	private static final double STONE_SPEED = 0.1;

	
	public BadStoneModel(long stoneId, long tankId, Position position, MoveDirection direction)
	{
		super(stoneId, tankId, position, direction);
		this.setStoneType(StoneType.BADSTONE);
		this.setAttackBloodOnce(ATTACK_BLOOD_ONCE);
		this.setStoneSpeed(STONE_SPEED);
	}

}
