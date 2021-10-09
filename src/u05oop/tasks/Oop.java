package u05oop.tasks;

import u05oop.tasks.file.Directory;
import u05oop.tasks.file.File;
import u05oop.tasks.file.TextFile;
import u05oop.tasks.payment.Payment;

public class Oop {
    public static void Tasks() {
        System.out.println("\t=== Задачи для закрепления навыков по теме ООП ===\n");
        //task01();
        task02();
        task03();
        //task04();
        //task05();
    }

    private static void task01() {
        System.out.println("Задача 1.\n" +
                "Создать объект класса Текстовый файл, используя классы Файл,\n" +
                "Директория. Методы: создать, переименовать,\n" +
                "вывести на консоль содержимое, дополнить, удалить.");
        System.out.println("-------------------------------------------------------------");
        Directory directory = new Directory("Directory");
        String nameFile = "What is Lorem Ipsum?.txt";
        TextFile textFile = new TextFile(directory, nameFile);

        String str = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        textFile.addText(str);

        System.out.println("Текстовый файл создан с именем:");
        System.out.println(textFile.getNameFile());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Меняем имя файла на \"Lorem Ipsum\"");
        textFile.changeName("Lorem Ipsum.txt");
        System.out.println(textFile.getNameFile());
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Выводим на экран содержимое текстогово файла:");
        textFile.printText();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Добовляем текст в текстовый файл и выводим содержимое файла:");
        String str2 = "\nLorem Ipsum был стандартным фиктивным текстом в отрасли с 1500-х годов,\n" +
                "когда неизвестный типограф взял камбуз и скремблировал его,\n" +
                "чтобы сделать книгу образцов шрифта.";
        textFile.addText(str2);
        textFile.printText();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Выдодим содержимое котолога " + directory.getName());
        for (File file : directory.getFiles()) {
            System.out.println(file);
        }
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("Создаем новый текстовый файл и выводим содержимое котолога:");
        File textFile2 = new TextFile(directory, "What is Lorem Ipsum?.txt");
        for (File file : directory.getFiles()) {
            System.out.println(file);
        }

        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println("Удаляем текстовый файл " + directory.getFiles().get(0) + " из дериктории");
        directory.removeFile(directory.getFiles().get(0).getNameFile());

        System.out.println("Выдодим содержимое котолога " + directory.getName());
        for (File file : directory.getFiles()) {
            System.out.println(file);
        }
        System.out.println("=============================================================\n");
    }

    private static void task02() {
        System.out.println("Задача 2.\n" +
                "Создать класс Payment с внутренним классом, с помощью объектов\n" +
                "которого можно сформировать покупку из нескольких товаров.");
        System.out.println("-------------------------------------------------------------");

        System.out.println("1. Создали класс Payment с внутреним классом.");
        Payment payment = new Payment();
        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");

        System.out.println("2. С помощью объектов формируем покупку из нескольких товаров.");
        String good = "Chacolate";
        double price = 5.15;
        double wight = 113;
        int amount = 7;
        Payment.Product product = payment.new Product(good, price, wight);
        payment.purchaseMultipleTheSameGoods(product, amount);
        System.out.println("Покупаем продукт в количесве " + amount + " штук.");
        product.print();

        System.out.println(".   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
        System.out.println("3. Выводим результат цену покупки:");
        System.out.printf("Итого: %.2f\n", payment.getTotalPayment());
        System.out.println("=============================================================\n");
    }

    private static void task03() {
        System.out.println("Задача 3.\n" +
                "Создать класс Календарь с внутренним классом,\n" +
                "с помощью объектов которого можно хранить информацию\n" +
                "о выходных и праздничных днях.");
        System.out.println("-------------------------------------------------------------");


        System.out.println("=============================================================\n");
    }
}
