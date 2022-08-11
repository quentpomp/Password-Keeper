import java.io.*;
public class Password implements Serializable {
    public String title;

    private String userName;
    private String password;
    private String notes;

    public Password(String title, String userName, String password, String notes) {
        this.title = title;
        this.userName = userName;
        this.password = password;
        this.notes = notes;
    }

    public String showInfo() {
        String info = "PASSWORD INFORMATION\n";
        info += title + "\n";
        info += "Username: " + this.userName + "\n";
        info += "Password: " + this.password + "\n";
        info += "Notes: " + this.notes + "\n";
        return info;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updateUsername(String userName) {
        this.userName = userName;
    }

    public void updateNotes(String notes) {
        this.notes = notes;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getNotes() {
        return this.notes;
    }
}
