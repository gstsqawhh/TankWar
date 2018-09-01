package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * 该类具体负责游戏操作的逻辑，如新建游戏、坦克新建、坦克移动、坦克攻击、子弹新建、子弹移动和销毁等等
 * @author whstar
 *
 */

public class GameModel extends Observable {
	
	private int gameLevel;
	
	private String playerName;
	
	private GameBoardModel gameBoard;
	
	private TankModel userTank;
	
	private List<TankModel> tanksOfComputer; //需要考虑线程的同步，因为会在不同线程读写
	
	private List<StoneModel> stonesOfGame; //需要考虑线程的同步，因为会在不同线程读写
	
	private GameResult gameResult;
	
	private int gameScore;
	
	public GameModel()
	{
		tanksOfComputer = new ArrayList<>();
		stonesOfGame = new ArrayList<>();
		gameResult = GameResult.UNKNOWN;
		gameScore = 0;
	}
	
	public GameModel(int gameLevel, String name, TankModel userTank, GameBoardModel gameBoard,
			List<TankModel> tanksOfComputor, List<StoneModel> stonesOfGame, GameResult res, int score)
	{
		this.gameLevel = gameLevel;
		this.playerName = name;
		this.userTank = userTank;
		this.gameBoard = gameBoard;
		this.tanksOfComputer = tanksOfComputor;
		this.stonesOfGame = stonesOfGame;
		this.gameResult = res;
		this.gameScore = score;
	}
	
	public void startGame()
	{
		generateMap();
		
	}
	
	public void generateMap()
	{
		
		
		
	}
	
	public void newStone()
	{
		
	}
	
	public void moveStone()
	{
		
	}
	
	public void newTank()
	{
		
	}
	
	public void moveTank()
	{
		
	}
	
	public void attackTank()
	{
		
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

	public TankModel getUserTank() {
		return userTank;
	}

	public void setUserTank(TankModel userTank) {
		this.userTank = userTank;
	}

	public List<TankModel> getTanksOfComputer() {
		return tanksOfComputer;
	}

	public void setTanksOfComputer(List<TankModel> tanksOfComputer) {
		this.tanksOfComputer = tanksOfComputer;
	}

	public List<StoneModel> getStonesOfGame() {
		return stonesOfGame;
	}

	public void setStonesOfGame(List<StoneModel> stonesOfGame) {
		this.stonesOfGame = stonesOfGame;
	}

	public GameResult getGameResult() {
		return gameResult;
	}

	public void setGameResult(GameResult gameResult) {
		this.gameResult = gameResult;
	}

	public int getGameScore() {
		return gameScore;
	}

	public void setGameScore(int gameScore) {
		this.gameScore = gameScore;
	}

	public GameBoardModel getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(GameBoardModel gameBoard) {
		this.gameBoard = gameBoard;
	}
	
}
