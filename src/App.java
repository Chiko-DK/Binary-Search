/*
//Author: Chiko Kasongo
//Student number: KSNJOS004
//Dexcription: Assignment4 - Binary Search Tree
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
		Bts<User> tree = new Bts<>();
		
		/*try {
			File dataset = new File("C:\\Users\\LENOVO\\eclipse-workspace\\A4 BST\\src\\dataset.txt");
			Scanner data = new Scanner(dataset);
						
			User newUser;
			
			while (data.hasNextLine()) {
				if(data.next().equals("Create")) {
					String account = data.next();
					String description = data.nextLine();
					newUser = new User(account, description);
					
					tree.insert(newUser);

				} else {
					String account = data.next();
					String clipFile = data.next();
					String likes = data.next();
					String title = data.nextLine();
					Post accPost = new Post(clipFile, likes, title);
					
					BinaryNode<User> user = tree.find(new User(account, ""));

					user.data.addPost(accPost);
				}		 
			}
				
			data.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error has occured.");
			System.out.println("File not found: " + e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println("\nError!!! Please enter a valid action\n");			
		}*/
		
		
		System.out.println("Hi, Welcome to ChikChok.");
		Scanner scan;
		
		while (true) {

			System.out.println("\nPlease choose one option from the menu below:" 
					+ "\n1. Find the profile description for a given account\n"
					+ "2. List all accounts\n"
					+ "3. Create an account\n"
					+ "4. Delete an account\n"
					+ "5. Display all posts for a single account\n"
					+ "6. Add a new post for an account\n"
					+ "7. Load a file of actions from disk and process this\n"
					+ "8. Quit");
			
			System.out.print("Please enter a number from the menu list:\t"); 
			try {
				scan = new Scanner(System.in);
				int input = scan.nextInt();
				System.out.println();
				Scanner dscan;
				
				if (input == 1) {
					System.out.print("Enter the account name:\t");
					dscan = new Scanner(System.in);
					String acc = dscan.nextLine();
					
					BinaryNode<User> user = tree.find(new User(acc, ""));
					if(user != null) {
						String desc = user.data.getDesc();
						System.out.println("The profile description for " + acc + " is: " + desc);
					} else {
						System.out.println("Account not found.");
					}
					
				} else if (input == 2) {
					System.out.println("Please see the list of all the account below:");
					tree.inOrder();
					
				} else if (input == 3) {
					System.out.print("Enter the account name:\t");
					dscan = new Scanner(System.in);
					String acc = dscan.nextLine();
					System.out.print("Enter the account description:\t");
					String desc = dscan.nextLine();
					User newUser = new User(acc, desc);
					tree.insert(newUser);
					System.out.println("Account added successfully!");
					
				} else if (input == 4) {
					System.out.print("Enter the account name to be deleted:\t");
					dscan = new Scanner(System.in);
					String acc = dscan.nextLine();
					User newUser= new User(acc, "");
					BinaryNode<User> user = tree.find(newUser);
					if (user != null) {
						tree.delete(newUser);
						System.out.println("Account deleted successfully!");
					} else {
						System.out.println("Operation unsuccessful! Account does not exist.");
					}
					
				} else if (input == 5) {
					System.out.print("Enter the account name:\t");
					dscan = new Scanner(System.in);
					String acc = dscan.nextLine();
					BinaryNode<User> user = tree.find(new User(acc, ""));
					if(user != null) {
						user.data.printPosts();
					} else {
						System.out.println("Account not found.");
					}
					
				} else if (input == 6) {
					System.out.print("Enter the account name:\t");
					dscan = new Scanner(System.in);
					String acc = dscan.nextLine();
					BinaryNode<User> user = tree.find(new User(acc, ""));
					if(user != null) {
						System.out.print("Enter the video title:\t");
						String title = dscan.nextLine();
						System.out.print("Enter the video file name:\t");
						String video = dscan.nextLine();
						System.out.print("Enter the number of likes:\t");
						String likes = dscan.nextLine();
						
						Post newPost = new Post(video, likes, title);
						user.data.addPost(newPost);						
					} else {
						System.out.println("Account not found.");
					}
					
				} else if (input == 7) {
					System.out.print("Enter the location of the file name:\t");
					dscan = new Scanner(System.in);
					String path = dscan.nextLine();
					File file = new File(path);
					Scanner data = new Scanner(file);
					while (data.hasNextLine()) {
						if(data.next().equals("Create")) {
							String account = data.next();
							String description = data.nextLine();
							User newUser = new User(account, description);
							tree.insert(newUser);
						} else {
							String account = data.next();
							String clipFile = data.next();
							String likes = data.next();
							String title = data.nextLine();
							Post accPost = new Post(clipFile, likes, title);
							//accPost.printPost();
							
							BinaryNode<User> user = tree.find(new User(account, ""));
							user.data.addPost(accPost);		
						}		 
					}
					System.out.println("File added successfully!");
					data.close();
					
				} else if (input == 8) {
					System.out.println("Bye! Hope to see you again!");
					break;
					
				} else {
					System.out.println("Error!!! Please enter a number between 1 and 8.\n");
				}
				
				
			} catch (InputMismatchException e){
				System.out.println("\nError!!! Please enter a number between 1 and 8.\n");
			} catch (NoSuchElementException e) {
				System.out.println("\nError!!! Please enter a valid action\n");
			} catch (FileNotFoundException e) {
				System.out.println("An error has occured.");
				System.out.println("File not found: " + e.getMessage());
			} catch (NullPointerException e) {
				System.out.println("\nError!!! Please enter a valid action\n");
			}
			
		}
		scan.close();
		
	
	}
}
