/* Lab 3d - Simple JAVA program. Support class
* There is Nothing to return
**
@author Vdovichenko A.A.
* @version Alpha 2.0
* @since 2018-10-28
*/

import java.util.ArrayList;
import java.util.List;

public class Filter {
	/**
	* Class for analyzing data stream 
	* There is Nothing to return
	**
	@param args receives a string -- path to input 
	and output files 
	* @return maybe in later versions
	*/
	public static int D;	//Dynamic range
	public static long E;	//Energy
	public static double P; //Power
	public static double m; //Middle signals count
	public static double d; //Disperse signals count
	
	public static int Counter;
	public static int Sum;
	public static int Max;	//Value of signal
	public static int Min;	//Value of signal
	public static int QSum;	//Sum of squares
	public static List<Integer> dis;
							//dynamic array
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
	 dis = new ArrayList();
	}
	public static int Bite(int i, byte j) {
					//Converting integer to byte Method
		int[] slice = new int[2] ; //navigation signals
		slice[0] = (byte) (i & 0xFF);	//first part
		slice[1] = (byte) ((i >> 8) & 0xFF); //second
		return slice[j];	
	}
	public static void Disperser(int income) {
			//method for asynchronic disperse counting
		double disperse = 0;	
		if(income == -1) {
			for(int i = 0; i < dis.size(); i++)
			{
				disperse += ((double)dis.get(i) - m)
						*((double)dis.get(i) - m);
				//disperse counting
			}
			d = disperse / (double)Counter;
		}
		dis.add(income);	//memorizing data
		
	}
	static Filter frnd = new Filter();	//filter object
	public static void Analizer(int income) {
				//method for synchronic data analizing
		if(income != -1) {
		Counter ++; 
		Sum =+ income;					//Global sum
		QSum =+ income * income;		//QSum
		if(income > Max) Max = income;	//Max filter
		if(income < Min) Min = income;	//Min filter
		}
		frnd.Disperser(income);		//disperse call
		if(income == -1) {
			D = Max - Min;			//format saving
			E = QSum;				//format saving
			P =(double)QSum / (double)Counter;
			m =(double)Sum / (double)Counter;
			
		}
		
	}
	
}

