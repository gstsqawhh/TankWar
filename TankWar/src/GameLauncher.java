import javax.swing.SwingUtilities;

import controller.GameController;
import controller.GameMsgExecutor;
import model.GameModel;
import view.TankWarView;

public class GameLauncher {
	
	
	
	public GameLauncher()
	{
		initGame();
	}
	
	private void initGame()
	{
		// �½�GameModel��GameController������̵߳�
		
		// 1���½�GameModel
		GameModel gameModel = new GameModel();
		
		// 2���½�GameController
		GameController gameControl = new GameController(gameModel);
		
		
		// �½�ҳ��Panel��ע��GameListener�����������Ҽ���GameModel
		// ���Panel���к�GameLauncher�������̲߳����˳�������Բ�дѭ����������Ҫдѭ��
		TankWarView mainView = new TankWarView(gameControl);		
		mainView.show();
		
		// ʹ��mainView����GameModel
		gameModel.addObserver(mainView);
		
		// ������Ϣ���д�����
		GameMsgExecutor msgExecutor = GameMsgExecutor.getMsgExecutor();
		Thread msgExecutorThread = new Thread(msgExecutor);
		msgExecutorThread.start();
		
		
	}
	
	public static void main(String[] args)
	{
		Runnable runnable = gameRunnable();
        SwingUtilities.invokeLater(runnable);
		
	}
	
    protected static Runnable gameRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                new GameLauncher();
            }
        };
    }

}
