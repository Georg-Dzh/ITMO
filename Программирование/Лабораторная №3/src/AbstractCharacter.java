import java.util.Objects;

public abstract class AbstractCharacter implements ItemInteractable, Emotionable, Opinionable, Printable {
    private String name;
    private Opinion opinion;
    private Mood mood;

    public AbstractCharacter(String name, Opinion opinion, Mood mood) {
        this.name = name;
        this.opinion = opinion;
        this.mood = mood;
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
        new ConsolePrinter().print(new Printable() {
            @Override
            public String getPrintText() {
                return name + " теперь в состоянии: " + newMood;
            }
        });
    }

    @Override
    public void changeOpinion(Opinion newOpinion) {
        this.opinion = newOpinion;
        new ConsolePrinter().print(new Printable() {
            @Override
            public String getPrintText() {
                return name + " теперь поддерживает: " + newOpinion;
            }
        });
    }

    @Override
    public String getPrintText() {
        return toString();
    }

    public abstract void performDuty(ConsolePrinter printer) throws MoodException;

    @Override
    public void useItem(AbstractItem item, Emotionable target) {
        if (item == null || item.getTitle() == null || item.getTitle().toLowerCase().contains("сломан")) {
            throw new InvalidItemException("Персонаж " + name + " не может использовать дефектный предмет!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCharacter that = (AbstractCharacter) o;
        return name.equals(that.name) && opinion == that.opinion && mood == that.mood;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, opinion, mood);
    }

    @Override
    public String toString() {
        return "Персонаж " + name + " (" + opinion + ", " + mood + ")";
    }
}