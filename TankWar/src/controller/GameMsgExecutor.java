package controller;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import message.GameMsg;

public class GameMsgExecutor implements Runnable {

	
	private BlockingQueue<GameMsg> msgQueue = new ArrayBlockingQueue<>(100);
		
	private static GameMsgExecutor msgExecutor = new GameMsgExecutor();
		
	public static GameMsgExecutor getMsgExecutor()
	{
		return msgExecutor;
	}
	
	private GameMsgExecutor()
	{
		
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				GameMsg gameMsg = msgQueue.poll(1000, TimeUnit.MILLISECONDS);
				if (null != gameMsg)
				{
					gameMsg.execute();
				}
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
	}
	
	public void addMsg(GameMsg msg)
	{
		try
		{
			msgQueue.put(msg);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}
