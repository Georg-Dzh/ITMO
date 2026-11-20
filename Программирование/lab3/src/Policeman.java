public class Policeman extends AbstractCharacter {

    public Policeman(String name, Opinion opinion, Mood mood, Printer printer) {
        super(name, opinion, mood, printer);
    }

    @Override
    public void performDuty() throws MoodException {
        if (getMood() == Mood.ANGRY) {
            throw new MoodException("слишком зол, чтобы патрулировать.");
        }
        getPrinter().print("Полицейский " + getName() + " патрулирует улицы и следит за порядком");
    }

    @Override
    public String toString() {
        return "Полицейский " + getName();
    }
}