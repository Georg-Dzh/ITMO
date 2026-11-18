public class Journalist extends AbstractCharacter {
    private Newspaper newspaper;

    public Journalist(String name, Opinion opinion, Mood mood, Printer printer, Newspaper newspaper) {
        super(name, opinion, mood, printer);
        this.newspaper = newspaper;
    }

    @Override
    public void performDuty() throws MoodException {
        if (getMood() == Mood.ANGRY) {
            throw new MoodException("слишком зол, чтобы писать статьи.");
        }
        getPrinter().print(this);
        Article article = writeArticle("беспорядок на улицах", "Нам нужен тотальный контроль над ветрогонами!");
        getPrinter().print(article);
    }

    public Article writeArticle(String title, String content) {
        Article article = new Article(title, content, this);
        newspaper.addArticle(article);
        getPrinter().print(newspaper);
        getPrinter().print(newspaper.getStats());
        return article;
    }

    @Override
    public String toString() {
        return "Журналист " + getName() + " (Мнение: " + getOpinion() + ", Настроение: " + getMood() + ")";
    }
}