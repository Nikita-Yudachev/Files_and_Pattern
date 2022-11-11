public class AccountAlreadyExistsException extends Exception{
    private String mail;
    public AccountAlreadyExistsException(String message,String email) {
        super(message+" "+email);
    }
}