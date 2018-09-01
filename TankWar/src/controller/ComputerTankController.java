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
			System.out.println("����̹�˿�������gameModel����Ϊnull��������");
			return;
		}
		
		while(!isStop)
		{
			// ��ȡ����̹���б���ÿһ��̹�˽����ƶ�����
			moveComputerTanks();
			
			//TODO: CHECK ÿ��500ms�ƶ�һ���û�̹�ˣ���֪�������û����Ի᲻������Ӿ��ϵ�������
			// �Լ��᲻��̹���ƶ�̫������Ϊ200ms��
			
			try 
			{
				Thread.sleep(500);
			}
			catch (InterruptedException e)
			{
				System.out.println(ExceptionUtil.getException(e));
			}
			
			//TODO: ����Ƿ���Ҫ�����Ĺ��ܽ���GameModel����
			// ÿ������̹����GameModel������ƶ��󣬼���Ƿ����û�̹�˴���ͬһ�л�ͬһ�У�
			// �������ͬһ�л���ͬһ�У��û�̹�˲����ӵ������������ȵ�������̹�˷���ʹ��ָ���û���̹��
			// �������ͬһ�л���ͬһ�У����û�̹�����ӵ�������������й�����
			
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
