public class WaterBucket extends AbstractItem implements Pourable, Printable {
    private Printer printer;

    public WaterBucket(String title, Printer printer) {
        super(title);
        this.printer = printer;
    }

    @Override
    public void use(Emotionable target) {
        pour();
        target.changeMood(Mood.ANGRY);
    }

    @Override
    public void pour() {
        printer.print(this);
    }

    @Override
    public String getPrintText() {
        return "Вода с плеском выливается из ведра!";
    }

    @Override
    public String toString() {
        return "Ведро: " + getTitle();
    }
}