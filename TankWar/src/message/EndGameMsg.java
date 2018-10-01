package message;

import model.GameModel;

/**
 * 该消息需要负责在结束游戏时关闭控制器线程，如电脑坦克控制器和子弹控制器等
 * @author whstar
 *
 */

public class EndGameMsg extends GameMsg {

	public EndGameMsg(GameModel gameModel)
	{
		super(gameModel, MessageType.GAMEEND);
	}

	@Override
	public void execute()
	{
		gameModel.endGame();
		
	}

}
