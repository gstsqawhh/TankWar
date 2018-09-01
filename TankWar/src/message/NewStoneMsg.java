package message;

import model.GameModel;
import model.MoveDirection;
import model.Position;
import model.StoneType;

public class NewStoneMsg extends GameMsg {

	private long tankId;
	
	private Position newPosition;
	
	private MoveDirection direction;
	
	private StoneType stoneType;
	
	public NewStoneMsg(GameModel gameModel)
	{
		super(gameModel, MessageType.NEWSTONE);
	}

	@Override
	public void execute()
	{
		

	}

	public long getTankId() {
		return tankId;
	}

	public void setTankId(long tankId) {
		this.tankId = tankId;
	}

	public Position getNewPosition() {
		return newPosition;
	}

	public void setNewPosition(Position newPosition) {
		this.newPosition = newPosition;
	}

	public MoveDirection getDirection() {
		return direction;
	}

	public void setDirection(MoveDirection direction) {
		this.direction = direction;
	}

	public StoneType getStoneType() {
		return stoneType;
	}

	public void setStoneType(StoneType stoneType) {
		this.stoneType = stoneType;
	}

}
