package lab_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PublicChat {
	private String sender;
	private String message;
	
	public PublicChat() {
		//unnecessary constructor 
	}
	
	public PublicChat(String sender, String message) {
		this.sender = sender;
		this.message = message;
	}

	public List<String> getPublicChat(String path){
		List<String> list = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			while((line = reader.readLine())!=null)
			{
				list.add(line);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	public void displayPublicChat(List<String> list) {
		try {
		for(Object publicChatList: list)
			System.out.println(publicChatList);
		}
		catch(Exception ex) {
			System.out.print(ex.getMessage());
			}
	}
	
	public void writePublicChat(String path, PublicChat data) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path,true));
			writer.write("<"+data.sender+">" + " "+ data.message);
			writer.newLine();
			writer.close();
			
			System.out.println("message sent to public chat successfully");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
