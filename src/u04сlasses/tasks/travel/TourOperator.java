package u04сlasses.tasks.travel;

import java.util.ArrayList;
import java.util.Comparator;

public class TourOperator {

    private String nameOfTourOperator;
    private ArrayList<TourPackage> tourPackages;
    private ArrayList<Traveler> travelers;

    public TourOperator(String nameOfTourOperator) {
        this.nameOfTourOperator = nameOfTourOperator;
        this.tourPackages = new ArrayList<>();
        this.travelers = new ArrayList<>();
    }

    public void addTourPackage(TourPackage tour) {
        tourPackages.add(tour);
    }

    public void addClient(Traveler traveler, TourPackage tour) {
        traveler.setTourPackage(tour);
        travelers.add(traveler);
    }

    public String getNameOfTourOperator() {
        return nameOfTourOperator;
    }

    public void setNameOfTourOperator(String nameOfTourOperator) {
        this.nameOfTourOperator = nameOfTourOperator;
    }

    public ArrayList<TourPackage> getTourPackages() {
        return tourPackages;
    }

    public void setTourPackages(ArrayList<TourPackage> tourPackages) {
        this.tourPackages = tourPackages;
    }

    public ArrayList<Traveler> getClients() {
        return travelers;
    }

    public void setClients(ArrayList<Traveler> travelers) {
        this.travelers = travelers;
    }

    public static void printTours(ArrayList<TourPackage> packages) {
        if (packages.size() == 0) {
            System.out.println("not found");
            return;
        }
        for (TourPackage tour : packages) {
            System.out.printf("=| %10s - %-10s |=\ntype:\t\t%s\ntransfer:\t%s\n" +
                            "food:\t\t%s\ndays:\t\t%d\nprice:\t\t%.2f $.\n",
                    tour.getCountry(), tour.getCity(), tour.getType(), tour.getTransport(),
                    tour.getFood(), tour.getNumberOfDays(), tour.getPrice());
            System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        }
    }

    public static void sortByPrice(ArrayList<TourPackage> tour) {
        tour.sort(Comparator.comparing(TourPackage::getPrice));
    }

    public static void sortByNumberOfDays(ArrayList<TourPackage> tour) {
        tour.sort(Comparator.comparing(TourPackage::getNumberOfDays));
    }

    public ArrayList<TourPackage> selectByTourPackageType(TourPackageType type) {
        ArrayList<TourPackage> packages = new ArrayList<>();
        for (TourPackage tour : tourPackages) {
            if (tour.getType().equals(type)) {
                packages.add(tour);
            }
        }
        return packages;
    }

    public ArrayList<TourPackage> selectByMoreOption(Transport transport) {
        ArrayList<TourPackage> packages = new ArrayList<>();
        for (TourPackage tour : tourPackages) {
            if (tour.getTransport().equals(transport)) {
                packages.add(tour);
            }
        }
        return packages;
    }

    public ArrayList<TourPackage> selectByMoreOption(Transport transport, TypeOfFood food) {
        ArrayList<TourPackage> packages = new ArrayList<>();
        for (TourPackage tour : tourPackages) {
            if (tour.getTransport().equals(transport) &&
                    tour.getFood().equals(food)) {
                packages.add(tour);
            }
        }
        return packages;
    }

    public ArrayList<TourPackage> selectByMoreOption(Transport transport, TypeOfFood food, int days) {
        ArrayList<TourPackage> packages = new ArrayList<>();
        for (TourPackage tour : tourPackages) {
            if (tour.getTransport().equals(transport) &&
                    tour.getFood().equals(food) &&
                    tour.getNumberOfDays() == days) {
                packages.add(tour);
            }
        }
        return packages;
    }

    public ArrayList<TourPackage> selectByMoreOption(int days) {
        ArrayList<TourPackage> packages = new ArrayList<>();
        for (TourPackage tour : tourPackages) {
            if (tour.getNumberOfDays() == days) {
                packages.add(tour);
            }
        }
        return packages;
    }

    public ArrayList<TourPackage> selectTour(int index) {
        ArrayList<TourPackage> packages = new ArrayList<>();
        int i = 0;
        for (TourPackage tour : tourPackages) {
            if (i == index) {
                packages.add(tour);
            }
            i++;
        }
        return packages;
    }
}
