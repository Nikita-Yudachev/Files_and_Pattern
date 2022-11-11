import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String path = null;
        Scanner input = new Scanner(System.in);
        try {
            path = new File(".").getCanonicalPath() + "/data.csv";
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(path);

        if (file.exists()) {
            System.out.println("Файл data.csv удален, чтобы создать новый.");
            file.delete();
        }


        System.out.println("1. Нажмите enter, чтобы продолжить");
        input.nextLine(); // чтобы была пауза

        FileAccountManager manager = new FileAccountManager(path);
        Account a = new Account("Юдачев Никита", "01.10.2002", "n.yudachev@g.nsu.ru", "123456");
        Account b = new Account("Иванов Иван", "12.12.2005", "i.ivanov@g.nsu.ru", "654321");
        try {
            manager.register(a);
        } catch (AccountAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.register(b);
        } catch (AccountAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.register(a);
        } catch (AccountAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("2. Нажмите enter, чтобы продолжить");
        input.nextLine();

        try {
            manager.login("n.yudachev@g.nsu.ru", "12345");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        } catch (AccountBlockedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("3. Нажмите enter, чтобы продолжить");
        input.nextLine();

        try {
            manager.login("i.ivanov@g.nsu.ru", "65432");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        } catch (AccountBlockedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("4. Нажмите enter, чтобы продолжить");
        input.nextLine();

        try {
            manager.login("n.yudachev@g.nsu.ru", "12345");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        } catch (AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.login("n.yudachev@g.nsu.ru", "12345");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        } catch (AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.login("n.yudachev@g.nsu.ru", "12345");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        } catch (AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.login("n.yudachev@g.nsu.ru", "12345");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        } catch (AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.login("n.yudachev@g.nsu.ru", "123456");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        } catch (AccountBlockedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("5. Нажмите enter, чтобы продолжить");
        input.nextLine();

        try {
            manager.login("i.ivanov@g.nsu.ru", "65432");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        } catch (AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.login("i.ivanov@g.nsu.ru", "654321");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        } catch (AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.login("i.ivanov@g.nsu.ru", "65432");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        } catch (AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.login("i.ivanov@g.nsu.ru", "65432");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        } catch (AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.login("i.ivanov@g.nsu.ru", "65432");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        } catch (AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.login("i.ivanov@g.nsu.ru", "65432");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        } catch (AccountBlockedException e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.login("i.ivanov@g.nsu.ru", "654321");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        } catch (AccountBlockedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("6. Нажмите enter, чтобы продолжить");
        input.nextLine();

        try {
            manager.removeAccount("n.yudachev@g.nsu.ru", "123456");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.removeAccount("i.ivanov@g.nsu.ru", "65432");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.removeAccount("i.ivanov@g.nsu.ru", "654321");
        } catch (WrongCredentialsException e) {
            System.out.println(e.getMessage());
        }
    }
}
