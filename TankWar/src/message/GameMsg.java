package message;

import model.GameModel;

public abstract class GameMsg {
	
	private MessageType msgType;
	
	private GameModel gameModel;

	public GameMsg(GameModel gameModel, MessageType msgType)
	{
		this.setGameModel(gameModel);
		this.setMsgType(msgType);
	}
	
	public abstract void execute();
	
	public GameModel getGameModel() {
		return gameModel;
	}

	public void setGameModel(GameModel gameModel) {
		this.gameModel = gameModel;
	}

	public MessageType getMsgType() {
		return msgType;
	}

	public void setMsgType(MessageType msgType) {
		this.msgType = msgType;
	}
	
}
