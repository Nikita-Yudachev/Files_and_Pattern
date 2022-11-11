import java.util.List;
import java.util.Objects;

public class FileAccountManager implements AccountManager {
    private static List<Account> group;
    private final String path;

    public FileAccountManager(String str) {
        path = str;
        group = FileService.readCSV(path);
    }

    public void register(Account account) throws AccountAlreadyExistsException {
        for (Account i : group) {
            if (i.getEmail().equals(account.getEmail())) {
                throw new AccountAlreadyExistsException("Данный аккаунт уже занят и его почта:", account.getEmail());
            }
        }
        group.add(account);
        FileService.writeCSV(group, path);

    }

    public Account login(String email, String password) throws WrongCredentialsException, AccountBlockedException {
        Account account = null;
        for (Account i : group) {
            if (Objects.equals(i.getEmail(), email)) {
                account = i;
            }
        }
        if (account != null) {
            if (Objects.equals(account.getPassword(), password)) {
                if (!account.isBlocked()) {
                    FailedLoginCounter.clear(account);
                    System.out.println("Успешно вошли в аккаунт. Почта " + account.getEmail() + " Пароль " + account.getPassword());
                    return account;
                } else {
                    throw new AccountBlockedException("Аккаунт заблокирован, при попытке" +
                            " входа были введены следующая почта и пароль ", email, password);
                }
            } else {
                FailedLoginCounter.count(account);
                throw new WrongCredentialsException("Аккаунт не найден, неверный пароль при попытке входа: ", email, password);
            }
        } else {
            FailedLoginCounter.count(account);
            throw new WrongCredentialsException("Аккаунт не найден, неверные данный при попытке входа: ", email, password);
        }
    }

    public void removeAccount(String email, String password) throws WrongCredentialsException {
        int k = 0;
        if (group.size() > 1) {
            for (Account i : group) {
                if (Objects.equals(i.getEmail(), email)) {
                    if (Objects.equals(i.getPassword(), password)) {
                        System.out.println("Аккаунт успешно удален. Почта " + email + " Пароль " + password);
                        group.remove(i);
                        FileService.writeCSV(group, path);
                        k += 1;
                    }
                }
            }
        }
        if (group.size() == 1) {
            if (Objects.equals(group.get(0).getEmail(), email)) {
                if (Objects.equals(group.get(0).getPassword(), password)) {
                    System.out.println("Аккаунт успешно удален. Почта " + email + " Пароль " + password);
                    group.remove(group.get(0));
                    FileService.writeCSV(group, path);
                    k += 1;
                }
                if (k == 0) {
                    throw new WrongCredentialsException("Удалить аккаунт невозможно, неверные данные почты и пароля", email, password);
                }
            }
        }
    }
}
