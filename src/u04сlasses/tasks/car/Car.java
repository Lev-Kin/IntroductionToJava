package u04сlasses.tasks.car;

import java.util.ArrayList;

public class Car {
    private String nameCar;
    private Engine engine;
    private ArrayList<Wheel> wheels;
    private boolean isFuel;

    public Car(String nameCar) {
        this.nameCar = nameCar;
        this.engine = engine;
        this.wheels = new ArrayList<>();
        this.isFuel = true;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public ArrayList<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(ArrayList<Wheel> wheels) {
        this.wheels = wheels;
    }

    public void addWeels(int wheelDiameter) {
        this.wheels.add(new Wheel(wheelDiameter));
    }

    public boolean isFuel() {
        return isFuel;
    }

    public void setFuel(boolean fuel) {
        this.isFuel = fuel;
    }

    public boolean checkEngine() {

        if (engine == null) {
            System.out.println("Двигатель не установлен. Надо поставить двигатель.");
            return false;
        }

        return true;
    }

    public boolean checkWeels() {

        int wheelCounter = 0;
        for (Wheel wheel : wheels) {
            if (wheel != null) {
                wheelCounter++;
            }
        }

        if (wheelCounter == 0) {
            System.out.println("Колеса не установлены. Необходимо 4 колеса.");
            return false;
        } else if (wheelCounter == 1) {
            System.out.println("Колесо только одно. Необходимо 3 колеса.");
            return false;
        } else if (wheelCounter == 2) {
            System.out.println("Только 2 колесa. Необходимо еще 2 колесa.");
            return false;
        } else if (wheelCounter == 3) {
            System.out.println("Только 3 колесa. Необходимо еще 1 колесо.");
            return false;
        }

        return true;
    }

    public void drive() {

        int count = 0;
        if (checkEngine() && checkWeels()) {
            boolean ready = true;
            for (int i = 0; i < 4; i++) {
                if (!wheels.get(i).isGood()) {
                    System.out.printf("Колесо %d пробито. Замените колесо.\n", i + 1);
                    ready = false;
                }
            }

            if (!isFuel) {
                System.out.println("Закончилось топливо. Надо заправиться.");
            } else if (ready) {
                System.out.println("Машина находится в движении.");
            }

        }
    }

    public void refuel() {
        this.isFuel = true;
        System.out.println("Автомобиль заправлен.");
    }

    public void changeWheel() {
        for (int i = 0; i < 4; i++) {
            if (!wheels.get(i).isGood()) {
                System.out.printf("Колесо %d заменено.\n", i + 1);
                int wheelDiameter = this.getWheels().get(i).getDiameter();
                this.getWheels().set(i, new Wheel(wheelDiameter));
            }
        }
    }

}