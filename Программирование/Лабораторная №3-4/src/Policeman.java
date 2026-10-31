public class Policeman extends Personage {
    public Policeman(String name, Opinion opinion, Mood mood) {
        super(name, opinion, mood);
    }
    @Override
    public void performDuty() throws MoodException {
        System.out.println("Милиционер " + getName() + " следит за порядком на улице.");
    }
    @Override
    public String toString() {
        return "Милиционер " + getName() + " (Мнение: " + getOpinion() + ", Настроение: " + getMood() + ")";
    }
}
