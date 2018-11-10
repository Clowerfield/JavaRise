
/* Lab 3d - Simple JAVA program. Main class
* There is Nothing to return
**
@author Vdovichenko A.A.
* @version Alpha 2.0
* @since 2018-10-28
*/

	
import java.io.*;
	class Importer {
		/**
		* Class for re-writing file with synchro-analyzing 
		* There is Nothing to return
		**
		@param args receives a string -- path to input 
		and output files 
		* @return maybe in later versions
		*/
	public static void main (String args[ ]) throws IOException
	{
	 int i;
	 FileInputStream fin;
	
	 FileOutputStream fout;
	 try {
		 try {
			 fin = new FileInputStream(args[0]);	//Input open
		 	} 
		 catch (FileNotFoundException e) {
			 System.out.println ("File not found");	//Warning
			 return;
		 	}
		 try {
			 fout = new FileOutputStream(args[1]);	//Output open
		 	}
		 catch (FileNotFoundException e) {
			 System.out.println ("File not found»"); //Warning
			 return;
		 	}
	 	}
	 catch (ArrayIndexOutOfBoundsException e) {
		 System.out.println ("Using: CopyFile default");
		 return;								//Warning message
	 	}
	 Filter Part = new Filter();		//Analyzing class object
	 try {
		 
		 do {
			 i = fin.read();			//reading a 2 byte slice
			 if(i !=- 1)
				 {
				 	fout.write( Part.Bite(i, (byte) 0));
				 						//writing a 1 byte slice(first)
				 	Part.Analizer(Part.Bite(i, (byte) 0));
				 						//analyzing a 1 byte slice(first)
				 	if(Part.Bite(i, (byte) 1) > 0) {
				 		
				 		fout.write( Part.Bite(i, (byte) 1));
				 						//writing a 1 byte slice(second)
				 		Part.Analizer(Part.Bite(i, (byte) 1));
				 						//analyzing a 1 byte slice(second)
				 	}
				 }
		 } while (i != -1);
		Part.Analizer(Part.Bite(-1, (byte) 1)); //launching a count
	 }
	 catch (IOException e) {
		 System.out.println ("File Error");		//Warning
	 }
	 finally{
		 System.out.format(" D = %d%n", Part.D);	//Dynamic range
		 System.out.format(" E = %d%n", Part.E);	//Energy
		 System.out.format(" P = %.4f%n", Part.P);	//Power
		 System.out.format(" m = %.4f%n", Part.m);	//Middle signals count
		 System.out.format(" d = %.4f%n", Part.d);	//Disperse signals count
		 fin.close();	//Input close
		 fout.close();	//Output close
	 	}
	 }
}


