public record Article(String title, String content, Journalist author) implements Printable {
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public Journalist getAuthor() {
        return author;
    }
    @Override
    public String getPrintText(){
        return "Статья: " + title + "\nАвтор: " + author.getName();
    }
}
