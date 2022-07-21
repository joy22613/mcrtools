package conventional_zlib;
import java.io.*;
import java.util.Scanner;
import java.util.zip.*;

public class ConventionalDeflater {

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
			byte[] output = new byte[input.length];
			System.out.println(input.length);
		    Deflater compresser = new Deflater();
		    compresser.setInput(input);
		    compresser.finish();
		    int compressedDataLength = compresser.deflate(output);
		    compresser.end();
		    System.out.println(compressedDataLength);
		    fout.write(output,0,compressedDataLength);
			fin.close();
			fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
