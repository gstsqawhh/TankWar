package util;

import java.util.concurrent.atomic.AtomicLong;

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
	

}
