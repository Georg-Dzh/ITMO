public enum Mood implements Printable {
    CALM,
    ANGRY;

    @Override
    public String getPrintText() {
        return "Новое настроение: " + this.name();
    }
}