public class MoodException extends Exception implements Printable{
    public MoodException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return "\nПлохое настроение: " + super.getMessage();
    }
    @Override
    public String getPrintText() {
        return getMessage();
    }
}
