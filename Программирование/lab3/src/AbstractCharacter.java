import java.util.Objects;

public abstract class AbstractCharacter implements ItemInteractable, Emotionable, Opinionable, Printable {
    private String name;
    private Opinion opinion;
    private Mood mood;
    private Printer printer;

    public AbstractCharacter(String name, Opinion opinion, Mood mood, Printer printer) {
        this.name = name;
        this.opinion = opinion;
        this.mood = mood;
        this.printer = printer;
    }

    protected Printer getPrinter() {
        return printer;
    }

    public String getName() {
        return name;
    }

    public Opinion getOpinion() {
        return opinion;
    }

    public Mood getMood() {
        return mood;
    }

    @Override
    public void changeMood(Mood newMood) {
        this.mood = newMood;
        printer.print("Персонаж " + name + " теперь в настроении " + newMood);
    }

    @Override
    public void changeOpinion(Opinion newOpinion) {
        this.opinion = newOpinion;
        printer.print("Персонаж " + name + " теперь поддерживает " + newOpinion);
    }

    @Override
    public String getPrintText() {
        return toString() + ", настроение: " + mood + ", мнение: " + opinion;
    }

    public abstract void performDuty() throws MoodException;

    @Override
    public void useItem(AbstractItem item, Emotionable target) {
        if (item == null || item.getTitle() == null) {
            throw new InvalidItemException("Персонаж " + name + " не может использовать дефектный предмет!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractCharacter that = (AbstractCharacter) o;
        return name.equals(that.name) && opinion == that.opinion && mood == that.mood;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, opinion, mood);
    }

    @Override
    public String toString() {
        return "Персонаж " + name;
    }
}