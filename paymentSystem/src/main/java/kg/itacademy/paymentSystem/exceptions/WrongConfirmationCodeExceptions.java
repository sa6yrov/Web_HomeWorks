package kg.itacademy.paymentSystem.exceptions;

public class WrongConfirmationCodeExceptions extends Exception{
    private static final String message = "Wrong confirmation code";

    public WrongConfirmationCodeExceptions(){
        super(message);
    }
}
