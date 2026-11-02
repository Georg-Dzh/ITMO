public record Article(String title, String content, Journalist author) {
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public Journalist getAuthor() {
        return author;
    }

    public void printInfo() {
        System.out.println("Статья: " + title + "\nАвтор: " + author.getName());
    }
}
