package trainservice.entities;

import java.util.List;

public class user {
    private String username;
    private String password;
    private String hashedPassword;
    private List<ticket> ticketList;
    private String userID;

    // Default constructor
    public user() {
    }

    // Constructor with all fields
    public user(String username, String password, String hashedPassword, List<ticket> ticketList, String userID) {
        this.username = username;
        this.password = password;
        this.hashedPassword = hashedPassword;
        this.ticketList = ticketList;
        this.userID = userID;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public List<ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
