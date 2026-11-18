import java.util.ArrayList;
import java.util.List;

public class Newspaper extends AbstractItem implements Printable {
    private List<Article> articles = new ArrayList<>();

    public Newspaper(String title) {
        super(title);
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    public Stats getStats() {
        return new Stats(articles.size());
    }

    @Override
    public String getPrintText() {
        return "В газете \"" + getTitle() + "\" успешно опубликованы новые материалы.";
    }

    @Override
    public String toString() {
        return "Печатное издание: " + getTitle();
    }

    public static class Stats implements Printable {
        private final int count;

        public Stats(int count) {
            this.count = count;
        }

        @Override
        public String getPrintText() {
            return "Всего статей в газете: " + count;
        }
    }
}