package model;

public class GoodStoneModel extends StoneModel {

	private static final int ATTACK_BLOOD_ONCE = 20;
	
	private static final double STONE_SPEED = 0.5;

	
	public GoodStoneModel(long stoneId, long tankId,  Position position, MoveDirection direction)
	{
		super(stoneId, tankId, position,direction);
		this.setStoneType(StoneType.GOODSTONE);
		this.setAttackBloodOnce(ATTACK_BLOOD_ONCE);
		this.setStoneSpeed(STONE_SPEED);
	}

}
