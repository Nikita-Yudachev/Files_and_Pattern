import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileService {
    private static FileService instance;

    public static synchronized FileService getInstance() {
        if (instance == null) {
            instance = new FileService();
        }
        return instance;
    }

    public static List<Account> readCSV(String path) {
        List<List<String>> inf_accounts = new ArrayList<List<String>>();
        File file = new File(path);
        try {
            if (!file.exists()) {
                List<Account> group = new ArrayList<Account>();
                FileService.writeCSV(group, path);
                return group;
            }
            BufferedReader text = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String data = text.readLine();
            while ((data = text.readLine()) != null) {
                inf_accounts.add(Arrays.asList(data.split(",")));
            }
            text.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        List<Account> finalList = new ArrayList<Account>();
        for (List i : inf_accounts) {
            finalList.add(new Account(i.get(0).toString(), i.get(1).toString(), i.get(2).toString(), i.get(3).toString()));
        }
        return finalList;
    }

    public static void writeCSV(List<Account> group, String path) {
        try {
            BufferedWriter text = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path))); //, "UTF-8"
            text.write("ФИО, Дата рождения, Почта, Пароль");
            for (Account i : group) {
                text.write("\n" + i.getFIO() + "," + i.getDate_of_birth() + "," + i.getEmail() + "," + i.getPassword());
            }
            text.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
