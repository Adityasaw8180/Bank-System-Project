package ExceptionPackages;

public class AccountNotFound extends Exception{
    public AccountNotFound(String str){
        super(str);
    }
}