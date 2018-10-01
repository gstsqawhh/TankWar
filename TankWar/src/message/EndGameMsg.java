package message;

import model.GameModel;

/**
 * ����Ϣ��Ҫ�����ڽ�����Ϸʱ�رտ������̣߳������̹�˿��������ӵ���������
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
