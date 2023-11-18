/**
 * 
 */
package com.ExceptionHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @author Aron
 * This class is designed to capture and log exception error messages from the system. By recording these errors in a file, 
 * developers can identify and resolve issues more efficiently during the development process.
 *
 */
public class ExceptionHandler {

	private static final String filePath = "C:\\Gebeya\\Abinet Assignment\\java-lab1\\src\\com\\ExceptionHandler\\System.log";
	
	public void WriteSystemLog(Throwable tr) {
		try {
			File myObj = new File(filePath);
		      Scanner myReader = new Scanner(myObj);
		      String data = null;
		      while (myReader.hasNextLine()) {
		         data = myReader.nextLine();
		      }
		      myReader.close();
		      
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true));
			writer.write(data + tr + " "+ LocalDateTime.now());
			writer.newLine();
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			WriteSystemLog(e);
			e.printStackTrace();
		}
		
	}
}

