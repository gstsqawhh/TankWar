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
	 * 描述：
	 * 1、新建并运行电脑坦克控制器和子弹控制器，
	 *    电脑坦克控制器负责通知各个电脑坦克开始移动，检查是否有可攻击范围的用户坦克，有的话发射炮弹
	 *    子弹控制器负责定时遍历子弹，群发移动命令
	 * 2、使用默认游戏参数，向GameModel发送新建游戏的消息
	 *    GameModel使用默认参数新建地图，即各个CellModel，
	 *    按：由GameModel在入口处新建用户坦克和电脑坦克，
	 *    新建地图完成后，向UI返回完成新建消息，UI显示地图view，并显示用户坦克和电脑坦克，用户开始操作
	 */
	public void startGame()
	{
		// 1、发送开始游戏消息
		int gameLevel = 1;
		String playerName = "player";
		int gameBoardWidth = 20;
		int gameBoardHeight = 20;
		GameMsg startGameMsg = new StartGameMsg(gameModel, gameLevel, playerName, gameBoardWidth, gameBoardHeight);
		GameMsgExecutor.getMsgExecutor().addMsg(startGameMsg);
		
		// 2、启动电脑坦克控制器和子弹控制器
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
