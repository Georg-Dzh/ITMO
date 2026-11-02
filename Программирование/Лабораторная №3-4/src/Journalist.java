public class Journalist extends AbstractCharacter {
    public Journalist(String name, Opinion opinion, Mood mood) {
        super(name, opinion, mood);
    }

    @Override
    public void performDuty() throws MoodException {
        if (getMood() == Mood.ANGRY) {
            throw new MoodException("слишком зол, чтобы писать статьи.");
        }
        System.out.println("Журналист " + getName() + " пишет статью в газету со своим мнением: " + getOpinion());
    }

    public Article writeArticle(Newspaper newspaper, String articleTitle, String content) {
        super.useItem(newspaper, this);
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
