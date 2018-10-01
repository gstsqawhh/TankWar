package message;

import model.GameModel;

public class NewTankMsg extends GameMsg{

	public NewTankMsg(GameModel gameModel)
	{
		super(gameModel, MessageType.NEWTANK);
		
	}

	@Override
	public void execute()
	{
		gameModel.newTank();
		
	}

}
