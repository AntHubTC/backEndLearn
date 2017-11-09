import java.util.GregorianCalendar;
import java.util.Calendar;
public class GCalendar{
	public static void main(String[] args)
	{
		GregorianCalendar gc=new GregorianCalendar();
		int x=gc.get(Calendar.MONTH);
		int dayOfMonth = gc.get(Calendar.DAY_OF_MONTH);
		System.out.println(x);
		System.out.println(dayOfMonth);
		System.out.println(Calendar.HOUR_OF_DAY);
	}
}
