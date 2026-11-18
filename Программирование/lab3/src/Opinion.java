public enum Opinion implements Printable {
    MILITIA,
    SOCIETY,
    NEUTRAL;

    @Override
    public String getPrintText() {
        return "Новое мнение: " + this.name();
    }
}
