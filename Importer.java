	import java.io.*;
	class Importer {
	public static void main (String args[ ]) throws IOException
	{
	 int i;
	 FileInputStream fin;
	
	 FileOutputStream fout;
	 try {
		 try {
			 fin = new FileInputStream(args[0]);
		 	} 
		 catch (FileNotFoundException e) {
			 System.out.println ("File not found");
			 return;
		 	}
		 try {
			 fout = new FileOutputStream(args[1]);
		 	}
		 catch (FileNotFoundException e) {
			 System.out.println ("File not found»");
			 return;
		 	}
	 	}
	 catch (ArrayIndexOutOfBoundsException e) {
		 System.out.println ("Using: CopyFile default");
		 return;
	 	}
	 Filter Part = new Filter();
	 try {
		 
		 do {
			 i = fin.read();
			
			 if(i !=- 1)
				 {
				 	
				 	fout.write( Part.Bite(i, (byte) 0));
				 	Part.Analizer(Part.Bite(i, (byte) 0));
				 	if(Part.Bite(i, (byte) 1) > 0) {
				 		fout.write( Part.Bite(i, (byte) 1));
				 		Part.Analizer(Part.Bite(i, (byte) 1));
				 	}
				 }
		 } while (i != -1);
		 Part.Analizer(Part.Bite(-1, (byte) 1));
	 }
	 catch (IOException e) {
		 System.out.println ("File Error");
	 	}
	 System.out.println(Part.D);
	 System.out.println(Part.E);
	 System.out.println(Part.P);
	 System.out.println(Part.m);
	 System.out.println(Part.d);
	 fin.close();
	 fout.close();
	 }
	}


