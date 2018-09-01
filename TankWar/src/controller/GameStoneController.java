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
				// ģ�ⶨʱ����ʵ��ÿ��0.5sȥ�ƶ��ӵ���Ŀ�������û������ӵ�һֱ���ƶ���
				//TODO: ���о�0.5s���û�����Ӧ�����������ģ���Ϊ200ms��
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
