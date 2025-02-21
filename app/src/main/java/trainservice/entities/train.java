package trainservice.entities;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class train {
    private String trainID;
    private String trainName;
    private String trainType;
    private String trainNumber;
    private List<List<Integer>> seats;
    private Map<String, Date> stationTime;
    private List<String> stationList;

    // Constructor
    public train(String trainID, String trainName, String trainType, String trainNumber,
                 List<List<Integer>> seats, Map<String, Date> stationTime, List<String> stationList) {
        this.trainID = trainID;
        this.trainName = trainName;
        this.trainType = trainType;
        this.trainNumber = trainNumber;
        this.seats = seats;
        this.stationTime = stationTime;
        this.stationList = stationList;
    }

    // Getters
    public String getTrainID() {
        return trainID;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getTrainType() {
        return trainType;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public List<List<Integer>> getSeats() {
        return seats;
    }

    public Map<String, Date> getStationTime() {
        return stationTime;
    }

    public List<String> getStationList() {
        return stationList;
    }

    // Setters
    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }

    public void setStationTime(Map<String, Date> stationTime) {
        this.stationTime = stationTime;
    }

    public void setStationList(List<String> stationList) {
        this.stationList = stationList;
    }
}
