public class InvalidItemException extends RuntimeException {
    public InvalidItemException(String message) {
      super(message);
    }
    @Override
    public String getMessage() {
        return "\nОшибка взаимодействия с предметом: " + super.getMessage();
    }
}
