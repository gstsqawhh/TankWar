package util;

import java.util.concurrent.atomic.AtomicLong;

import model.StoneLowModel;
import model.StoneGoodModel;
import model.StoneCommonModel;
import model.ModelShapePosition;
import model.MoveDirection;
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
	
	public StoneModel generateGoodStone(long tankId, ModelShapePosition modelPosition, MoveDirection direction)
	{
		return new StoneGoodModel(stoneId.getAndIncrement(), tankId, modelPosition, direction);
	}
	
	public StoneModel generateMiddleStone(long tankId, ModelShapePosition modelPosition, MoveDirection direction)
	{
		return new StoneCommonModel(stoneId.getAndIncrement(), tankId, modelPosition, direction);
	}

	public StoneModel generateBadStone(long tankId, ModelShapePosition modelPosition, MoveDirection direction)
	{
		return new StoneLowModel(stoneId.getAndIncrement(), tankId, modelPosition, direction);
	}
	
}
