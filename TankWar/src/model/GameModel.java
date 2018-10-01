package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import util.TankGenerator;
import view_model.StartGameViewObject;

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
	
//	public GameModel(int gameLevel, String name, TankModel userTank, GameBoardModel gameBoard,
//			List<TankModel> tanksOfComputor, List<StoneModel> stonesOfGame, GameResult res, int score)
//	{
//		this.gameLevel = gameLevel;
//		this.playerName = name;
//		this.userTank = userTank;
//		this.gameBoard = gameBoard;
//		this.tanksOfComputer = tanksOfComputor;
//		this.stonesOfGame = stonesOfGame;
//		this.gameResult = res;
//		this.gameScore = score;
//	}
	
	public void startGame(int gameLevel, String playerName, int gameBoardWidth, int gameBoardHeight) {
		this.gameLevel = gameLevel;
		this.playerName = playerName;
		
		// 生成地图
		gameBoard = new GameBoardModel(gameBoardWidth, gameBoardHeight);
		gameBoard.generateGameMap();
		
		// 初始化生成坦克
		generateUserTank();
		
		// 向UI通知startGameViewObject
		StartGameViewObject startGameViewObj = new StartGameViewObject();
		notifyObservers(startGameViewObj);
	}
	
	/**
	 * 	有两种初始化生成坦克的方式：
		// 方式1：选择一个特定的入口，假如cells[0][0]总被设置为通道，则坦克总在这里生成，有可能重合
		//        或者选择几个特定的入口，
		// 方式2：在整个地图中随机遍历，将要生成的坦克放到任意通道格子中，需要注意生成坦克时，需要判断
		//        新生成的坦克是否与之前生成的坦克重合，如果重合，则需要重新选择位置生成
		// 目前来看，选择方式2较为合理，有更大的选择性
	 */
	public void generateUserTank()
	{
		CellModel[][] cells = gameBoard.getCells();
		while(true) {
			// 随机找到一个格子
			int randomWidth = (int) (Math.random() * gameBoard.getWidth());
			int randomHeight = (int) (Math.random() * gameBoard.getHeight());
			CellModel cell = cells[randomWidth][randomHeight];
			if (!cell.isWall()) {
				// 用户坦克是第一个生成的坦克，因此不需检查cell上是否已有坦克
				String tankName = "tankOf" + playerName;
				MoveDirection direction = MoveDirection.NORTH;
				ModelShapePosition tankModelPosition = new ModelShapePosition(cell, gameBoard.getWidth(), gameBoard.getHeight());
				userTank = TankGenerator.getTankGenerator().generateGoodTank(tankModelPosition, direction, tankName);
				break;
			}
		}
	}
	
	public void newStone()
	{
		
	}
	
	public void moveStone()
	{
		
	}
	
	/*
	 * 预期生成电脑坦克
	 */
	public void newTank() {	
		CellModel[][] cells = gameBoard.getCells();
		while(true) {
			// 随机找到一个格子
			int randomWidth = (int) (Math.random() * gameBoard.getWidth());
			int randomHeight = (int) (Math.random() * gameBoard.getHeight());
			CellModel cell = cells[randomWidth][randomHeight];
			if (!cell.isWall()) {
				// 生成电脑坦克需要检查该通道格子上是否已有坦克
				if (hasTankInCell(cell)) {
					continue;
				}
				String tankName = "tankOf" + playerName;
				MoveDirection direction = MoveDirection.NORTH;
				ModelShapePosition tankModelPosition = new ModelShapePosition(cell, gameBoard.getWidth(), gameBoard.getHeight());
				tanksOfComputer.add(TankGenerator.getTankGenerator().generateMiddleTank(tankModelPosition, direction, tankName));
				break;
			}
		}
	}
	
	private boolean hasTankInCell(CellModel cell) {
		// 先检查用户坦克是否正处在该格子

		if (isTankInCell(userTank, cell)) {
			return true;
		}
		
		// 然后检查电脑坦克列表是否处于该格子
		for (TankModel computerTank : tanksOfComputer) {
			if (isTankInCell(computerTank, cell)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isTankInCell(TankModel tank, CellModel cell) {
		int x = cell.getX();
		int y = cell.getY();
		ModelShapePosition modelPosition = tank.getModelShapePosition();
		BoardPoint ldPoint = modelPosition.getLeftDownPiont();
		BoardPoint ruPoint = modelPosition.getRightUpPiont();
		// 判断坦克和cell是否有重合的部分
		if ( ((ldPoint.getX() >= x && ldPoint.getX() < (x+1)) ||  (ruPoint.getX() > x && ruPoint.getX() <= (x+1)))
				&& ((ldPoint.getY() >= y && ldPoint.getY() < (y+1)) ||  (ruPoint.getY() > y && ruPoint.getY() <= (y+1)))) {
			return true;
		}
		return false;
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

	public void endGame() {
		// TODO Auto-generated method stub
		
	}
	
}
