import java.text.DecimalFormat;
public class decimalFormat {
	public static void SimgleFormat(String pattern,double value)
	{
		DecimalFormat myFormat = new DecimalFormat(pattern);
		String output = myFormat.format(value);
		System.out.println(value+""+pattern+""+output);
	}
	public static void UseApplyPatternMethodFormat(String pattern,double value)
	{
		DecimalFormat myFormat = new DecimalFormat();
		myFormat.applyPattern(pattern);
		System.out.println(value+""+pattern+""+myFormat.format(value));
	}
	public static void main(String[] args)
	{
		
		SimgleFormat("####,###.###",123456.789);
		SimgleFormat("000000000.###kg",123456.789);
		SimgleFormat("000000.000",123.78);
		UseApplyPatternMethodFormat("#.###%",0.789);
		UseApplyPatternMethodFormat("###.##",123456.79);
		UseApplyPatternMethodFormat("0.00\u2030",0.789);
	}

}
