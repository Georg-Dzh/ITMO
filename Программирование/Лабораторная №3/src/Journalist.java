public class Journalist extends AbstractCharacter {
    private Newspaper newspaper;

    public Journalist(String name, Opinion opinion, Mood mood, Newspaper newspaper) {
        super(name, opinion, mood);
        this.newspaper = newspaper;
    }

    @Override
    public void performDuty(ConsolePrinter printer) throws MoodException {
        if (getMood() == Mood.ANGRY) {
            throw new MoodException("слишком зол, чтобы писать статьи.");
        } else {
            printer.print(new Printable() {
                @Override
                public String getPrintText() {
                    return "Журналист " + getName() + " пишет статью в газету со своим мнением: " + getOpinion();
                }
            });
            Article article = writeArticle("беспорядок на улицах", "Нам нужен тотальный контроль над ветрогонами!");
            printer.print(article);
        }
    }

    public Article writeArticle(String title, String content) {
        new ConsolePrinter().print(new Printable() {
            @Override
            public String getPrintText() {
                return "Журналист " + getName() + " успешно публикует материалы в газете \"" + newspaper.getTitle() + "\".";
            }
        });

        return new Article(title, content, this);
    }

    @Override
    public String toString() {
        return "Журналист " + getName() + " (Мнение: " + getOpinion() + ", Настроение: " + getMood() + ")";
    }
}