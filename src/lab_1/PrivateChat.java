package lab_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrivateChat {

	private String sender;
	private String receiver;
	private String message;
	
	public PrivateChat(String sender,String receiver,String message)
	{
		this.sender=sender;
		this.receiver=receiver;
		this.message=message;
	}
	
	public PrivateChat() {
		// TODO Auto-generated constructor stub
	}

	public List<String> getPrivateChat(String path,String username,String selectedUser){
		List <String> priChat = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			while((line=reader.readLine())!=null)
			{
				String[] splited = line.split(" ", 3);
				if(splited[0].equals("<"+username+">") && splited[1].equals(squareBraceExtractor(selectedUser)+","))
				{
					priChat.add(line);
				}
				else if(splited[0].equals("<"+squareBraceExtractor(selectedUser)+">") && splited[1].equals(username+","))
				{
					priChat.add(line);
				}
				
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return priChat;
	}
	
	public void displayPrivateChat(List<String> list)
	{
		if(list.isEmpty())
		{
			System.out.println("you have 0 messages");
		}
		else {
			for(String i: list)
				System.out.println(i);
		}
	}
	public static String squareBraceExtractor(String value) {
		int openBracket = value.indexOf("[");
		int closeBracket = value.indexOf("]");
		value = value.substring(openBracket+1, closeBracket);
		return value;
	}
	
	public void writePrivateChat(String path,PrivateChat data)
	{
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path,true));
			writer.write("<"+data.sender+">"+" "+squareBraceExtractor(data.receiver)+","+" "+data.message);
			writer.newLine();
			writer.close();
			System.out.println("message sent successfully");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
