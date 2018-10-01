package controller;

import message.AttackTankMsg;
import message.GameMsg;
import message.MoveStoneMsg;
import message.MoveTankMsg;
import message.StartGameMsg;
import model.GameModel;
import model.MoveDirection;
import model.Role;

public class GameController {
	
	private GameModel gameModel;
	
	public GameController(GameModel gameModel)
	{
		this.setGameModel(gameModel);
	}
	
	public void moveTank(int tankId, MoveDirection direction)
	{
		GameMsgExecutor.getMsgExecutor().addMsg(new MoveTankMsg(gameModel, tankId, direction));
	}
	
	public void attackTankByPlayer(int tankId, Role role)
	{
		GameMsgExecutor.getMsgExecutor().addMsg(new AttackTankMsg(gameModel, tankId, role));
	}
	  
	public void stoneMove(int stoneId, MoveDirection direction)
	{
		GameMsgExecutor.getMsgExecutor().addMsg(new MoveStoneMsg(gameModel, stoneId, direction));
	}
	
	/**
	 * ������
	 * 1���½������е���̹�˿��������ӵ���������
	 *    ����̹�˿���������֪ͨ��������̹�˿�ʼ�ƶ�������Ƿ��пɹ�����Χ���û�̹�ˣ��еĻ������ڵ�
	 *    �ӵ�����������ʱ�����ӵ���Ⱥ���ƶ�����
	 * 2��ʹ��Ĭ����Ϸ��������GameModel�����½���Ϸ����Ϣ
	 *    GameModelʹ��Ĭ�ϲ����½���ͼ��������CellModel��
	 *    ������GameModel����ڴ��½��û�̹�˺͵���̹�ˣ�
	 *    �½���ͼ��ɺ���UI��������½���Ϣ��UI��ʾ��ͼview������ʾ�û�̹�˺͵���̹�ˣ��û���ʼ����
	 */
	public void startGame()
	{
		// 1�����Ϳ�ʼ��Ϸ��Ϣ
		int gameLevel = 1;
		String playerName = "player";
		int gameBoardWidth = 20;
		int gameBoardHeight = 20;
		GameMsg startGameMsg = new StartGameMsg(gameModel, gameLevel, playerName, gameBoardWidth, gameBoardHeight);
		GameMsgExecutor.getMsgExecutor().addMsg(startGameMsg);
		
		// 2����������̹�˿��������ӵ�������
		GameStoneController stoneController = GameStoneController.getSingleInstance();
		stoneController.setGameModel(gameModel);
		Thread stoneControlThread = new Thread(stoneController);
		stoneControlThread.start();
		
		ComputerTankController tankController = ComputerTankController.getSingleInstance();
		tankController.setGameModel(gameModel);
		Thread tankControlThread = new Thread(tankController);
		tankControlThread.start();
		
	}

	public GameModel getGameModel() {
		return gameModel;
	}

	public void setGameModel(GameModel gameModel) {
		this.gameModel = gameModel;
	}
	

}
