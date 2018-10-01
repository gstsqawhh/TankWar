package message;

import model.GameModel;

public class StartGameMsg extends GameMsg {
	
	private int gameLevel;
	
	private String playerName;
	
	private int gameBoardWidth;
	
	private int gameBoardHeight;
	
	public StartGameMsg(GameModel gameModel, int level, String name, int width, int height)
	{
		super(gameModel, MessageType.GAMESTART);
		this.gameLevel = level;
		this.playerName = name;
		this.gameBoardWidth = width;
		this.gameBoardHeight = height;
	}

	@Override
	public void execute()
	{
		gameModel.startGame(gameLevel, playerName, gameBoardWidth, gameBoardHeight);
	}

	public int getGameLevel() {
		return gameLevel;
	}

	public void setGameLevel(int gameLevel) {
		this.gameLevel = gameLevel;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getGameBoardWidth() {
		return gameBoardWidth;
	}

	public void setGameBoardWidth(int gameBoardWidth) {
		this.gameBoardWidth = gameBoardWidth;
	}

	public int getGameBoardHeight() {
		return gameBoardHeight;
	}

	public void setGameBoardHeight(int gameBoardHeight) {
		this.gameBoardHeight = gameBoardHeight;
	}

}
