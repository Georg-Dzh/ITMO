public class Journalist extends AbstractCharacter {
    private Newspaper newspaper;

    public Journalist(String name, Opinion opinion, Mood mood, Newspaper newspaper) {
        super(name, opinion, mood);
        this.newspaper=newspaper;
    }

    @Override
    public void performDuty() throws MoodException {
        if (getMood() == Mood.ANGRY) {
            throw new MoodException("слишком зол, чтобы писать статьи.");
        } else {
            System.out.println("Журналист " + getName() + " пишет статью в газету со своим мнением: " + getOpinion());
            writeArticle(newspaper, "беспорядок на улицах", "Нам нужен тотальный контроль над ветрогонами!");
        }
    }

    public Article writeArticle(Newspaper newspaper, String articleTitle, String content) {
        System.out.println("Журналист " + getName() + " успешно публикует материалы в газете \"" + newspaper.getTitle() + "\".");
        Article newArticle = new Article(articleTitle, content, this);
        newArticle.printInfo();
        return newArticle;
    }

    @Override
    public String toString() {
        return "Журналист " + getName() + " (Мнение: " + getOpinion() + ", Настроение: " + getMood() + ")";
    }
}
