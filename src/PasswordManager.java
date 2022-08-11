import java.util.*;
import java.io.*;

class PasswordManager implements Serializable{
    private String userName = "testUsername";
    private String password = "testPassword";
    public boolean signedIn = false;
    HashMap<String, Password> passwords;
    
    public PasswordManager() {
    	passwords = new HashMap<String, Password>();
    }

    public boolean signIn(String userName, String password) {
        if (this.userName.equals(userName) && this.password.equals(password)) {
            this.signedIn = true;
            return true;
        }
        return false;
    }
    public void signOut() {
        this.signedIn = false;
    }
    public String getPasswordManagerUsername() {
        return this.userName;
    }
    public String getPasswordManagerPassword() {
        return this.password;
    }
    public void updatePasswordKeeper(String newUsername,String newPassword) {
        this.userName = newUsername;
        this.password = newPassword;
        System.out.println("Successfully updated PasswordManager information!");

    }
    public void addNewPassword(Password passwordData) {
       passwords.put(passwordData.getTitle(), passwordData);
        System.out.println("Successfully added " + passwordData.getTitle() + " to PasswordManager");
    }

    public void updatePassword(String title, String newUsername, String newPassword) {
        Password passwordToUpdate = passwords.get(title);
        passwordToUpdate.updatePassword(newPassword);
        System.out.println("Successfully updated " + title + "'s password in PasswordManager!");
    }

    public void deletePassword(String title) {
    	passwords.remove(title);
        System.out.println("Successfully removed " + title + " from PasswordManager");
    }

    public String getPassword(String title) {
        Password passwordData = passwords.get(title);
        return passwordData.getPassword();
    }

    public Password getPasswordData(String title) {
        return passwords.get(title);
        
    }
}