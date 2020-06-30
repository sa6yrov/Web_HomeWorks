package kg.itacademy.paymentSystem.exceptions;

public class WrongCodeWordException extends Exception {
    public static final String message = "Wrong code word";

    public WrongCodeWordException(){
        super(message);
    }
}
