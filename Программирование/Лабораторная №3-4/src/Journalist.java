public class Journalist extends Personage {
    public Journalist(String name, Opinion opinion, Mood mood) {
        super(name, opinion, mood);
    }

    @Override
    public void performDuty() throws MoodException {
        if (getMood() == Mood.ANGRY) {
            throw new MoodException("Журналист " + getName() + " слишком зол, чтобы писать взвешенные статьи!");
        }
        System.out.println("Журналист " + getName() + " пишет статью в газету со своим мнением: " + getOpinion());
    }
    @Override
    public void writeArticle(Item newspaper, Article article) {
        super.useItem(newspaper, this); // Базовая проверка дефектов

        if (newspaper instanceof Newspaper) {
            System.out.println("Журналист " + getName() + " успешно публикует материалы в газете \"" + newspaper.getTitle() + "\".");
            article.printInfo();
        }
    }

    @Override
    public String toString() {
        return "Журналист " + getName() + " (Мнение: " + getOpinion() + ", Настроение: " + getMood() + ")";
    }
}
