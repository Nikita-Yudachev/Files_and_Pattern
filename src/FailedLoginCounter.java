import java.util.HashMap;

public class FailedLoginCounter {
    private static FailedLoginCounter instance;

    public static synchronized FailedLoginCounter getInstance() {
        if (instance == null) {
            instance = new FailedLoginCounter();
        }
        return instance;
    }

    static HashMap<Account, Integer> accounts = new HashMap<>();

    public static void count(Account account) {
        if (!accounts.containsKey(account)) {
            accounts.put(account, 0);
        }
        accounts.put(account, accounts.get(account) + 1);
        if (accounts.get(account) == 5) {
            System.out.println("\nАккаунт блокируется, так как было 5 неудачных попыток входа " + "Почта " + account.getEmail()
                    + " Пароль " + account.getPassword());
            account.setBlocked();
        }
    }

    public static void clear(Account account) {
        accounts.remove(account);
    }
}
