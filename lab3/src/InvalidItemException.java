public class InvalidItemException extends RuntimeException implements Printable{

    public InvalidItemException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return "\nОшибка взаимодействия с предметом: " + super.getMessage();
    }
    @Override
    public String getPrintText() {
        return getMessage();
    }
}
