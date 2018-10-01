package message;

import model.GameModel;
import model.MoveDirection;

public class MoveStoneMsg extends GameMsg {

	private long stoneId;
	
	private MoveDirection direction;
	
	public MoveStoneMsg(GameModel gameModel, long stoneId, MoveDirection direction)
	{
		super(gameModel, MessageType.STONEMOVE);
		this.stoneId = stoneId;
		this.direction = direction;
	}

	@Override
	public void execute()
	{
		gameModel.moveStone();
		
	}

	public long getStoneId() {
		return stoneId;
	}

	public void setStoneId(long stoneId) {
		this.stoneId = stoneId;
	}

	public MoveDirection getDirection() {
		return direction;
	}

	public void setDirection(MoveDirection direction) {
		this.direction = direction;
	}

}
