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
    private List<String>  stationList;
}
