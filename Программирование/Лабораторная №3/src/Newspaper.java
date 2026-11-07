import java.util.ArrayList;
import java.util.List;
public class Newspaper extends AbstractItem {
    private List<Article> articles = new ArrayList<>();
    public Newspaper(String title) {
        super(title);
    }
    @Override
    public String toString() {
        return "Печатное издание: " + getTitle();
    }
}
