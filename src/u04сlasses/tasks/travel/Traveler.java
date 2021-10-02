package u04сlasses.tasks.travel;

public class Traveler {
    private String name;
    private String surname;
    private TourPackage tourPackage;
    private double payment;

    public Traveler(String name, String surname, double payment) {
        this.name = name;
        this.surname = surname;
        this.payment = payment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public TourPackage getTourPackage() {
        return tourPackage;
    }

    public void setTourPackage(TourPackage tourPackage) {
        this.tourPackage = tourPackage;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Traveler{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", tourPackage=" + tourPackage +
                ", payment=" + payment +
                '}';
    }
}
