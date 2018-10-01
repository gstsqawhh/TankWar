package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import util.TankGenerator;
import view_model.StartGameViewObject;

/**
 * ������帺����Ϸ�������߼������½���Ϸ��̹���½���̹���ƶ���̹�˹������ӵ��½����ӵ��ƶ������ٵȵ�
 * @author whstar
 *
 */

public class GameModel extends Observable {
	
	private int gameLevel;
	
	private String playerName;
	
	private GameBoardModel gameBoard;
	
	private TankModel userTank;
	
	private List<TankModel> tanksOfComputer; //��Ҫ�����̵߳�ͬ������Ϊ���ڲ�ͬ�̶߳�д
	
	private List<StoneModel> stonesOfGame; //��Ҫ�����̵߳�ͬ������Ϊ���ڲ�ͬ�̶߳�д
	
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
		
		// ���ɵ�ͼ
		gameBoard = new GameBoardModel(gameBoardWidth, gameBoardHeight);
		gameBoard.generateGameMap();
		
		// ��ʼ������̹��
		generateUserTank();
		
		// ��UI֪ͨstartGameViewObject
		StartGameViewObject startGameViewObj = new StartGameViewObject();
		notifyObservers(startGameViewObj);
	}
	
	/**
	 * 	�����ֳ�ʼ������̹�˵ķ�ʽ��
		// ��ʽ1��ѡ��һ���ض�����ڣ�����cells[0][0]�ܱ�����Ϊͨ������̹�������������ɣ��п����غ�
		//        ����ѡ�񼸸��ض�����ڣ�
		// ��ʽ2����������ͼ�������������Ҫ���ɵ�̹�˷ŵ�����ͨ�������У���Ҫע������̹��ʱ����Ҫ�ж�
		//        �����ɵ�̹���Ƿ���֮ǰ���ɵ�̹���غϣ�����غϣ�����Ҫ����ѡ��λ������
		// Ŀǰ������ѡ��ʽ2��Ϊ�����и����ѡ����
	 */
	public void generateUserTank()
	{
		CellModel[][] cells = gameBoard.getCells();
		while(true) {
			// ����ҵ�һ������
			int randomWidth = (int) (Math.random() * gameBoard.getWidth());
			int randomHeight = (int) (Math.random() * gameBoard.getHeight());
			CellModel cell = cells[randomWidth][randomHeight];
			if (!cell.isWall()) {
				// �û�̹���ǵ�һ�����ɵ�̹�ˣ���˲�����cell���Ƿ�����̹��
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
	 * Ԥ�����ɵ���̹��
	 */
	public void newTank() {	
		CellModel[][] cells = gameBoard.getCells();
		while(true) {
			// ����ҵ�һ������
			int randomWidth = (int) (Math.random() * gameBoard.getWidth());
			int randomHeight = (int) (Math.random() * gameBoard.getHeight());
			CellModel cell = cells[randomWidth][randomHeight];
			if (!cell.isWall()) {
				// ���ɵ���̹����Ҫ����ͨ���������Ƿ�����̹��
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
		// �ȼ���û�̹���Ƿ������ڸø���

		if (isTankInCell(userTank, cell)) {
			return true;
		}
		
		// Ȼ�������̹���б��Ƿ��ڸø���
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
		// �ж�̹�˺�cell�Ƿ����غϵĲ���
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
