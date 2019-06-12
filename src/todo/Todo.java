package todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Todo {

	public static Scanner input = new Scanner(System.in);

	public static ArrayList<Account> accounts = new ArrayList<Account>();
	public static ArrayList<Task> tasks = new ArrayList<Task>();
	public static ArrayList<Task> finishedTasks = new ArrayList<Task>();

	public static void main(String[] args) {

		int firstChoice, choice;
		boolean loggedIn = false;
		String accountOwner="", password, taskOwner;
		
		Account newAccount = new Account("Ermina", "123456"); 
		
		AccountManager accountManager= new AccountManager();
		TaskManager taskManager = new TaskManager();
		
		accounts.add(newAccount); 

		do {
			System.out.println("1--> create an account");
			System.out.println("2--> logg in");
			firstChoice = input.nextInt();

			if (firstChoice == 1) { 
				
				input.nextLine();
				System.out.println("Input name: ");
				accountOwner=input.nextLine();
				
				if(accountOwner.length()<3) {
					do {
						System.out.println("Name length must be larger than 2 characters! Input name again:");
						accountOwner=input.nextLine();
					} while(accountOwner.length()<3);
					
				}
				
				System.out.println("Input password: ");
				password=input.nextLine();
				
				if(password.length()<5) {
					do {
						System.out.println("Password length must be larger than 4 characters! Input password again:");
						password=input.nextLine();
					} while(password.length()<5);
					
				}
				
				accountManager.createAccount(accounts, accountOwner, password);
				
				System.out.println("You have successfully created an account!");
				
				loggedIn=true;

			} else if (firstChoice == 2) {
				
				input.nextLine();
				System.out.println("Input name: ");
				accountOwner=input.nextLine();
				
				if(!accountManager.doesNameExist(accounts,accountOwner)) {
					do {
						System.out.println("Name doesn't exist! Input again!");
						accountOwner=input.nextLine();
					} while(accountManager.doesNameExist(accounts,accountOwner));	
				}else {
					System.out.println("Input password: ");
					password=input.nextLine();
					
					if(!accountManager.doesPasswordExist(accounts,password)) {
						do {
							System.out.println("Wrong password! Input again!");
							password=input.nextLine();
						} while(accountManager.doesPasswordExist(accounts,password));
							
					}
				}
				
				loggedIn=true;
			} else {
				
				System.out.println("Wrong input!");
			}
				
		} while (!loggedIn);
		
		

		if (loggedIn) {
			do {

				System.out.println("................................");
				System.out.println("1 --> create new task");
				System.out.println("2 --> mark finished task");
				System.out.println("3 --> delete a task");
				System.out.println("4 --> unfinished tasks");
				System.out.println("5 --> finished tasks");
				System.out.println("................................");

				choice = input.nextInt();

				if (choice == 1) {

					String task;
					
					taskOwner=accountOwner;

					Todo.input.nextLine();
					Date date = new Date();
					System.out.println("Input new task:");
					task = Todo.input.nextLine();

					taskManager.createTask(tasks,taskOwner, date, task);

				} else if (choice == 2) {

					String task;
					
					taskOwner=accountOwner;

					input.nextLine();
					System.out.println("Input the task you want to mark: ");
					task = input.nextLine();

					if (!taskManager.doesTaskExist(tasks,taskOwner, task)) {
						System.out.println("Task does not exist!");
					} else {
						taskManager.markFinishedTask(tasks, finishedTasks,taskOwner, task);
					}

					System.out.println("Task is marked!");

				} else if (choice == 3) {

					String task;
					
					taskOwner=accountOwner;

					input.nextLine();
					System.out.println("Input the task you want to delete: ");
					task = input.nextLine();

					if (!taskManager.doesTaskExist(tasks,taskOwner, task)) {
						System.out.println("Task does not exist!");
					} else {
						taskManager.deleteTask(tasks, taskOwner, task);
					}

					System.out.println("Task is deleted!");

				} else if (choice == 4) { 
					
					taskOwner=accountOwner;

					taskManager.displayTasks(tasks, taskOwner);

				} else if (choice == 5) {
					
					taskOwner=accountOwner; 

					taskManager.displayFinishedTasks(finishedTasks, taskOwner);

				} else {

					System.out.println("Wrong input!");

				}

			} while (true);
		}

	}

}
