public class Account {
    private final String FIO;
    private final String date_of_birth;
    private final String email;
    private final String password;
    private boolean blocked;

    public Account(String FIO, String date_of_birth, String email, String password) {
        this.FIO = FIO;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.password = password;
        this.blocked = false;

    }

    @Override
    public String toString() {
        return "Я " + FIO + ", моя дата рождения " + date_of_birth + " и моя почта " + email + ". Мой пароль " + password + ".";
    }

    public String getFIO() {
        return FIO;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked() {
        this.blocked = true;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
