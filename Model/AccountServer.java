/*
 * This was an exact copy of Moshirpour's Lab 6 solutions
 * change it if incorrect!
 */
package Model;

import java.util.Vector;

public class AccountServer {
    Vector<User> users;
    static AccountServer instance;
    private DBInterfaceController loginController;

    static public AccountServer getInstance() {
    	if(instance == null) 
            instance = new AccountServer(); 
         
        return instance; 
    }

    public void add(String username, String password) {
    	User x = {username, password};
    	int found = 0;
    	for(int i = 0; i < users.size(); i++) 
            if(users.get(i).name.equals(username) == true ){ 
                found = 1; 
                System.out.println("Sorry this user already exists."); 
            } 
        if(!found) 
        	users.add(x); 
    }

    public User validate(String username, String password) {
    	for(int i = 0; i < users.size(); i++) 
            if(users.get(i).name.equals(username) == true && users.get(i).password.equals(password) == true)
            	return users.get(i); 
        return null;
    }
}
