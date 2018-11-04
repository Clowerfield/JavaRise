import java.util.ArrayList;
import java.util.List;

public class Filter {
	public static int D;
	public static long E;
	public static double P;
	public static double m;
	public static double d;
	
	public static int Counter;
	public static int Sum;
	public static int Max;
	public static int Min;
	public static int QSum;
	
	public Filter() {
		D = 0;
		E = 0;
		P = 0;
		m = 0;
		d = 0;
		
  Counter = 0;
	  Sum = 0;
	  Max = 0;
	  Min = 255;
	 QSum = 0;
	}
	public static int Bite(int i, byte j) {
		int[] slice = new int[2] ;
		slice[0] = (byte) (i & 0xFF);
		slice[1] = (byte) ((i >> 8) & 0xFF);
		return slice[j];
	}
	public static void Disperser(int income) {
		List<Integer> dis = new ArrayList();
		double disperse = 0;
		if(income == -1) {
			for(int i = 0; i < dis.size(); i++)
			{
				disperse += ((double)dis.get(i) - m)*((double)dis.get(i) - m);
			}
			d = disperse / (double)Counter;
		}
		dis.add(income);
		
	}
	static Filter frnd = new Filter();
	public static void Analizer(int income) {
		
		Counter ++; 
		Sum =+ income;
		QSum =+ income * income;
		if(income > Max) Max = income;
		if(income < Min) Min = income;
		frnd.Disperser(income);
		if(income == -1) {
			D = Max - Min;
			E = QSum;
			P =(double) QSum / (double)Counter;
			m = (double)Sum / (double)Counter;
			
		}
		
	}
	
}

