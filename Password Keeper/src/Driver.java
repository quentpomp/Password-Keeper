import java.util.*;

public class Driver {
    public static void main(String[] args) {
    	LoginGUI loginGui = new LoginGUI();
        loginGui.show();

//        while (passwordManager.signedIn) {
//            System.out.println();
//            System.out.println(passwordManager.getPasswordManagerUsername() + "'s PasswordManager");
//            System.out.println("Choose one of the following actions: ");
//            System.out.println();
//            System.out.println("(1) Add a new password");
//            System.out.println("(2) Search for a password");
//            System.out.println("(3) Update a password");
//            System.out.println("(4) Delete a password");
//            System.out.println("(5) Update PasswordManager username");
//            System.out.println("(6) Update PasswordManager password");
//            System.out.println("(7) Sign out");
//            System.out.print("Enter choice: ");
//            
//            int choice = Integer.parseInt(in.nextLine());
//            switch (choice) {
//                case 1:
//                    System.out.println();
//                    System.out.print("Enter title (press ENTER when finished): ");
//                    String passwordTitle = in.nextLine();
//                    System.out.print("Enter username (press ENTER when finished): ");
//                    String passwordUserName = in.nextLine();
//                    System.out.print("Enter password (press ENTER when finished): ");
//                    String passwordPassword = in.nextLine();
//                    System.out.print("Enter any notes (press ENTER when finished): ");
//                    String passwordNotes = in.nextLine();
//                    Password newPassword = new Password(passwordTitle, passwordUserName, passwordPassword, passwordNotes);
//                    passwordManager.addNewPassword(newPassword);
//                    break;
//                case 2:
//                    System.out.println();
//                    System.out.print("Enter title (press ENTER when finished): ");
//                    String searchTitle = in.nextLine();
//                    String searchDisplay = passwordManager.getPasswordData(searchTitle).showInfo();
//                    System.out.println();
//                    System.out.println(searchDisplay);
//                    break;
//                case 3:
//                    System.out.println();
//                    System.out.print("Enter title of password to update (press ENTER when finished): ");
//                    String updateTitle = in.nextLine();
//                    System.out.print("Enter new password (press ENTER when finished): ");
//                    String updateNewPassword = in.nextLine();
//                    passwordManager.updatePassword(updateTitle, updateNewPassword);
//                    break;
//                case 4: 
//                    System.out.println();
//                    System.out.print("Enter title of password to delete (press ENTER when finished): ");
//                    String deleteTitle = in.nextLine();
//                    passwordManager.deletePassword(deleteTitle);
//                    break;
//                case 5:
//                    System.out.println();
//                    System.out.print("Enter your new username for PasswordManager: ");
//                    String passwordManagerUsername = in.nextLine();
//                    passwordManager.updatePasswordKeeperUsername(passwordManagerUsername);
//                    break;
//                case 6: 
//                    System.out.println();
//                    System.out.print("Enter your new username for PasswordManager: ");
//                    String passwordManagerPassword = in.nextLine();
//                    passwordManager.updatePasswordKeeperPassword(passwordManagerPassword);
//                    break;
//                case 7:
//                    System.out.println();
//                    passwordManager.signOut();
//                    break;
//            }
//        }
//        System.out.println("Thanks for using PasswordManager!");
//        in.close();
    }


}
