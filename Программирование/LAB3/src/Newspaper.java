public class Newspaper extends AbstractItem {
    public Newspaper(String title) {
        super(title);
    }
    @Override
    public String toString() {
        return "Печатное издание: " + getTitle();
    }
}
