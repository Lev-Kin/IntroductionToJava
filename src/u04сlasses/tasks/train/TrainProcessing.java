package u04сlasses.tasks.train;

import java.util.Arrays;
import java.util.Comparator;

public class TrainProcessing {

    public Train[] initializationTrain() {
        Train[] trains = new Train[]{
                new Train("Минск", "302С", "13:00:00 21/09/2021"),
                new Train("Минск", "691Б", "00:15:00 21/09/2021"),
                new Train("Брест", "675Ф", "08:15:00 26/09/2021"),
                new Train("Гродно", "631Б", "14:17:00 22/09/2021"),
                new Train("Гродно", "609Б", "16:56:00 22/09/2021")
        };

        return trains;
    }

    public void print(Train[] trains) {
        System.out.println("Пункт назначения | N поезда | Время отправления");
        for (Train train : trains) {
            System.out.println(train);
        }
    }

    public void sortByTrainNumber(Train[] trains) {
        Train temp;
        for (int i = 0; i < trains.length; i++) {
            for (int j = trains.length - 1; j > i; j--) {
                if (trains[i].getTrainNumber().compareTo(trains[j].getTrainNumber()) > 0) {
                    temp = trains[i];
                    trains[i] = trains[j];
                    trains[j] = temp;
                }
            }
        }
    }

    public int cheackTrainNumber(String trainNumber, Train[] trains) {

        int index = 0;
        for (Train train : trains) {

            if (train.getTrainNumber().equalsIgnoreCase(trainNumber)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    public void getInfoByTrainNumber(Train train) {
        System.out.println("Пункт назначения | N поезда | Время отправления");
        System.out.println(String.format("%-16s", train.getDestination()) + " | "
                + String.format("%8s", train.getTrainNumber()) + " | "
                + train.getDepartureTime().toString());
    }

    public void sortByDestinationName(Train[] trains) {
        Arrays.sort(trains, Comparator.comparing(Train::getDestination).thenComparing(Train::getDepartureTime));
    }
}