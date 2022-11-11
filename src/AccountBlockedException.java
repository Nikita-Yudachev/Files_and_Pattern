public class AccountBlockedException extends Exception{
    private String email;
    private String password;
    public AccountBlockedException(String message, String email, String password) {
        super(message +", "+ email +", "+ password);
    }
}
