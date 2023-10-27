package lab_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class FriendsList {
	private String username;
	private String fullName;
	private String ip;
	
	public FriendsList() {
		
	}
	
	public FriendsList(String username,String fullName, String ip) {
		this.username=username;
		this.fullName=fullName;
		this.ip=ip;
	}

	public void addFriend(String path, FriendsList data){
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path,true));
			writer.write("["+ data.username + "]" + "\n"+ "["+ data.fullName+"]" + "\n" + "["+ data.ip +"]"+ "\n" + "[IMAGE]");
			writer.newLine();
			writer.close();
			System.out.println("new friend added successfully");
		}
		catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	public List<String> getFriendsList(String path){
	
		List<String> list = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line;
			int counter = 1;
			while((line = reader.readLine())!=null)
			{
				
				list.add(line);
				if(counter%4==0)
					list.add("\n");
				counter++;
				
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
	
	public void displaylist(List<String> list) {
		for (Object item : list) {
          System.out.println(item);
	}
		}
	
	public ArrayList<String> getFriendUsernameList (String path) {
		ArrayList<String> friendlist = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			String line;
			int counter = 0;
			while((line = reader.readLine())!=null)
			{
				if(counter%4==0)
				{
					friendlist.add(line);	
					counter++;
				}
				else
				{
					counter++;
					continue;
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
		return friendlist;
	}
	
	
}
