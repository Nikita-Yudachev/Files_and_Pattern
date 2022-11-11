public class WrongCredentialsException extends Exception {
    private String email;
    private String password;
    public WrongCredentialsException(String message, String email, String password) {
        super(message +", "+ email +", "+ password);
    }
}
