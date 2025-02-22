package trainservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;


import java.sql.Date;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ticket{

    private String ticketId;

    private String userId;

    private String source;

    private String destination;

    private String dateOfTravel;

    private train train;

    public ticket(){}

    public ticket(String ticketId, String userId, String source, String destination, String dateOfTravel, train train){
        this.ticketId = ticketId;
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.dateOfTravel = dateOfTravel;
        this.train = train;
    }

    public String getTicketInfo(){
        return String.format("Ticket ID: %s belongs to User %s from %s to %s on %s", ticketId, userId, source, destination, dateOfTravel);
    }

}