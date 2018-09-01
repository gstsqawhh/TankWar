package util;

public class ExceptionUtil {

	
	public static String getException(Exception e)
	{
		StringBuffer sb = new StringBuffer();
		StackTraceElement[] elements = e.getStackTrace();
		for (StackTraceElement element : elements)
		{
			sb.append(element.toString() + "\n");
		}
		return sb.toString();
	}
	
}
