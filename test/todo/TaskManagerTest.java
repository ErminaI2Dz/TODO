package todo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TaskManagerTest {

	ArrayList<Task> tasks;
	ArrayList<Task> finishedTasks;
	TaskManager taskManager;
	Date date;

	@Before
	public void setUp() {

		tasks = new ArrayList<>();
		finishedTasks = new ArrayList<>();

		taskManager = new TaskManager();

		date = new Date();
		
		taskManager.createTask( tasks, "Ermina", date, "First task");
		
		taskManager.createTask( tasks, "Ermina", date, "Second task");
	} 

	@Test
	public void testCreateTask() {	

		assertEquals(2, tasks.size());  
	} 

	@Test
	public void testDoesTaskExistIfItExist() {
		
		assertTrue(taskManager.doesTaskExist(tasks, "Ermina", "First task")); 
	}
	
	@Test
	public void testDoesTaskExistIfItNoExist() {
		
		assertFalse(taskManager.doesTaskExist(tasks, "Ermina", "Task"));
	}
	
	@Test
	public void testDoesTaskExistIfOwnerNotExist() {
		
		assertFalse(taskManager.doesTaskExist(tasks, "Jasmina", "task"));
	}

	@Test
	public void testMarkFinishedTaskIfItExist() {
		
		taskManager.markFinishedTask( tasks, finishedTasks, "Ermina", "First task");
		
		assertEquals(1, finishedTasks.size());
		
	}
	
	
	@Test
	public void testMarkFinishedTaskIfItNoExist() {
		
		taskManager.markFinishedTask( tasks, finishedTasks, "Ermina", "Task");
		
		assertEquals(0, finishedTasks.size());
		
	}
	
	@Test
	public void testMarkFinishedTaskIfOwnerNotExist() {
		
		taskManager.markFinishedTask( tasks, finishedTasks, "Jasmina", "Task");
		
		assertEquals(0, finishedTasks.size());
		
	}

	@Test
	public void testDisplayFinishedTasks() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteTaskIfItExist() {
		
		taskManager.deleteTask( tasks, "Ermina", "First task");
		
		assertFalse(taskManager.doesTaskExist(tasks, "Ermina", "First task"));
	}
	
	@Test
	public void testDeleteTaskIfItNoExist() {
		
		taskManager.deleteTask( tasks, "Ermina", "Task");
		
		assertFalse(taskManager.doesTaskExist(tasks, "Ermina", "Task"));
	}
	
	@Test
	public void testDeleteTaskIfItOvnerNotExist() {
		
		taskManager.deleteTask( tasks, "Jasmina", "Task");
		
		assertFalse(taskManager.doesTaskExist(tasks, "Jasmina", "Task"));
	}

}
