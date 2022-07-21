package conventional_zlib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.*;

public class ConventionalInflater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File ifile = new File(args[0]);
		File ofile = new File(args[1]);
	    if(!ifile.exists()) {
			try {
				ifile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    if(!ofile.exists()) {
			try {
				ofile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			FileInputStream fin = new FileInputStream(ifile);
			FileOutputStream fout = new FileOutputStream(ofile);
			byte[] input = fin.readAllBytes();
			byte[] output = new byte[(int) (input.length * 3.5)];
			System.out.println(input.length);
		    Inflater decompresser = new Inflater();
		    decompresser.setInput(input, 0, input.length);
		    int resultLength = decompresser.inflate(output);
		    decompresser.end();
		    System.out.println(resultLength);
		    fout.write(output,0,resultLength);
			fin.close();
			fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
