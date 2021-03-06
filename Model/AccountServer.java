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

    //Returns singleton instance of account server and updates users array
    static public AccountServer getInstance() {
    	if(instance == null) 
            instance = new AccountServer(); 

        Database db = new Database();
        db.initializeConnection();
        users = db.getUserList();
        return instance; 
    }

    //Adds ONLY unique users to the array
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

    //Validates a username and password in the database
    public User validate(String username, String password) {
        System.out.println("Checking username: " + username);
        System.out.println("Checking password: " + password);
        
        for (User temp : users) {
            System.out.println(temp.getEmail());
        }

    	for(int i = 0; i < users.size(); i++) 
            if(users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)){
                for (User temp : users) {
                    System.out.println(temp.getEmail());
                    System.out.println(temp.getUsername());
                    System.out.println(temp.getPassword());
                    System.out.println();
                }
                return users.get(i); 
            }
            	
        return null;
    }

    //Checks if an email used in registration does not previously exist in the database
    public boolean registrationEmailUnique (String email) {
        for(int i = 0; i < users.size(); i++) 
        if(users.get(i).getEmail().equals(email) == true)
            return false; 
        return true;
    }

     //Checks if an username used in registration does not previously exist in the database
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
