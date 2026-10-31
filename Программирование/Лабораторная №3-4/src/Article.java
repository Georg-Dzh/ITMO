public record Article(String title, String content, String authorName) {
    public void printInfo() {
        System.out.println("Статья: " + title + " Автор: " + authorName);
    }
}
