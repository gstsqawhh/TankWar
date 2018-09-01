package controller;

import java.util.List;

import message.MoveTankMsg;
import model.GameModel;
import model.TankModel;
import util.ExceptionUtil;

public class ComputerTankController implements Runnable {

	private volatile boolean isStop = false;
	
	private GameModel gameModel = null;
	
	private static class SingleHolder {
		public static ComputerTankController tankController = new ComputerTankController();
	}
	
	public static ComputerTankController getSingleInstance()
	{
		return SingleHolder.tankController;
	}
	
	@Override
	public void run()
	{
		if (null == gameModel)
		{
			System.out.println("电脑坦克控制器的gameModel属性为null，不合理！");
			return;
		}
		
		while(!isStop)
		{
			// 获取电脑坦克列表，对每一辆坦克进行移动操作
			moveComputerTanks();
			
			//TODO: CHECK 每隔500ms移动一下用户坦克，不知道对于用户而言会不会产生视觉上的跳动？
			// 以及会不会坦克移动太慢，改为200ms？
			
			try 
			{
				Thread.sleep(500);
			}
			catch (InterruptedException e)
			{
				System.out.println(ExceptionUtil.getException(e));
			}
			
			//TODO: 检测是否需要攻击的功能交给GameModel来做
			// 每个电脑坦克在GameModel中完成移动后，检测是否与用户坦克处于同一行或同一列，
			// 如果处于同一行或者同一列，用户坦克不在子弹攻击方向，则先调整电脑坦克方向，使其指向用户的坦克
			// 如果处于同一行或者同一列，且用户坦克在子弹攻击方向，则进行攻击。
			
		}
	}
	
	private void moveComputerTanks()
	{
		List<TankModel> computerTanks = gameModel.getTanksOfComputer();
		for (TankModel computerTank : computerTanks)
		{
			GameMsgExecutor.getMsgExecutor().addMsg(
					new MoveTankMsg(gameModel, computerTank.getTankId(), computerTank.getMoveDirection()));
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
