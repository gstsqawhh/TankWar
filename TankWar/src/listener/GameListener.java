package listener;

import controller.GameController;

public class GameListener {
	
	private GameController gameController;
	
	public boolean start()
	{
		
		return false;
	}

	public GameController getGameController() {
		return gameController;
	}

	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}

}
