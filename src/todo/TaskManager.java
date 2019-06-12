package todo;

import java.util.ArrayList;
import java.util.Date;

public class TaskManager {

	/*
	 * Method validates data and creates an account
	 */
	public void createTask(ArrayList<Task> tasks, String taskOwner, Date date, String task) {

		Task newTask = new Task(taskOwner, date, task);

		tasks.add(newTask);
	}

	/*
	 * Method displays tasks
	 */
	public void displayTasks(ArrayList<Task> tasks, String taskOwner) {
		

		if (tasks.size() == 0) {

			System.out.println("There are no tasks!");
		}

		for (int i = 0; i < tasks.size(); i++) {

			if (tasks.get(i).getTaskOwner().equals(taskOwner)) {
				System.out.println(" * " + tasks.get(i).getDate() + " " + tasks.get(i).getTask());
			}
		}

		

	}

	/*
	 * Method checks if the task exists
	 */
	public boolean doesTaskExist(ArrayList<Task> tasks, String taskOwner, String task) {

		boolean existTask = false;

		for (int i = 0; i < tasks.size(); i++) {

			if (tasks.get(i).getTaskOwner().equals(taskOwner)) {

				if (tasks.get(i).getTask().equals(task)) {
					existTask = true;
					break;
				}
			}
		} 

			return existTask;
	}

	/*
	 * Method marks finished tasks
	 */
	public void markFinishedTask(ArrayList<Task> tasks, ArrayList<Task> finishedTasks, String taskOwner, String task) {

		for (int i = 0; i < tasks.size(); i++) {

			if (tasks.get(i).getTaskOwner().equals(taskOwner)) {

				if (tasks.get(i).getTask().equals(task)) {

					tasks.get(i).setCompleted(true);

					Date date = new Date();
					Task newTask = new Task(taskOwner, date, tasks.get(i).getTask());
					finishedTasks.add(newTask);

					tasks.remove(i);
				}
			} 
		}
	}

	/*
	 * Method displays finished tasks
	 */
	public void displayFinishedTasks(ArrayList<Task> finishedTasks, String taskOwner) {

		for (int i = 0; i < finishedTasks.size(); i++) {

			if (finishedTasks.get(i).getTaskOwner().equals(taskOwner)) {

				System.out.println(" * " + finishedTasks.get(i).getDate() + "  " + finishedTasks.get(i).getTask());
			}
		}

		if (finishedTasks.size() == 0) {

			System.out.println("There are no finished tasks!");
		}
	}

	/*
	 * Method deletes a task
	 */
	public void deleteTask(ArrayList<Task> tasks, String taskOwner, String task) {

		for (int i = 0; i < tasks.size(); i++) {

			if (tasks.get(i).getTaskOwner().equals(taskOwner)) {

				if (tasks.get(i).getTask().equals(task)) {

					tasks.remove(i);

				}
			}
		}
	}
}
