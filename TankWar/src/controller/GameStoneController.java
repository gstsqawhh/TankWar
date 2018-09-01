package controller;

import java.util.List;

import message.MoveStoneMsg;
import model.GameModel;
import model.StoneModel;
import util.ExceptionUtil;

public class GameStoneController implements Runnable {

	private volatile boolean isStop = false;
	
	private GameModel gameModel;
	
	private static class SingleHolder {
		public static GameStoneController stoneController = new GameStoneController();
	}
	
	public static GameStoneController getSingleInstance()
	{
		return SingleHolder.stoneController;
	}
	
	@Override
	public void run()
	{
		while(!isStop)
		{
			List<StoneModel> stonesOfGame = gameModel.getStonesOfGame();
			for (StoneModel stone : stonesOfGame)
			{
				GameMsgExecutor.getMsgExecutor().addMsg(
						new MoveStoneMsg(gameModel, stone.getStoneId(), stone.getMoveDirection()));
			}
			
			try
			{
				// 模拟定时器，实现每隔0.5s去移动子弹，目标是在用户看来子弹一直在移动，
				//TODO: 但感觉0.5s在用户看来应该是有跳动的，改为200ms？
				Thread.sleep(500);
			}
			catch (InterruptedException e)
			{
				System.out.println(ExceptionUtil.getException(e));
			}
		}
	}

	public boolean isStop() {
		return isStop;
	}

	public void setStop(boolean isStop) {
		this.isStop = isStop;
	}

	public GameModel getGameModel() {
		return gameModel;
	}

	public void setGameModel(GameModel gameModel) {
		this.gameModel = gameModel;
	}

}
