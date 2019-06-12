package todo;
import java.util.Date;

public class Task {

	String taskOwner;
	Date date;
	String task;
	boolean completed;

	public Task() {

	}

    public Task(String taskOwner, Date date, String task) {

		this.taskOwner=taskOwner;
		this.date=date;
		this.task=task;
		completed=false;
	} 

	public String getTask() {
		return task;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTaskOwner() {
		return taskOwner;
	}

	public void setTaskOwner(String taskOwner) {
		this.taskOwner = taskOwner;
	}
	
	

}
