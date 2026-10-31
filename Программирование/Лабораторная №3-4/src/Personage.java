public abstract class Personage implements ItemUser {
    private String name;
    private Opinion opinion;
    private Mood mood;

    public Personage(String name, Opinion opinion, Mood mood) {
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

    public void becomeAngry() {
        mood = Mood.ANGRY;
        System.out.println(name + " разозлился.");
    }

    public void becomeCalm() {
        mood = Mood.CALM;
        System.out.println(name + " успокоился.");
    }

    public void changeOpinion(Opinion newOpinion) {
        opinion = newOpinion;
        System.out.println(name + " теперь " + newOpinion);
    }
    public abstract void performDuty() throws MoodException;

    @Override
    public void useItem(Item item, Personage target) {
        if (item == null || item.getTitle() == null || item.getTitle().toLowerCase().contains("сломан")) {
            throw new InvalidItemException("Персонаж " + name + " не может использовать дефектный предмет!");
        }
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Personage that) && getClass() == o.getClass() && name.equals(that.name) && opinion == that.opinion && mood == that.mood;
    }
    @Override
    public int hashCode() {
        return name.hashCode() + opinion.ordinal() + mood.ordinal();
    }

    @Override
    public String toString() {
        return "Персонаж " + name + " (" + opinion + ", " + mood + ")";
    }
}
