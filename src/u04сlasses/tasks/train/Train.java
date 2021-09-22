package u04сlasses.tasks.train;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Train {

    private String destination;
    private String trainNumber;
    private Date departureTime;

    public Train(String destination, String trainNumber, String departureTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;

        try {
            this.departureTime = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy").parse(departureTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return (String.format("%-16s", this.getDestination()) + " | "
                + String.format("%8s", this.getTrainNumber()) + " | "
                + this.getDepartureTime().toString());
    }
}