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
        writeArticle("беспорядок на улицах","Нам нужен тотальный контроль над ветрогонами!");
    }

    public Article writeArticle(String title, String content) {
        Article article = new Article(title, content, this);
        newspaper.addArticle(article);
        article.printTo(getPrinter());
        newspaper.printTo(getPrinter());
        newspaper.getStats().printTo(getPrinter());
        return article;
    }

    @Override
    public String toString() {
        return "Журналист " + getName();
    }
}