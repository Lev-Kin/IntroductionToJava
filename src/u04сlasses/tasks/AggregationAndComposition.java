package u04сlasses.tasks;

import u04сlasses.tasks.car.Car;
import u04сlasses.tasks.car.Engine;
import u04сlasses.tasks.car.Wheel;
import u04сlasses.tasks.text.Sentence;
import u04сlasses.tasks.text.Text;
import u04сlasses.tasks.text.Word;

public class AggregationAndComposition {
    public static void Tasks() {
        System.out.println("\t\t=== Агрегация и композиция ===\n");
        //task01();
        task02();
        //task03();
        //task04();
        //task05();
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


}
