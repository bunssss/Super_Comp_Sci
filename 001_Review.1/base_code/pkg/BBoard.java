package pkg;
import java.util.*;
import java.io.*;

public class BBoard {		// This is your main file that connects all classes.
	// Think about what your global variables need to be.
	private String ttl;
	private ArrayList<Message> msglists = new ArrayList<Message>();
	private ArrayList<User> userlists = new ArrayList<User>();
	private User currentUser;

	// Default constructor that creates a board with a defaulttitle, empty user and message lists,
	// and no current user
	public BBoard() {
		ttl = "defaulttitle";
	}

	// Same as the default constructor except it sets the title of the board
	public BBoard(String ttl) {	
		this.ttl = ttl;
	}

	// Gets a filename of a file that stores the user info in a given format (users.txt)
	// Opens and reads the file of all authorized users and passwords
	// Constructs a User object from each name/password pair, and populates the userList ArrayList.
	public void loadUsers(String inputFile) throws FileNotFoundException {
		File file = new File(inputFile);
        Scanner sc = new Scanner(file);
        
        String current;
        String username;
        String password;
        User user;
        
        while(sc.hasNextLine()){
            current = sc.nextLine();
            int breaker = current.indexOf(" ");
            
            username = current.substring(0, breaker);
            password = current.substring(breaker+1);
            user = new User(username, password);
            
            userlists.add(user);
		}

}

	// Asks for and validates a user/password. 
	// This function asks for a username and a password, then checks the userList ArrayList for a matching User.
	// If a match is found, it sets currentUser to the identified User from the list
	// If not, it will keep asking until a match is found or the user types 'q' or 'Q' as username to quit
	// When the users chooses to quit, sayu "Bye!" and return from the login function
	public void login(){
		boolean success = false;
		Scanner sc = new Scanner(System.in);
		
		
		while(true){
			
		System.out.print("Username: ");
		String name = sc.nextLine();
		
			if(name.equals("q") || name.equals("Q")){
			break;
		}
		
		System.out.print("Password: ");
		String pass = sc.nextLine();
		
		
		for(int c = 0; c < userlists.size(); c++) {
			if(userlists.get(c).check(name, pass)){
				currentUser = userlists.get(c);
				success = true;
				break;
			} else {
				success = false;
		}
		
		}
		
	if(success = false) {
		System.out.println("Invalid Username/Password");
	}
		
	if(success = true){
			break;
		}
		
		}
	}
	
	// Contains main loop of Bulletin Board
	// IF and ONLY IF there is a valid currentUser, enter main loop, displaying menu items
	// --- Display Messages ('D' or 'd')
	// --- Add New Topic ('N' or 'n')
	// --- Add Reply ('R' or 'r')
	// --- Change Password ('P' or 'p')
	// --- Quit ('Q' or 'q')
	// With any wrong input, user is asked to try again
	// Q/q should reset the currentUser to 0 and then end return
	// Note: if login() did not set a valid currentUser, function must immediately return without showing menu
	public void run(){
		
		login();
		Scanner sc = new Scanner(System.in);
		String input;
		
		if(currentUser == null){
			System.out.println("");
			return;
		}
		
		while(currentUser != null){
		
			System.out.println("---------------------------");
			System.out.println("--- Display Messages ('D' or 'd') \n--- Add New Topic('N' or 'n') \n--- Add Reply ('R' or 'r') \n--- Change Password ('P or 'p') \n--- Quit ('Q' or 'q')");
			System.out.print("Input: ");
			input = sc.nextLine();
			System.out.println("---------------------------");
			
			if(input.equals("D") || input.equals("d")){
				display();
			}
			else if(input.equals("N") || input.equals("n")){
				addTopic();
			}
			else if(input.equals("R") || input.equals("r")){
				addReply();
			}
			else if(input.equals("P") || input.equals("p")){
				setPassword();
			}
			else if(input.equals("Q") || input.equals("q")){
				System.out.println("Bye!");
				currentUser = null;
				return;
			}
			
		}
		

	}

	// Traverse the BBoard's message list, and invote the print function on Topic objects ONLY
	// It will then be the responsibility of the Topic object to invoke the print function recursively on its own replies
	// The BBoard display function will ignore all reply objects in its message list
	private void display(){

		Message a = new Message();

		for(int c = 0; c < msglists.size(); c++){

			a = msglists.get(c);
			boolean rep = a.isReply();

			if(rep == false){
				msglists.get(c).print(0);
			}
		}
	}


	// This function asks the user to create a new Topic (i.e. the first message of a new discussion "thread")
	// Every Topic includes a subject (single line), and body (single line)

	/* 
	Subject: "Thanks"
	Body: "I love this bulletin board that you made!"
	*/

	// Each Topic also stores the username of currentUser; and message ID, which is (index of its Message + 1)

	// For example, the first message on the board will be a Topic who's index will be stored at 0 in the messageList ArrayList,
	// so its message ID will be (0+1) = 1
	// Once the Topic has been constructed, add it to the messageList
	// This should invoke your inheritance of Topic to Message
	private void addTopic(){
		Scanner sc = new Scanner(System.in);
		String author = currentUser.getUsername();
		int id = (msglists.size()+1);
	
		System.out.print("Subject: ");
		String subject = sc.nextLine();
		System.out.print("Body: ");
		String body = sc.nextLine();
		
		
		Topic topic = new Topic(author, subject, body, id);
		msglists.add(topic);
	}

	// This function asks the user to enter a reply to a given Message (which may be either a Topic or a Reply, so we can handle nested replies).
	//		The addReply function first asks the user for the ID of the Message to which they are replying;
	//		if the number provided is greater than the size of messageList, it should output and error message and loop back,
	// 		continuing to ask for a valid Message ID number until the user enters it or -1.
	// 		(-1 returns to menu, any other negative number asks again for a valid ID number)
	
	// If the ID is valid, then the function asks for the body of the new message, 
	// and constructs the Reply, pushing back the Reply on to the messageList.
	// The subject of the Reply is a copy of the parent Topic's subject with the "Re: " prefix.
	// e.g., suppose the subject of message #9 was "Thanks", the user is replying to that message:


	/*
			Enter Message ID (-1 for Menu): 9
			Body: It was a pleasure implementing this!
	*/

	// Note: As before, the body ends when the user enters an empty line.
	// The above dialog will generate a reply that has "Re: Thanks" as its subject
	// and "It was a pleasure implementing this!" as its body.

	// How will we know what Topic this is a reply to?
	// In addition to keeping a pointer to all the Message objects in BBoard's messageList ArrayList
	// Every Message (wheather Topic or Reply) will also store an ArrayList of pointers to all of its Replies.
	// So whenever we build a Reply, we must immediately store this Message in the parent Message's list. 
	// The Reply's constructor should set the Reply's subject to "Re: " + its parent's subject.
	// Call the addChild function on the parent Message to push back the new Message (to the new Reply) to the parent's childList ArrayList.
	// Finally, push back the Message created to the BBoard's messageList. 
	// Note: When the user chooses to return to the menu, do not call run() again - just return fro mthis addReply function. 
	private void addReply(){
		Scanner sc = new Scanner(System.in);
		String auth;
		String subject;
		String body;
		
		System.out.print("Message ID (-1 for Menu): ");
		int id = sc.nextInt();
		
		if(id == -1){
			return;
		}
		
		while(id > msglists.size() || id <= 0){
			System.out.println("\nInvalid ID \n Please Try Again \n---------------------------\n");
			System.out.print("Message ID (-1 for Menu): ");
			id = sc.nextInt();
			
			if(id == -1){
			return;
		}
		
		}
		
		Scanner sc1 = new Scanner(System.in);
		
			System.out.print("Body: ");
			body = sc1.nextLine();
			
			int size = msglists.size();
			
			auth = currentUser.getUsername();
			subject = ("Re: " + msglists.get(id-1).getSubject());
			Reply a = new Reply(auth, subject, body, size+1);
			msglists.get(id-1).addChild(a);
			msglists.add(a);
		}
		

	// This function allows the user to change their current password.
	// The user is asked to provide the old password of the currentUser.
	// 		If the received password matches the currentUser password, then the user will be prompted to enter a new password.
	// 		If the received password doesn't match the currentUser password, then the user will be prompted to re-enter the password. 
	// 		The user is welcome to enter 'c' or 'C' to cancel the setting of a password and return to the menu.
	// Any password is allowed except 'c' or 'C' for allowing the user to quit out to the menu. 
	// Once entered, the user will be told "Password Accepted." and returned to the menu.
	private void setPassword(){

		Scanner sc = new Scanner(System.in);
		boolean success = false;
		String old;
		String newPass;
		

		while(success == false){

			System.out.print("Enter old password: ");
			old = sc.nextLine();

			if(old.equals("c") || old.equals("c")){
				return;
			}

			if(currentUser.check((currentUser.getUsername()), old)){

				while(true){
				System.out.print("Enter new password: ");
				newPass = sc.nextLine();

				if(newPass.equals("c") || newPass.equals("C")){
					System.out.println("You cant use c or C as your new password! \nTry Again!");
					System.out.println("---------------------------");
				}
				else {
					currentUser.setPassword(old, newPass);
					System.out.println("Success!");
					success = true;
					break;
				}
			}
		} 
		
		else {
			System.out.println("Invalid Password \nTry Again!");
			System.out.println("---------------------------");
		}

	}
	
		return;
		
	}

}
