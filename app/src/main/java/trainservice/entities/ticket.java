package trainservice.entities;

import java.util.Date;

public class ticket {
    private String ticketId;
    private String userID;
    private String source;
    private String destination;
    private Date dateArrival;
    private train train;  // Fixed the variable name from `ticket` to `train`

    // Constructor
    public ticket(String ticketId, String userID, String source, String destination, Date dateArrival, train train) {
        this.ticketId = ticketId;
        this.userID = userID;
        this.source = source;
        this.destination = destination;
        this.dateArrival = dateArrival;
        this.train = train;
    }

    // Getters
    public String getTicketId() {
        return ticketId;
    }

    public String getUserID() {
        return userID;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDateArrival() {
        return dateArrival;
    }

    public train getTrain() {
        return train;
    }

    // Setters
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDateArrival(Date dateArrival) {
        this.dateArrival = dateArrival;
    }

    public void setTrain(train train) {
        this.train = train;
    }
}
