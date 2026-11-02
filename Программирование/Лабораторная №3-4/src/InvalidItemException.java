public class InvalidItemException extends RuntimeException {
    public InvalidItemException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return "Ошибка взаимодействия с предметом: " + super.getMessage();
    }
}
