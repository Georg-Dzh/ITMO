public class Policeman extends AbstractCharacter {

    public Policeman(String name, Opinion opinion, Mood mood, Printer printer) {
        super(name, opinion, mood, printer);
    }

    @Override
    public String getPrintText() {
        return "Полицейский " + getName() + " патрулирует улицы и следит за порядком (мнение: " + getOpinion() + ")";
    }

    @Override
    public void performDuty() throws MoodException {
        if (getMood() == Mood.ANGRY) {
            throw new MoodException("слишком зол, чтобы патрулировать.");
        }
        getPrinter().print(this);
    }
}