package todo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AccountManagerTest {
	
	ArrayList<Account> accounts;
	AccountManager accountManager;

	@Before
	public void setUp() {
		
		accounts= new ArrayList<>();
		
		accountManager = new AccountManager();
		
		accountManager.createAccount(accounts, "Ermina", "123456");
		
	}

	@Test
	public void testCreateAccount() {
		
		assertEquals(1,accounts.size());  
	}

	@Test
	public void testDoesNameExistIfItExist() {
		
		assertTrue(accountManager.doesNameExist( accounts, "Ermina"));
	}
	
	@Test
	public void testDoesNameExistIfItNoExist() {
		
		assertFalse(accountManager.doesNameExist( accounts, "Jasmina"));  
	} 

	@Test
	public void testDoesPasswordExistIfItExist() {
		
		assertTrue(accountManager.doesPasswordExist( accounts,"123456"));
	}
	
	@Test
	public void testDoesPasswordExistIfItNoExist() {
		
		assertFalse(accountManager.doesPasswordExist( accounts,"456789"));
	}

}
