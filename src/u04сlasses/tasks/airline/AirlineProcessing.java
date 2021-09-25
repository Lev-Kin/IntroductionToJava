package u04сlasses.tasks.airline;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;

public class AirlineProcessing {

    private ArrayList<Airline> airlines;

    public AirlineProcessing(ArrayList<Airline> airlines) {
        this.airlines = airlines;
    }

    public ArrayList<Airline> getAirlines() {
        return airlines;
    }

    public void addAirline(String destination, String flightNumber, String planeType,
                           Date departureTime, DayOfWeek[] dayOfWeek) {
        airlines.add(new Airline(destination, flightNumber, planeType, departureTime, dayOfWeek));
    }

    public void print(ArrayList<Airline> airlinesList) {
        for (Airline airline : airlinesList) {
            System.out.println(airline);
        }
    }

    public ArrayList planeFlightByDestination(String destination) {
        ArrayList<Airline> destinationList = new ArrayList<>();

        for (Airline airline : this.airlines) {
            if (airline.getDestination().equalsIgnoreCase(destination)) {
                destinationList.add(airline);
            }
        }
        return destinationList;
    }

    public ArrayList planeFlightByDay(DayOfWeek dayOfWeek) {
        ArrayList<Airline> dayList = new ArrayList<>();

        for (Airline airline : this.airlines) {
            for (DayOfWeek day : airline.getDayOfWeek()) {
                if (day == dayOfWeek) {
                    dayList.add(airline);
                    break;
                }
            }
        }
        return dayList;
    }

    public ArrayList planeFlightByDayAndTime(DayOfWeek dayOfWeek, Date searchTime) {
        ArrayList<Airline> dayAndTimeList = new ArrayList<>();

        for (Airline airline : this.airlines) {
            for (DayOfWeek day : airline.getDayOfWeek()) {
                if (day == dayOfWeek) {
                    if (airline.getDepartureTime().compareTo(searchTime) > 0)
                        dayAndTimeList.add(airline);
                    break;
                }
            }
        }
        return dayAndTimeList;
    }
}