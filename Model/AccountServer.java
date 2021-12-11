/*
 * This was an exact copy of Moshirpour's Lab 6 solutions
 * change it if incorrect!
 */
package Model;

import java.util.ArrayList;

import Controller.Database;

public class AccountServer {
    static ArrayList<User> users;
    static AccountServer instance;
    //private DBInterfaceController loginController; removed

    static public AccountServer getInstance() {
    	if(instance == null) 
            instance = new AccountServer(); 

        Database db = new Database();
        db.initializeConnection();
        users = db.getUserList();
        return instance; 
    }

    public void add(String username, String password, String name, String email, String accountType) {
    	User x = new User(username, password, name, email, accountType);
    	int found = 0;
    	for(int i = 0; i < users.size(); i++) 
            if(users.get(i).getName().equals(username) == true ){ 
                found = 1; 
                System.out.println("Sorry this user already exists."); 
            } 
        if(found == 0) 
        	users.add(x); 
    }

    public User validate(String username, String password) {
    	for(int i = 0; i < users.size(); i++) 
            if(users.get(i).getName().equals(username) && users.get(i).getPassword().equals(password))
            	return users.get(i); 
        return null;
    }

    public boolean registrationEmailUnique (String email) {
        for(int i = 0; i < users.size(); i++) 
        if(users.get(i).getEmail().equals(email) == true)
            return false; 
        return true;
    }

    public boolean registrationUsernameUnique (String username) {
        for(int i = 0; i < users.size(); i++) 
        if(users.get(i).getUsername().equals(username) == true)
            return false; 
        return true;
    } 

    public ArrayList<User> getUsers(){
        return users;
    }
}
