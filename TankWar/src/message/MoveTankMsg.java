package message;

import model.GameModel;
import model.MoveDirection;

public class MoveTankMsg extends GameMsg {
	
	private long tankId;
	
	private MoveDirection moveDirection;
	
	public MoveTankMsg(GameModel gameModel, long tankId, MoveDirection direction)
	{
		super(gameModel, MessageType.TANKMOVE);
		this.tankId = tankId;
		this.moveDirection = direction;
	}

	@Override
	public void execute()
	{
		gameModel.moveTank();
		
	}

	public long getTankId() {
		return tankId;
	}

	public void setTankId(long tankId) {
		this.tankId = tankId;
	}

	public MoveDirection getMoveDirection() {
		return moveDirection;
	}

	public void setMoveDirection(MoveDirection moveDirection) {
		this.moveDirection = moveDirection;
	}
	
	

}
