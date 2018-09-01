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
		// 新建GameModel、GameController和相关线程等
		
		// 1、新建GameModel
		GameModel gameModel = new GameModel();
		
		// 2、新建GameController
		GameController gameControl = new GameController(gameModel);
		
		
		// 新建页面Panel，注册GameListener监听器，并且监听GameModel
		// 如果Panel运行后GameLauncher所在主线程不会退出，则可以不写循环，否则需要写循环
		TankWarView mainView = new TankWarView(gameControl);		
		mainView.show();
		
		// 使得mainView监听GameModel
		gameModel.addObserver(mainView);
		
		// 运行消息队列处理器
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
