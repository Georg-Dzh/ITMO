public class Policeman extends AbstractCharacter {
    public Policeman(String name, Opinion opinion, Mood mood) {
        super(name, opinion, mood);
    }

    @Override
    public void performDuty(ConsolePrinter printer) throws MoodException {
        if (getMood() == Mood.ANGRY) {
            throw new MoodException("слишком зол для патрулирования улиц.");
        } else {
            printer.print(new Printable() {
                @Override
                public String getPrintText() {
                    return "Милиционер " + getName() + " следит за порядком на улице.";
                }
            });
        }
    }

    @Override
    public String toString() {
        return "Милиционер " + getName() + " (Мнение: " + getOpinion() + ", Настроение: " + getMood() + ")";
    }
}