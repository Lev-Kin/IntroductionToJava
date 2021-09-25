package u04сlasses.tasks.airline;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Date;

public class Airline {

    private String destination;
    private String flightNumber;
    private String planeType;
    private Date departureTime;
    private DayOfWeek[] dayOfWeek;

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

    public Airline(String destination, String flightNumber, String planeType,
                   Date departureTime, DayOfWeek[] dayOfWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.planeType = planeType;
        this.departureTime = departureTime;
        this.dayOfWeek = dayOfWeek;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public DayOfWeek[] getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek[] dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (DayOfWeek day : dayOfWeek) {

            if (count == 3) {
                stringBuilder.append("\n\t\t\t\t");
                count = 0;
            }

            stringBuilder.append(day);
            stringBuilder.append(", ");

            count++;
        }

        return ".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   ." +
                "\n---| Пункт назначения " + String.format("%20s", destination) + "\t\t\t|---\n" +
                "Номер рейса:\t" + flightNumber + '\n' +
                "Тип самолета:\t" + planeType + '\n' +
                "Время вылета:\t" + simpleDateFormat.format(departureTime) + '\n' +
                "Дни недели:\t\t" + stringBuilder.toString() + "\b\b";
    }
}