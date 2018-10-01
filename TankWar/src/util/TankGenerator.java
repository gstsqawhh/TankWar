package util;

import java.util.concurrent.atomic.AtomicLong;

import model.ModelShapePosition;
import model.MoveDirection;
import model.TankCommonModel;
import model.TankGoodModel;
import model.TankLowModel;
import model.TankModel;

public class TankGenerator {
	
	private static class SingleHolder {
		public static TankGenerator tankGenerator = new TankGenerator();
	}
	
	private static AtomicLong tankId = new AtomicLong(0);
	
	private TankGenerator()
	{
		
	}
	
	public static TankGenerator getTankGenerator()
	{
		return SingleHolder.tankGenerator;
	}
	
	public TankModel generate()
	{
		return new TankModel(tankId.getAndIncrement());
	}
	
	public TankModel generateGoodTank(ModelShapePosition modelPosition, MoveDirection direction, String tankName)
	{
		return new TankGoodModel(tankId.getAndIncrement(), modelPosition, direction, tankName);
	}
	
	public TankModel generateMiddleTank(ModelShapePosition modelPosition, MoveDirection direction, String tankName)
	{
		return new TankCommonModel(tankId.getAndIncrement(), modelPosition, direction, tankName);
	}

	public TankModel generateBadTank(ModelShapePosition modelPosition, MoveDirection direction, String tankName)
	{
		return new TankLowModel(tankId.getAndIncrement(), modelPosition, direction, tankName);
	}

}
