package todo;

import java.util.ArrayList;

public class AccountManager { 

	/*
	 * This method creates an account
	 */
	public void createAccount(ArrayList<Account> accounts, String accountOwner, String password) {

		Account newAccount = new Account(accountOwner, password);

		accounts.add(newAccount);
	}

	/*
	 * This method check does exists owner's name
	 */
	public boolean doesNameExist(ArrayList<Account> accounts, String accountOwner) {

		boolean nameExist = false;

		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getName().equals(accountOwner)) {
				nameExist = true;
				break;
			}
		}

		return nameExist;
	}

	/*
	 * This method check does exists owner's name
	 */
	public boolean doesPasswordExist(ArrayList<Account> accounts, String password) {

		boolean passwordExist = false;

		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getPassword().equals(password)) {
				passwordExist = true;
				break;
			}
		}

		return passwordExist;
	}
}
