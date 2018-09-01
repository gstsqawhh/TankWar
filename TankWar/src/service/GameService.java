package service;

import java.util.ArrayList;
import java.util.List;

import model.GameBoardModel;
import model.GameModel;
import model.StoneModel;
import model.TankModel;
import util.TankGenerator;

public class GameService {
	
	private GameModel gameModel;
	
	private GameService()
	{
		
	}
	
	private static GameService gameService = new GameService();
	
	public static GameService getSingleInstance()
	{
		return gameService;
	}
	
	public void startGame()
	{	
		// test case
//		int gameId = 1;
//		int gameLevel = 1;
//		String playerName = "whh";
//		GameBoardModel gameBoard = new GameBoardModel(10, 10);
//		TankModel userTank = TankGenerator.getTankGenerator().generate();
//		List<TankModel> tanksOfComputor = new ArrayList<>();
//		List<StoneModel> stonesOfGame = new ArrayList<>();
//		String res = "UNKNOWN";
//		int score = 0;
//		
//		gameModel = new GameModel(gameId, gameLevel, playerName, userTank, gameBoard,
//				tanksOfComputor, stonesOfGame, res, score);
		
		
		
		
	}



	public GameModel getGameModel()
	{
		return gameModel;
	}



	public void setGameModel(GameModel gameModel)
	{
		this.gameModel = gameModel;
	}
	
	
	

}
