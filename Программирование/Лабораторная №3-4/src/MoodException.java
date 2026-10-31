public class MoodException extends Exception {
    public MoodException(String message) {
        super(message);
    }
    @Override
    public String getMessage(){
        return "слишком плохое настроение: "+super.getMessage();
    }
}
