package u04сlasses.tasks;

import u04сlasses.tasks.bank.Account;
import u04сlasses.tasks.bank.Bank;
import u04сlasses.tasks.bank.Client;
import u04сlasses.tasks.car.Car;
import u04сlasses.tasks.car.Engine;
import u04сlasses.tasks.car.Wheel;
import u04сlasses.tasks.state.City;
import u04сlasses.tasks.state.District;
import u04сlasses.tasks.state.Region;
import u04сlasses.tasks.state.State;
import u04сlasses.tasks.text.Sentence;
import u04сlasses.tasks.text.Text;
import u04сlasses.tasks.text.Word;
import u04сlasses.tasks.travel.*;

import java.util.ArrayList;

public class AggregationAndComposition {
    public static void Tasks() {
        System.out.println("\t\t=== Агрегация и композиция ===\n");
        task01();
        task02();
        task03();
        task04();
        task05();
    }

    private static void task01() {
        System.out.println("1. Создать объект класса Текст, используя классы Предложение,\n" +
                "Слово. Методы: дополнить текст, вывести на консоль текст,\n" +
                "заголовок текста.");
        System.out.println("-------------------------------------------------------------");

        Word title = new Word("\t\t\t\tTitle title");
        String str1 = "[str1] Word is one of the main structural units of language,\n" +
                "which serves for the names of objects, their qualities and\n" +
                "characteristics, their interactions, as well as the\n" +
                "naming of imaginary and abstract concepts created by\n" +
                "the human imagination.";

        String str2 = "[str2] Предложе́ние (в языке) — это единица языка, которая\n" +
                "представляет собой грамматически организованное соединение\n" +
                "слов (или слово), обладающее смысловой и интонационной\n" +
                "законченностью.";

        String str3 = "[str3] Текст (от лат. textus — ткань; сплетение, сочетание) —\n" +
                "зафиксированная на каком-либо материальном носителе\n" +
                "человеческая мысль; в общем плане связная и полная\n" +
                "последовательность символов.";

        Sentence sentence = new Sentence(str1);
        Text text = new Text(title, sentence);
        text.addSentence(new Sentence(str2));
        text.addSentence(new Sentence(str3));

        text.printTitle();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        text.print();
        System.out.println("=============================================================\n");
    }

    private static void task02() {
        System.out.println("2. Создать объект класса Автомобиль, используя классы Колесо,\n" +
                "Двигатель. Методы: ехать, заправляться, менять колесо, вывести\n" +
                "на консоль марку автомобиля.");
        System.out.println("-------------------------------------------------------------");

        Car toyotaAlphard = new Car("Toyota Alphard");
        System.out.printf("\t=== Создаем объект Автомобиль - %s ===\n", toyotaAlphard.getNameCar());
        System.out.println("Начинаем движение:");
        toyotaAlphard.drive();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        Engine engine = new Engine(300, 3.456f);
        toyotaAlphard.setEngine(engine);
        System.out.printf("+ Двигатель установлен.\n" +
                "Max мощность двигателя %d л.с объемом %.3f литров\n", engine.getPower(), engine.getVolume());
        System.out.println("Начинаем движение:");
        toyotaAlphard.drive();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        int wheelDiameter = 18;
        while (toyotaAlphard.getWheels().size() != 3) {
            toyotaAlphard.addWeels(wheelDiameter);
            toyotaAlphard.drive();
            System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        }
        toyotaAlphard.addWeels(wheelDiameter); // 4е колесо

        System.out.println("+ Колеса установлены.\n" +
                "Выбраны колеса " + Wheel.getDiameter() + " дюймов");
        System.out.println("Начинаем движение:");
        toyotaAlphard.drive();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        toyotaAlphard.getWheels().get(2).breakWheel();
        System.out.println("- В машине пробито колесо.");
        System.out.println("Пытаемся ехать:");
        toyotaAlphard.drive();
        toyotaAlphard.changeWheel();
        System.out.println("Едим дальше:");
        toyotaAlphard.drive();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("- В машине заканчивается топливо.");
        toyotaAlphard.setFuel(false);
        System.out.println("Пытаемся ехать:");
        toyotaAlphard.drive();
        toyotaAlphard.refuel();
        toyotaAlphard.drive();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println("Модель машины: " + toyotaAlphard.getNameCar());
        System.out.println("=============================================================\n");
    }

    private static void task03() {
        System.out.println("3. Создать объект класса Государство, используя классы\n" +
                "Область, Район, Город. Методы: вывести на консоль столицу,\n" +
                "количество областей, площадь, областные центры.");
        System.out.println("-------------------------------------------------------------");

        City[] citys = new City[]{
                new City("Гомель"),
                new City("Брест"),
        };

        Region[] regions = new Region[]{
                new Region("Бресткая область"),
                new Region("Витебсткая область"),
                new Region("Гомельская область"),
                new Region("Гродненская область"),
                new Region("Минская область"),
                new Region("Магилевская область")
        };

        District[] districts = new District[]{
                new District("Гомельский район"),
                new District("Бресткий район")

        };

        State belarus = new State("Беларусь", "Минск", 207.600, regions, districts);

        System.out.printf("\t\t=== Создан объект Государство - %s ===\n", belarus.getStateName());
        System.out.print("Сталица: ");
        belarus.printCapital();
        System.out.print("Количество областей = ");
        belarus.printNumOfRegions();
        System.out.print("Площадь государства = ");
        belarus.printSquare();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println("Областные центры:");
        belarus.printRegionsNames();
        System.out.println("=============================================================\n");
    }

    private static void task04() {
        System.out.println("4. Счета. Клиент может иметь несколько счетов в банке.\n" +
                "Учитывать возможность блокировки/разблокировки счета.\n" +
                "Реализовать поиск и сортировку счетов.\n" +
                "Вычисление общей суммы по счетам.\n" +
                "Вычисление суммы по всем счетам, имеющим положительный\n" +
                "и отрицательный балансы отдельно.");
        System.out.println("-------------------------------------------------------------");

        Bank bank = new Bank();

        Client client1 = new Client("Смирнов", "Алексей", "HB1234567");
        Client client2 = new Client("Попов", "Генадий", "HB2234567");
        Client client3 = new Client("Пупкин", "Дима", "HB3333333");

        bank.addNewClient(client1);
        bank.addNewClient(client2);
        bank.addNewClient(client3);

        client1.openAccount(new Account(101.15));
        client1.openAccount(new Account(299.99));
        client1.openAccount(new Account(-555.55));
        client1.openAccount(new Account(320.31));

        client2.openAccount(new Account(177.08));
        client2.openAccount(new Account(-100.65));
        client2.openAccount(new Account(1123.45));
        client2.openAccount(new Account(540.80));

        client3.openAccount(new Account(150.80));
        client3.openAccount(new Account(-42.75));
        client3.openAccount(new Account(1010.32));
        client3.openAccount(new Account(800.58));

        System.out.println("Информация по имеющимся клиентам банка:");
        System.out.println(client1.getInformation());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println(client2.getInformation());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println(client3.getInformation());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println(">>> Проверяем аккаунт на блакировку разблакировку: " + client1.getPassportID());
        System.out.println(bank.getClient("HB1234567").getAccount(1).getStatus());
        System.out.println("Блокируем счет 1:");
        bank.getClient("HB1234567").blockAccaunt(1);
        System.out.println(bank.getClient("HB1234567").getAccount(1).getStatus());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println(">>> Сортировка счетов по балансу:");
        bank.getClient("HB1234567").sortByBalance();
        System.out.println(bank.getClient("HB1234567").getInformation());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        bank.getClient("HB2234567").sortByBalance();
        System.out.println(bank.getClient("HB2234567").getInformation());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        bank.getClient("HB3333333").sortByBalance();
        System.out.println(bank.getClient("HB3333333").getInformation());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println(">>> Общая сумма по счетам в банке:");
        System.out.println(client1.toString());
        System.out.println(client1.getBalance());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println(client2.toString());
        System.out.println(client2.getBalance());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println(client3.toString());
        System.out.println(client3.getBalance());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println(">>> Общая сумма по счетам в банке, имеющим положительный баланс:");
        System.out.println(client1.toString());
        System.out.println(client1.getBalancePositiveAccounts());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println(client2.toString());
        System.out.println(client2.getBalancePositiveAccounts());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println(client3.toString());
        System.out.println(client3.getBalancePositiveAccounts());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println(">>> Общая сумма по счетам в банке, имеющим отрицательный баланс:");
        System.out.println(client1.toString());
        System.out.println(client1.getBalanceNegativeAccounts());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println(client2.toString());
        System.out.println(client2.getBalanceNegativeAccounts());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println(client3.toString());
        System.out.println(client3.getBalanceNegativeAccounts());
        System.out.println("=============================================================\n");
    }

    private static void task05() {
        System.out.println("5. Туристические путевки. Сформировать набор предложений\n" +
                "клиенту по выбору туристической путевки различного типа\n" +
                "(отдых, экскурсии, лечение, шопинг, круиз и т. д.)\n" +
                "для оптимального выбора. Учитывать возможность выбора\n" +
                "транспорта, питания и числа дней. Реализовать выбор\n" +
                "и сортировку путевок.");
        System.out.println("-------------------------------------------------------------");

        TourOperator travelOperator = new TourOperator("Pegas");
        Traveler traveler = new Traveler("Tom", "Cruise", 750.42);

        travelOperator.addTourPackage(
                new TourPackage("Italy",
                        "Rome",
                        TourPackageType.SHOPPING,
                        Transport.CAR,
                        TypeOfFood.NOT_INCLUDED,
                        5,
                        599.50));

        travelOperator.addTourPackage(
                new TourPackage("Italy",
                        "Venice",
                        TourPackageType.CRUISE,
                        Transport.SHIP,
                        TypeOfFood.BREAKFAST,
                        20,
                        1099.91));

        travelOperator.addTourPackage(
                new TourPackage("Italy",
                        "Milan",
                        TourPackageType.SHOPPING,
                        Transport.PLANE,
                        TypeOfFood.BREAKFAST,
                        3,
                        399.99));

        travelOperator.addTourPackage(
                new TourPackage("Italy",
                        "Florence",
                        TourPackageType.TREATMENT,
                        Transport.TRAIN,
                        TypeOfFood.ALL_INCLUSIVE,
                        13,
                        1099.11));

        travelOperator.addTourPackage(
                new TourPackage("Italy",
                        "Rome",
                        TourPackageType.EXCURSION,
                        Transport.PLANE,
                        TypeOfFood.ALL_INCLUSIVE,
                        10,
                        950.36));

        travelOperator.addTourPackage(
                new TourPackage("Spain",
                        "Barcelona",
                        TourPackageType.TREATMENT,
                        Transport.BUS,
                        TypeOfFood.ALL_INCLUSIVE,
                        7,
                        500.80));

        travelOperator.addTourPackage(
                new TourPackage("Spain",
                        "Salou",
                        TourPackageType.RECREATION,
                        Transport.PLANE,
                        TypeOfFood.ALL_INCLUSIVE,
                        14,
                        1699.89));

        travelOperator.addTourPackage(
                new TourPackage("Spain",
                        "Madrid",
                        TourPackageType.EXCURSION,
                        Transport.BUS,
                        TypeOfFood.NOT_INCLUDED,
                        5,
                        400.10));

        travelOperator.addTourPackage(
                new TourPackage("Spain",
                        "Barcelona",
                        TourPackageType.CRUISE,
                        Transport.SHIP,
                        TypeOfFood.BREAKFAST,
                        12,
                        1099.99));

        travelOperator.addTourPackage(
                new TourPackage("Spain",
                        "Malaga",
                        TourPackageType.RECREATION,
                        Transport.PLANE,
                        TypeOfFood.BREAKFAST,
                        15,
                        1400.20));

        System.out.println("Выбор по типу отыха выбрано лечение:");
        ArrayList<TourPackage> selectByType = travelOperator.selectByTourPackageType(TourPackageType.TREATMENT);
        TourOperator.printTours(selectByType);
        System.out.println("-------------------------------------------------------------");

        System.out.println("\nВыбор по типу транспорта выброн самолет:");
        ArrayList<TourPackage> selectByOption = travelOperator.selectByMoreOption(Transport.PLANE);
        TourOperator.sortByNumberOfDays(selectByOption);
        TourOperator.printTours(selectByOption);
        System.out.println("-------------------------------------------------------------");

        System.out.println("\nВыбор по количеству дней прибывания выбрано 7:");
        selectByOption = travelOperator.selectByMoreOption(7);
        TourOperator.sortByPrice(selectByOption);
        TourOperator.printTours(selectByOption);
        System.out.println("-------------------------------------------------------------");

        System.out.println("\nВыбор по типу таранспотра и питания выбран корабль и завтрак:");
        selectByOption = travelOperator.selectByMoreOption(Transport.SHIP, TypeOfFood.BREAKFAST);
        TourOperator.sortByPrice(selectByOption);
        TourOperator.printTours(selectByOption);
        System.out.println("-------------------------------------------------------------");

        System.out.println("\nВыбор по типу транспорта, питанию и количеству дней\n" +
                "было выбрано (поезд, все включино, 10 дней):");
        selectByOption = travelOperator.selectByMoreOption(Transport.TRAIN, TypeOfFood.ALL_INCLUSIVE, 10);
        TourOperator.sortByPrice(selectByOption);
        TourOperator.printTours(selectByOption);
        System.out.println("-------------------------------------------------------------");

        System.out.println("\nВыбор по типу транспорта, питанию и количеству дней\n" +
                "было выбрано (самолет, все включино, 14 дней):");
        selectByOption = travelOperator.selectByMoreOption(Transport.PLANE, TypeOfFood.ALL_INCLUSIVE, 14);
        TourOperator.sortByPrice(selectByOption);
        TourOperator.printTours(selectByOption);
        System.out.println("-------------------------------------------------------------");

        ArrayList<TourPackage> select = travelOperator.getTourPackages();
        System.out.println("\nТур агент определил что из " + select.size() + " пакетов");
        int numberPackage = 3;
        System.out.println("Путешественник выбрал 3 пакет");
        travelOperator.addClient(traveler, select.get(numberPackage));
        TourOperator.printTours(travelOperator.selectTour(numberPackage));
        //System.out.println(travelOperator.getClients().toString());
        System.out.println("=============================================================\n");
    }
}
