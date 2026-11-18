public class WaterBucket extends AbstractItem implements Pourable, Printable {
    private Printer printer;

    public WaterBucket(String title, Printer printer) {
        super(title);
        this.printer = printer;
    }

    @Override
    public String toString() {
        return "Ведро: " + getTitle();
    }

    @Override
    public String getPrintText() {
        return "Вода с плеском выливается из ведра!";
    }

    @Override
    public void pour() {
        printer.print(this);
    }
}