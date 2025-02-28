package trainservice.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import trainservice.entities.train;
import trainservice.entities.user;
import trainservice.entities.train;
import trainservice.util.userserviceutil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserBookingService {

    private ObjectMapper objectMapper = new ObjectMapper();

    private static List<user> userList;
    private static user user;
    private static final String USER_FILE_PATH = "app/src/main/java/ticket/booking/localDb/users.json";

    public UserBookingService(user user) throws IOException {
        this.user = user;
        loadUserListFromFile();
    }

    public UserBookingService() throws IOException {
        loadUserListFromFile();
    }

    private void loadUserListFromFile() throws IOException {
        userList = objectMapper.readValue(new File(USER_FILE_PATH), new TypeReference<List<user>>() {});
    }

    public Boolean loginUser() {
        Optional<user> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) &&
                    userserviceutil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }

    public Boolean signUp(user user1) {
        try {
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        } catch (IOException ex) {
            ex.printStackTrace(); // Log the exception
            return Boolean.FALSE;
        }
    }

    private void saveUserListToFile() throws IOException {
        File usersFile = new File(USER_FILE_PATH);
        objectMapper.writeValue(usersFile, userList);
    }

    public static void fetchBookings() {
        Optional<user> userFetched = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) &&
                    userserviceutil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        userFetched.ifPresent(user::printTickets);
    }

    public Boolean cancelBooking(String ticketId) {
        if (ticketId == null || ticketId.isEmpty()) {
            System.out.println("Ticket ID cannot be null or empty.");
            return Boolean.FALSE;
        }

        boolean removed = user.getTicketsBooked().removeIf(ticket -> ticket.getTicketId().equals(ticketId));

        if (removed) {
            System.out.println("Ticket with ID " + ticketId + " has been canceled.");
            return Boolean.TRUE;
        } else {
            System.out.println("No ticket found with ID " + ticketId);
            return Boolean.FALSE;
        }
    }

    public List<train> getTrains(String source, String destination) {
        try {
            TrainService trainService = new TrainService();
            return trainService.searchTrains(source, destination);
        } catch (IOException ex) {
            ex.printStackTrace(); // Log the exception
            return new ArrayList<>();
        }
    }

    public List<List<Integer>> fetchSeats(train train) {
        return train.getSeats();
    }

    public Boolean bookTrainSeat(train train, int row, int seat) {
        try {
            TrainService trainService = new TrainService();
            List<List<Integer>> seats = train.getSeats();
            if (row >= 0 && row < seats.size() && seat >= 0 && seat < seats.get(row).size()) {
                if (seats.get(row).get(seat) == 0) {
                    seats.get(row).set(seat, 1);
                    train.setSeats(seats);
                    trainService.addTrain(train);
                    return Boolean.TRUE; // Booking successful
                } else {
                    return Boolean.FALSE; // Seat is already booked
                }
            } else {
                return Boolean.FALSE; // Invalid row or seat index
            }
        } catch (IOException ex) {
            ex.printStackTrace(); // Log the exception
            return Boolean.FALSE;
        }
    }
}
