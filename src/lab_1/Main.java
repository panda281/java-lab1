package lab_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
	
// This code is review  by Aron and I added some try catch blocks. 

public class Main {


	private static final String friendListPath = "friends.list";
	private static final String publichatPath = "Eurakarte.log";
	private static final String privatechatPath = "Donut[AFK].log";
	
	public String friendSelector() {
		
		ArrayList<String> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		FriendsList friends = new FriendsList();
		list = friends.getFriendUsernameList(friendListPath);
		int Chatchoice;
		System.out.println("select chat: ");
		for (int i = 0; i < list.size(); i++) {
		      System.out.println(i+1 +" " +list.get(i));
		    }
		Chatchoice = scan.nextInt();
		while(Chatchoice<=0|| Chatchoice>list.size())
		{
			System.out.println("you inserted a wrong number please insert the correct choice number again!!");
			Chatchoice = scan.nextInt();
		}
		return list.get(Chatchoice-1);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String username;
		FriendsList friends = new FriendsList();
		PublicChat publiChat = new PublicChat();
		PrivateChat privatechat = new PrivateChat();
		Main main = new Main();

		
		System.out.println("insert your username");
		Scanner scan = new Scanner(System.in);
		username= scan.next();
		int choice;
		try {
		
		do {
			System.out.println("");
			System.out.println("choose ");
			System.out.println("insert 1 to list friends");
			System.out.println("insert 2 to add friends");
			System.out.println("insert 3 to read public message");
			System.out.println("insert 4 to send public message");
			System.out.println("insert 5 to read private message");
			System.out.println("insert 6 to send private message");
			System.out.println("insert 7 to change your username");
			System.out.println("insert 8 to quit the app");
			choice = scan.nextInt();
			System.out.println("");
			switch(choice) {
			case 1: List<String> friendslist = new ArrayList<>();
					friendslist = friends.getFriendsList(friendListPath);
					friends.displaylist(friendslist);
					break;
					
			case 2: String newusername;
					String friends_name;
					String friends_ip;
					System.out.println("insert username ");
					newusername = scan.next();
					scan.nextLine();
					System.out.println("insert friend full name ");
					friends_name = scan.nextLine();
					System.out.println("insert friend IP ");
					friends_ip = scan.next();
					FriendsList friendss = new FriendsList(newusername,friends_name,friends_ip);
					friends.addFriend(friendListPath,friendss);
					break;
					
			case 3: List <String> pubChatList = new ArrayList<>();
					pubChatList = publiChat.getPublicChat(publichatPath);
					publiChat.displayPublicChat(pubChatList);
					break;
					
			case 4: String pubmessage;
					System.out.println("insert the message");
					scan.nextLine();
					pubmessage = scan.nextLine();
					PublicChat publiChatt = new PublicChat(username,pubmessage);
					publiChat.writePublicChat(publichatPath, publiChatt);
					break;
			
			case 5: String friend_choice = main.friendSelector();
					privatechat.displayPrivateChat(privatechat.getPrivateChat(privatechatPath, username, friend_choice));
					break;
					
			case 6: String friends_choice = main.friendSelector();
					String privmessage;
					System.out.println("insert the message");
					scan.nextLine();
					privmessage = scan.nextLine();
					PrivateChat privatechatt = new PrivateChat(username, friends_choice, privmessage);
					privatechatt.writePrivateChat(privatechatPath, privatechatt);
					break;
					
			case 7: System.out.println("please insert your name");
					username = scan.next();
					System.out.println("your username updated successfully");
					break;
			case 8: System.out.println("Thank you!");
			System.exit(0); 
			break;
			}
		}
		while(choice!=8);
		System.exit(0);
		}
		catch(Exception ex) {
			System.out.println("Please Follow instruction!");
			exceptionThrow();
			
		}
	}
	private static void exceptionThrow() throws IOException {
		main(null);
	}

}
