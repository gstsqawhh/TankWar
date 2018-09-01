package util;

import java.util.concurrent.atomic.AtomicLong;

import model.StoneModel;


public class StoneGenerator {
	
	private static class SingleHolder {
		public static StoneGenerator stoneGenerator = new StoneGenerator();
	}
	
	private static AtomicLong stoneId = new AtomicLong(0);
	
	private StoneGenerator()
	{
		
	}
	
	public static StoneGenerator getStoneGenerator()
	{
		return SingleHolder.stoneGenerator;
	}
	
	public StoneModel generate()
	{
		return new StoneModel(stoneId.getAndIncrement());
	}
	
	public StoneModel generateGoodStone()
	{
		
	}
	
	public StoneModel generateMiddleStone()
	{
		
	}

	public StoneModel generateBadStone()
	{
		
	}
	
}
