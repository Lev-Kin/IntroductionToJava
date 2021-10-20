package u06finish.tasks;

import u06finish.tasks.library.ConsoleApplicationHomeLibrary;

public class FinishTasks {
    public static void Tasks() {
        System.out.println("\t\t=== Заключительная задача по курсу ===\n");
        task01();
    }

    private static void task01() {
        System.out.println("Задача 1. \n" +
                "Создать консольное приложение “Учет книг в домашней библиотеке”.\n" +
                "Общие требования к заданию:\n" +
                "• Система учитывает книги как в электронном, так и в бумажном\n" +
                "  варианте.\n" +
                "• Существующие роли: пользователь, администратор.\n" +
                "• Пользователь может просматривать книги в каталоге книг,\n" +
                "  осуществлять поиск книг в каталоге.\n" +
                "• Администратор может модифицировать каталог.\n" +
                "• *При добавлении описания книги в каталог оповещение о ней\n" +
                "  рассылается на e-mail всем пользователям\n" +
                "• **При просмотре каталога желательно реализовать постраничный\n" +
                "  просмотр\n" +
                "• ***Пользователь может предложить добавить книгу в библиотеку,\n" +
                "  переслав её администратору на e-mail.\n" +
                "• Каталог книг хранится в текстовом файле.\n" +
                "• Данные аутентификации пользователей хранятся в текстовом файле.\n" +
                "  Пароль не хранится в открытом виде");
        System.out.println("-------------------------------------------------------------");
        ConsoleApplicationHomeLibrary.onLaunch();
        System.out.println("=============================================================\n");
    }
}
